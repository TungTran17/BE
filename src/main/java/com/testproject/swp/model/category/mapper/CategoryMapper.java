package com.testproject.swp.model.category.mapper;

import com.testproject.swp.entity.Category;
import com.testproject.swp.entity.Role;
import com.testproject.swp.model.category.dto.CategoryDTO;
import com.testproject.swp.model.role.dto.RolesDTO;

public class CategoryMapper {
    public static CategoryDTO toGet(Category category) {
        return CategoryDTO.builder()
                .CategoryId(category.getCategory_id())
                .CategoryName(category.getCategory_name())
                .CategoryIcon(category.getIcon())
                .build();
    }
}
