package uz.urspi.urspi.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String getLoginPage() {
        return "/login";
    }

    @GetMapping("/dashboard")
    public String getDashboardPage() {
        return "/admin/home";
    }

    @GetMapping("/department")
    public String getDepartmentPage() {
        return "/admin/department";
    }
}
