package uz.urspi.urspi.structure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uz.urspi.urspi.user.User;
import uz.urspi.urspi.user.UserService;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class StructureController {
    private final StructureService structureService;
    private final UserService userService;
    @GetMapping("/structure")
    public String getStructurePage(Model model) {
        model.addAttribute("title", "Tuzilma");
        User currentUser = userService.getCurrentUser();
        model.addAttribute("user", currentUser);
        List<Structure> structures = structureService.getAllStructures();
        model.addAttribute("structures", structures);
        Structure structure = new Structure();
        model.addAttribute("structure", structure);
        return "admin/structure";
    }

    @PostMapping("/structure/create")
    public String createStructure(Model model, Structure structure) {
        if(structureService.isStructureExist(structure.getName())){
           return "redirect:/dashboard/structure?error";
        }else {
            structureService.create(structure);
            return "redirect:/dashboard/structure?success";
        }
    }

    @PostMapping("/structure/update")
    public String updateStructure(Model model, Structure structure) {
        structureService.update(structure, structure.getId());
        return "redirect:/dashboard/structure?update";
    }

    @GetMapping("/structure/edit/getOne")
    @ResponseBody
    public Structure getOneStructure(Long id) {
        return structureService.getStructureById(id);
    }

    @GetMapping("/structure/delete")
    public String deleteStructure(Long id) {
        structureService.delete(id);
        return "redirect:/dashboard/structure?delete";
    }
}
