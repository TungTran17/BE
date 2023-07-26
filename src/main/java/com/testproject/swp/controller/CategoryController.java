package com.testproject.swp.controller;

import com.testproject.swp.exception.custom.CustomNotFoundEx;
import com.testproject.swp.model.category.dto.CategoryDTO;
import com.testproject.swp.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/Category/listCategory")
    public List<CategoryDTO> getCategorys() throws CustomNotFoundEx {
        return categoryService.getCategorys();
    }
}
