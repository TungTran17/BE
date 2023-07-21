package com.testproject.swp.service.impl;

import com.testproject.swp.entity.Category;
import com.testproject.swp.exception.custom.CustomNotFoundEx;
import com.testproject.swp.model.category.dto.CategoryDTO;
import com.testproject.swp.model.category.mapper.CategoryMapper;
import com.testproject.swp.repository.CategoryRepository;
import com.testproject.swp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getCategorys()throws CustomNotFoundEx {
        List<Category> categorys = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOs = new ArrayList<>();
        for (Category category: categorys){
            categoryDTOs.add(CategoryMapper.toGet(category));
        }
        return categoryDTOs;
    }
}
