package uz.urspi.urspi.news;

import org.springframework.core.io.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.urspi.urspi.category.Category;
import uz.urspi.urspi.category.CategoryService;
import uz.urspi.urspi.department.Department;
import uz.urspi.urspi.department.DepartmentService;
import uz.urspi.urspi.image.Image;
import uz.urspi.urspi.image.ImageService;
import uz.urspi.urspi.storage.StorageService;
import uz.urspi.urspi.user.User;
import uz.urspi.urspi.user.UserService;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;
    private final UserService userService;
    private final StorageService storageService;
    private final DepartmentService departmentService;
    private final CategoryService categoryService;
    private final ImageService imageService;

    @GetMapping("/news")
    public String getNewsPage(Model model) {
        User user =userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("title", "News");
        List<News> newsList = newsService.getAllNews();
        model.addAttribute("newsList", newsList);
        return "/admin/news";
    }

    @GetMapping("/news/create")
    public String createNewsPage(Model model) {
        User user =userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("title", "News");
        NewsDTO newsDTO = new NewsDTO();
        model.addAttribute("newsDTO", newsDTO);
        List<Department> departments = departmentService.fetchAllDepartments();
        model.addAttribute("departments", departments);
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "/admin/news/newsCreate";
    }

    @PostMapping("/news/create")
    public String createNews(NewsDTO newsDTO) throws Exception {
        newsService.createNews(newsDTO);
        return "redirect:/dashboard/news";
    }

    @GetMapping("/news/all")
    @ResponseBody
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }

    @GetMapping("/news/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);

        if (file == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/news/edit")
    public String editNewsPage(Model model, Long id) {
        User user =userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("title", "Yangliklni o`zgartirish");
        List<Department> departments = departmentService.fetchAllDepartments();
        model.addAttribute("departments", departments);
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        News news = newsService.getNewsById(id);
        model.addAttribute("news", news);
        NewsDTO newsDTO  = new NewsDTO();
        model.addAttribute("newsDTO", newsDTO);
        List<Image> slides = imageService.fetchImagesByNewsId(id);
        model.addAttribute("slides", slides);
        return "/admin/news/newsEdit";
    }
    @PostMapping("/news/edit")
    public String editNews(NewsDTO newsDTO, Long id) throws Exception {
        newsService.updateNews(newsDTO, id);
        return "redirect:/dashboard/news";
    }

    @GetMapping("/news/delete")
    public String deleteNewsPage(Long id) {
        newsService.deleteNews(id);
        return "redirect:/dashboard/news";
    }
}