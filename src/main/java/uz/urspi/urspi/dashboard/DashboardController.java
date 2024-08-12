package uz.urspi.urspi.dashboard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.urspi.urspi.user.User;
import uz.urspi.urspi.user.UserService;

@Controller
@RequiredArgsConstructor
public class DashboardController {

    private final UserService userService;

    @GetMapping("/dashboard")
    public String getDashboardPage(Model model) {
        User user =userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("title", "Dashboard");
        return "/admin/home";
    }


    @GetMapping("/category")
    public String getCategoryPage(Model model) {
        User user =userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("title", "Category");
        return "/admin/category";
    }

    @GetMapping("/position")
    public String getPositionPage(Model model) {
        User user =userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("title", "Position");
        return "/admin/position";
    }
    @GetMapping("news")
    public String getNewsPage(Model model) {
        User user =userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("title", "News");
        return "/admin/news";
    }

    @GetMapping("/events")
    public String getEventsPage(Model model) {
        User user =userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("title", "Events");
        return "/admin/events";
    }

    @GetMapping("/employee")
    public String getEmployeePage(Model model) {
        User user =userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("title", "Employee");
        return "/admin/employee";
    }

    @GetMapping("/pages")
    public String getPagesPage(Model model) {
        User user =userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("title", "Pages");
        return "/admin/pages";
    }

}
