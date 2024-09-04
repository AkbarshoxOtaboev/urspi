package uz.urspi.urspi.menu;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.urspi.urspi.user.User;
import uz.urspi.urspi.user.UserService;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;
    private final UserService userService;
    @GetMapping("/menu")
    public String getMenuPage(Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        Menu menu = new Menu();
        model.addAttribute("menu", menu);
        List<Menu> menus = menuService.findAll();
        model.addAttribute("menus", menus);
        return "/admin/menu";
    }

    @PostMapping("/menu/create")
    public String createMenu(Model model, Menu menu) {
        if(menuService.checkMenuName(menu.getName())) {
            return "redirect:/dashboard/menu?error";
        }else {
            menuService.create(menu);
            return "redirect:/dashboard/menu?success";
        }
    }



}
