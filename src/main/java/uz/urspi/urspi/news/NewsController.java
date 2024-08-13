package uz.urspi.urspi.news;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}