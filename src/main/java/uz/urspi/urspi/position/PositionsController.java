package uz.urspi.urspi.position;

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
public class PositionsController {

    private final PositionsService positionsService;
    private final UserService userService;


    @GetMapping("/position")
    public String getPositionPage(Model model) {
        User user =userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("title", "Position");
        Positions newPosition = new Positions();
        model.addAttribute("newPosition", newPosition);
        List<Positions> positions = positionsService.getAllPositions();
        model.addAttribute("positions", positions);
        return "admin/position";
    }

    @PostMapping("/position/create")
    public String createPosition(Positions positions){
        if(positionsService.isPositionExistsByName(positions.getName())){
            return "redirect:/dashboard/position?error_name";
        }else {
            positionsService.createPositions(positions);
            return "redirect:/dashboard/position";
        }
    }

    @GetMapping("/position/delete")
    public String deletePosition(Long id){
        positionsService.deletePositions(id);
        return "redirect:/dashboard/position";
    }

    @GetMapping("/position/edit/getOne")
    @ResponseBody
    public Positions getOnePosition(Long id){
        return positionsService.getPositions(id);
    }

    @PostMapping("/position/edit")
    public String updatePosition(Positions newPositions){
        positionsService.updatePositions(newPositions, newPositions.getId());
        return "redirect:/dashboard/position";
    }
}
