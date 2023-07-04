package com.example.summerpractice.service;

import com.example.summerpractice.model.Category;
import com.example.summerpractice.repository.CategoryRepository;
import com.example.summerpractice.util.CategoryHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return StreamSupport.stream(categoryRepository.findAll().spliterator(), false)
                .sorted(CategoryHelper.getCategoryComparator())
                .collect(Collectors.toList());
    }

    public Optional<Category> getById(Integer id) {
        return categoryRepository.findById(id);
    }
}
