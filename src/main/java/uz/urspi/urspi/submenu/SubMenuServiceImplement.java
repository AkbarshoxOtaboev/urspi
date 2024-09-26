package uz.urspi.urspi.submenu;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.urspi.urspi.menu.Menu;
import uz.urspi.urspi.menu.MenuService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubMenuServiceImplement  implements SubMenuService{
    private final SubMenuRepository subMenuRepository;
    private final MenuService menuService;
    @Override
    public void create(SubMenu subMenu, Long menuId) {
        Menu menu = menuService.findById(menuId);
        subMenu.setMenu(menu);
        subMenu.setStatus(1);
        subMenuRepository.save(subMenu);
    }

    @Override
    public SubMenu findById(Long id) {
        return subMenuRepository.findById(id).orElseThrow();
    }

    @Override
    public List<SubMenu> findAllByMenuId(Long menuId) {
        return subMenuRepository.findByMenuId(menuId);
    }

    @Override
    public void update(Long id, SubMenu subMenu) {

    }

    @Override
    public void delete(Long id) {
        SubMenu subMenu = subMenuRepository.findById(id).orElseThrow();
        subMenu.setStatus(0);
        subMenuRepository.saveAndFlush(subMenu);
    }

    @Override
    public boolean existsByName(String subMenuName) {
        return subMenuRepository.existsBySubMenuName(subMenuName);
    }


}
