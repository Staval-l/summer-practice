package com.example.summerpractice.controller;

import com.example.summerpractice.dto.ResponseGetDto;
import com.example.summerpractice.dto.category.CategoryPostDto;
import com.example.summerpractice.model.Category;
import com.example.summerpractice.service.CategoryService;
import com.example.summerpractice.util.ResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
@Validated
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    //private final CategoryMapper categoryMapper;

    @PutMapping
    public ResponseGetDto<Category> createCategory(@RequestBody CategoryPostDto request) {
        //return ResponseFactory.createSuccessfulResponse(categoryMapper.toDto(categoryService.createCategory(request.getName())));
        return ResponseFactory.createSuccessfulResponse(categoryService.createCategory(request.getName()));
    }

    @GetMapping("/all")
    public ResponseGetDto<List<Category>> getAll() {
//        return ResponseFactory.createSuccessfulResponse(categoryService.getAllCategories().stream()
//                .map(categoryMapper::toDto)
//                .collect(Collectors.toList()));
        return ResponseFactory.createSuccessfulResponse(categoryService.getAllCategories().stream().collect(Collectors.toList()));
    }
}
