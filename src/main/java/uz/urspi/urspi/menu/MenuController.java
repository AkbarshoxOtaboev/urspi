package uz.urspi.urspi.menu;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uz.urspi.urspi.submenu.SubMenu;
import uz.urspi.urspi.submenu.SubMenuService;
import uz.urspi.urspi.user.User;
import uz.urspi.urspi.user.UserService;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;
    private final UserService userService;
    private final SubMenuService subMenuService;

    @GetMapping("/menu")
    public String getMenuPage(Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        Menu menu = new Menu();
        model.addAttribute("menu", menu);
        List<Menu> activeMenus = menuService.findByStatus(1);
        List<Menu> noActiveMenus = menuService.findByStatus(0);
        model.addAttribute("activeMenus", activeMenus);
        model.addAttribute("noActiveMenus", noActiveMenus);
        return "admin/menu";
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
    @GetMapping("/menu/getAll")
    public String getAllMenu(Model model) {
        List<Menu> activeMenus = menuService.findByStatus(1);
        List<Menu> noActiveMenus = menuService.findByStatus(0);
        model.addAttribute("activeMenus", activeMenus);
        model.addAttribute("noActiveMenus", noActiveMenus);
        return "redirect:/dashboard/menu";
    }
    @GetMapping("/menu/active")
    public String activeMenu(Long id) {
        menuService.activeMenu(id);
        return "redirect:/dashboard/menu?success";
    }
    @GetMapping("/menu/getOne")
    @ResponseBody
    public Menu getOneMenu(Long id) {
        return menuService.findById(id);
    }

    @PostMapping("/menu/edit")
    public String editMenu(Menu menu) {
        menuService.edit(menu, menu.getId());
        return "redirect:/dashboard/menu?success";
    }

    @GetMapping("/menu/delete")
    public String deleteMenu(Long id) {
        menuService.delete(id);
        return "redirect:/dashboard/menu";
    }

    @GetMapping("/menu/subMenu")
    public String subMenu(Model model, Long menuId) {
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("title", "Sub menu");
        Menu menu = menuService.findById(menuId);
        model.addAttribute("menu", menu);
        List<SubMenu> subMenus = subMenuService.findAllByMenuId(menuId);
        model.addAttribute("subMenus", subMenus);
        SubMenu subMenu = new SubMenu();
        model.addAttribute("subMenu", subMenu);
        return "admin/subMenu";
    }
    @GetMapping("/menu/subMenu/getOne")
    @ResponseBody
    public SubMenu getOneSubMenu(Long id) {
        return subMenuService.findById(id);
    }

    @PostMapping("/menu/subMenu/create")
    public String createSubMenu(Model model, SubMenu subMenu, Long menuId) {
        subMenuService.create(subMenu, menuId);
        return "redirect:/dashboard/menu/subMenu?menuId=" + menuId;
    }

    @PostMapping("/menu/subMenu/update")
    public String updateSubMenu(Model model, SubMenu subMenu, Long menuId) {
        subMenuService.update(subMenu.getId(), subMenu);
        return "redirect:/dashboard/menu/subMenu?menuId=" + menuId;
    }

    @GetMapping("/menu/subMenu/delete")
    public String deleteSubMenu(Long id, Long menuId) {
        subMenuService.delete(id);
        return "redirect:/dashboard/menu/subMenu?menuId=" + menuId;
    }
}
