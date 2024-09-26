package uz.urspi.urspi.submenu;

import java.util.List;

public interface SubMenuService {
    void create(SubMenu subMenu, Long menuId);
    SubMenu findById(Long id);
    List<SubMenu> findAllByMenuId(Long menuId);
    void update(Long id, SubMenu subMenu);
    void delete(Long id);
    boolean existsByName(String subMenuName);
}
