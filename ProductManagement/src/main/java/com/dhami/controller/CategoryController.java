package com.dhami.controller;

import com.dhami.dto.CategoryDTO;
import com.dhami.exception.CategoryAlreadyExistsException;
import com.dhami.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
private CategoryService categoryService;
    //get all categories
    // create categories
    // get category by id
    // delete

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> creteCategory(@RequestBody CategoryDTO categoryDTO){
//        globly handle this
//        try {
//            CategoryDTO savedCategory = categoryService.createCategory(categoryDTO);
//            return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
//        }
//        catch (CategoryAlreadyExistsException e){
//             return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//        }
           //return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
        CategoryDTO savedCategory = categoryService.createCategory(categoryDTO);
          return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
    public List<CategoryDTO> getAllCategories(){
           return categoryService.getAllCategories();
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id){
       return categoryService.getCategoryById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
        return categoryService.deleteCategory(id);
    }
}
