package uz.urspi.urspi;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import uz.urspi.urspi.category.Category;
import uz.urspi.urspi.category.CategoryService;
import uz.urspi.urspi.menu.Menu;
import uz.urspi.urspi.menu.MenuService;
import uz.urspi.urspi.news.News;
import uz.urspi.urspi.news.NewsService;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class  WebController {
    private final CategoryService categoryService;
    private final MenuService menuService;
    private final NewsService newsService;

    @GetMapping("/")
    public  String getIndex(Model model){
        List<Menu> menus = menuService.findByStatus(1);
        model.addAttribute("menus", menus);
        return "index";
    }
    @GetMapping("/news")
    public String getNews(Model model,
                          Pageable pageable){
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        List<News> newsList = newsService.getAllNews();
        Page<News> newsPage = newsService.fetchPageableNews(pageable);
        model.addAttribute("newsList", newsList);
        model.addAttribute("newsPage", newsPage);
        return "news";
    }

    @GetMapping("/news/pageable")
    @ResponseBody
    public Page<News> pageableNews(Pageable pageable) {
        return newsService.fetchPageableNews(pageable);
    }


    @GetMapping("/statute")
    public  String getStatute(Model model){
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "client/statute";
    }
}
