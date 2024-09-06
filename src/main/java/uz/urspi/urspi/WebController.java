package uz.urspi.urspi;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.urspi.urspi.category.Category;
import uz.urspi.urspi.category.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class  WebController {
    private final CategoryService categoryService;
    @GetMapping("/")
    public  String getIndex(Model model){
        return "index";
    }

    @GetMapping("/statute")
    public  String getStatute(Model model){
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "client/statute";
    }
}
