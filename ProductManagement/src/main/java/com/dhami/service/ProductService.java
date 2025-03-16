package com.dhami.service;

import com.dhami.dto.ProductDTO;
import com.dhami.entity.Category;
import com.dhami.entity.Product;
import com.dhami.exception.CategoryNotFoundException;
import com.dhami.mapper.ProductMapper;
import com.dhami.repository.CategoryRepository;
import com.dhami.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductDTO createProduct(ProductDTO productDTO){
        Category category = categoryRepository.findById(productDTO.getCategory_id())
                .orElseThrow(()-> new CategoryNotFoundException("Category id "+ productDTO.getCategory_id()+" not found"));
        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepository.save(product);
        return  ProductMapper.toProductDTO(product);

    }

    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }

    public ProductDTO getProductById(Long id){
       Product product = productRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("Product not found"));
       return ProductMapper.toProductDTO(product);
    }

    //update

    public ProductDTO updateProduct(Long id, ProductDTO productDTO){

        Product product = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found"));
        Category category = categoryRepository.findById(productDTO.getCategory_id())
                .orElseThrow(()-> new RuntimeException("Category not found"));
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "Product" + id + "has been deleted";
    }
}
