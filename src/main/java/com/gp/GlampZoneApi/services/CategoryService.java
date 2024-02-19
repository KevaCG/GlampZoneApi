package com.gp.GlampZoneApi.services;

import com.gp.GlampZoneApi.entities.Category;
import com.gp.GlampZoneApi.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return (List<Category>) categoryRepository.findAll();
    }

    public Optional<Category> getCategory(Long id){
        return categoryRepository.findById(id);
    }

    public Category postCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category putCategory(Category request, Long id){

        Category category = categoryRepository.findById(id).get();

        category.setCategoryName(request.getCategoryName());

        return category;
    }

    public Boolean deleteCategory(Long id){
        try {
            categoryRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
