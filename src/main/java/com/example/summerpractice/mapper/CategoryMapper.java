package com.example.summerpractice.mapper;

import org.mapstruct.Mapper;
import com.example.summerpractice.model.Category;
import com.example.summerpractice.dto.category.CategoryGetDto;

@Mapper(config = MapConfig.class)
public interface  CategoryMapper {
    CategoryGetDto toDto(Category category);
}
