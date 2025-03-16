package com.dhami.service;

import com.dhami.dto.CategoryDTO;
import com.dhami.entity.Category;
import com.dhami.exception.CategoryAlreadyExistsException;
import com.dhami.mapper.CategoryMapper;
import com.dhami.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
   private CategoryRepository categoryRepository;
    // get all categories
    // create category
    // get category by id
    // delete category

    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Optional<Category> optionalCategory = categoryRepository.findByName(categoryDTO.getName());
        if(optionalCategory.isPresent()){
            throw new CategoryAlreadyExistsException("Category "+
                    categoryDTO.getName()+" already exists");
        }
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }

    public List<CategoryDTO> getAllCategories(){
        return categoryRepository.findAll().stream().map(CategoryMapper:: toCategoryDTO).toList();

    }

    public CategoryDTO getCategoryById(Long id){
        Category category =categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not found"));
          return CategoryMapper.toCategoryDTO(category);
    }

    public String deleteCategory(Long id){
        categoryRepository.deleteById(id);
        return "Category"+ id + "has been deleted";
    }

}
