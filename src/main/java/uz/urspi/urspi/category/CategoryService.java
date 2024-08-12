package uz.urspi.urspi.category;

import java.util.List;

public interface CategoryService {

    void createCategory(Category category);

    void updateCategory(Long categoryId, Category category);

    void deleteCategory(Long categoryId);

    Category getCategory(Long categoryId);

    List<Category> getAllCategories();

    boolean isCategoryExist(String categoryName);
}
