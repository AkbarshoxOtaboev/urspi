package uz.urspi.urspi.department;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.urspi.urspi.user.User;
import uz.urspi.urspi.user.UserService;

import java.util.List;

@Controller
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;
    private final UserService userService;

    @GetMapping("")
    public String getDepartmentPage(Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("title", "Department");
        Department department = new Department();
        model.addAttribute("department", department);
        List<Department> departments = departmentService.fetchAllDepartments();
        model.addAttribute("departments", departments);
        return "/admin/department";
    }

    @PostMapping("/save")
    public String saveDepartment(Department department) {
        if(departmentService.exists(department.getName())) {
            return "redirect:/department?error";
        }else {
            departmentService.create(department);
            return "redirect:/department?success";
        }
    }

    @GetMapping("/edit/getOne")
    @ResponseBody
    public Department getOneDepartment(Long id) {
        return departmentService.fetchDepartmentById(id);
    }

    @PostMapping("/edit")
    public String editDepartment(Department department) {
        departmentService.update(department.getId(), department);
        return "redirect:/department?success_edit";
    }

    @GetMapping("/delete")
    public String deleteDepartment(Long id) {
        departmentService.delete(id);
        return "redirect:/department";
    }

}
