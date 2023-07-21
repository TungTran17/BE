package com.testproject.swp.service;

import java.util.List;

import com.testproject.swp.exception.custom.CustomNotFoundEx;
import com.testproject.swp.model.category.dto.CategoryDTO;


public interface CategoryService {
    
    public List<CategoryDTO> getCategorys() throws CustomNotFoundEx;

}
