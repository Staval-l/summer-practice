package com.example.summerpractice.mapper;

import org.mapstruct.Mapper;
import com.example.summerpractice.model.Category;
import com.example.summerpractice.dto.category.CategoryGetDto;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.summerpractice")
@Mapper(config = MapConfig.class)
public interface  CategoryMapper {
    CategoryGetDto toDto(Category category);
}
