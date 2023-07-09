package com.example.summerpractice.controller;

import com.example.summerpractice.dto.ResponseGetDto;
import com.example.summerpractice.dto.category.CategoryGetDto;
import com.example.summerpractice.dto.category.CategoryPostDto;
import com.example.summerpractice.mapper.CategoryMapper;
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
    private final CategoryMapper categoryMapper;

    @PutMapping
    public ResponseGetDto<CategoryGetDto> createCategory(@RequestBody CategoryPostDto request) {
        return ResponseFactory.createSuccessfulResponse(categoryMapper.toDto(categoryService.createCategory(request.getName())));
    }

    @GetMapping("/all")
    public ResponseGetDto<List<CategoryGetDto>> getAll() {
        return ResponseFactory.createSuccessfulResponse(categoryService.getAllCategories().stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList()));
    }
}
