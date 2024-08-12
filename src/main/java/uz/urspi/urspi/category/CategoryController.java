package uz.urspi.urspi.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uz.urspi.urspi.user.User;
import uz.urspi.urspi.user.UserService;

import java.util.List;

@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final UserService userService;

    @GetMapping("")
    public String getCategoryPage(Model model) {
        User user =userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("title", "Category");
        Category category = new Category();
        model.addAttribute("category", category);
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "/admin/category";
    }

    @PostMapping("/create")
    public String createCategory(Category category) {
        if(categoryService.isCategoryExist(category.getName())) {
            return "redirect:/category?error_name";
        }else {
            categoryService.createCategory(category);
            return "redirect:/category?success";
        }
    }

    @GetMapping("/delete")
    public String deleteCategory(Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/category";
    }

    @GetMapping("/edit/getOne")
    @ResponseBody
    public Category getOneCategory(Long id) {
        return categoryService.getCategory(id);
    }

    @PostMapping("/edit")
    public String editCategory(Category category) {
        categoryService.updateCategory(category.getId(), category);
        return "redirect:/category";
    }



}
