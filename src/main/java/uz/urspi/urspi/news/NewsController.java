package uz.urspi.urspi.news;

import org.springframework.core.io.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.urspi.urspi.storage.StorageService;
import uz.urspi.urspi.user.User;
import uz.urspi.urspi.user.UserService;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;
    private final UserService userService;
    private final StorageService storageService;

    @GetMapping()
    public String getNewsPage(Model model) {
        User user =userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("title", "News");
        List<News> news = newsService.getAllNews();
        model.addAttribute("news", news);
        return "/admin/news";
    }

    @GetMapping("/create")
    public String createNewsPage(Model model) {
        User user =userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("title", "News");
        NewsDTO newsDTO = new NewsDTO();
        model.addAttribute("newsDTO", newsDTO);
        return "/admin/news/newsCreate";
    }

    @PostMapping("/create")
    public String createNews(NewsDTO newsDTO) throws IOException {
        newsService.createNews(newsDTO);
        return "redirect:/news";
    }

    @GetMapping("/all")
    @ResponseBody
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);

        if (file == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}