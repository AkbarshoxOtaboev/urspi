package uz.urspi.urspi.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImplement implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public void createCategory(Category category) {
        category.setStatus(1);
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Long categoryId, Category category) {
        var updCategory = categoryRepository.findById(categoryId).orElseThrow();
        updCategory.setName(category.getName());
        updCategory.setStatus(category.getStatus());
        categoryRepository.saveAndFlush(updCategory);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        var updCategory = categoryRepository.findById(categoryId).orElseThrow();
        updCategory.setStatus(0);
        categoryRepository.saveAndFlush(updCategory);
    }

    @Override
    public Category getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow();
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean isCategoryExist(String categoryName) {
        return categoryRepository.existsByName(categoryName);
    }
}
