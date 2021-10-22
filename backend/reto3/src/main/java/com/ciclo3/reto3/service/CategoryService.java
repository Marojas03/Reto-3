package com.ciclo3.reto3.service;

import com.ciclo3.reto3.model.Category;
import com.ciclo3.reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return  categoryRepository.getCategory(id);
    }

    public Category save(Category p){
        if(p.getId() == null){
            return categoryRepository.save(p);
        }else{
            Optional<Category> categoryOptional = categoryRepository.getCategory(p.getId());
            if(categoryOptional.isEmpty()){
                return categoryRepository.save(p);
            }else{
                return p;
            }
        }
    }
}
