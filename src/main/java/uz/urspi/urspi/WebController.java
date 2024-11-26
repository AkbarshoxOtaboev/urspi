package uz.urspi.urspi;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.urspi.urspi.category.Category;
import uz.urspi.urspi.category.CategoryService;
import uz.urspi.urspi.menu.Menu;
import uz.urspi.urspi.menu.MenuService;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class  WebController {
    private final CategoryService categoryService;
    private final MenuService menuService;
    @GetMapping("/")
    public  String getIndex(Model model){
        List<Menu> menus = menuService.findByStatus(1);
        model.addAttribute("menus", menus);
        return "index";
    }

    @GetMapping("/statute")
    public  String getStatute(Model model){
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "client/statute";
    }
}
