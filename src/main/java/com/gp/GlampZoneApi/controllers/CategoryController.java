package com.gp.GlampZoneApi.controllers;

import com.gp.GlampZoneApi.entities.Category;
import com.gp.GlampZoneApi.repositories.CategoryRepository;
import com.gp.GlampZoneApi.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public List<Category> getAllCategoriesController(){
        return this.categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoryController(@PathVariable Long id){
        return this.categoryService.getCategory(id);
    }

    @PostMapping("/")
    public Category postCategoryController(@RequestBody Category category){
        return this.categoryService.postCategory(category);
    }

    @PutMapping("/{id}")
    public Category putCategoryController(@RequestBody Category category, @PathVariable("id") Long id){
        return this.categoryService.putCategory(category, id);
    }

    @DeleteMapping("/{id}")
    public String deleteCategoryController(@PathVariable("id") Long id){
        boolean ok = this.categoryService.deleteCategory(id);

        if(ok){
            return "Eliminado";
        }else{
            return "Error, intentelo nuevamente";
        }
    }
}
