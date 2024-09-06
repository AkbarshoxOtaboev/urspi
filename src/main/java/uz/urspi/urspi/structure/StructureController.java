package uz.urspi.urspi.structure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.urspi.urspi.user.User;
import uz.urspi.urspi.user.UserService;

@Controller
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class StructureController {
    private final StructureService structureService;
    private final UserService userService;
    @GetMapping("/structure")
    public String getStructurePage(Model model) {
        User currentUser = userService.getCurrentUser();
        model.addAttribute("user", currentUser);
        return "structure";
    }
}
