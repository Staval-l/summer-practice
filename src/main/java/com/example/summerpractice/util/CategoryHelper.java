package com.example.summerpractice.util;

import com.example.summerpractice.model.Category;
import lombok.experimental.UtilityClass;

import java.util.Comparator;

@UtilityClass
public class CategoryHelper {
    public static Comparator<Category> getCategoryComparator() {
        return Comparator.comparing(Category::getId);
    }
}
