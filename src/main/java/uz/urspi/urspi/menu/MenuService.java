package uz.urspi.urspi.menu;

import java.util.List;

public interface MenuService {
    void create(Menu menu);
    void edit(Menu menu, Long id);
    void delete(Long id);
    void activeMenu(Long id);
    List<Menu> findByStatus(Integer status);
    Menu findById(Long id);
    boolean checkMenuName(String name);
}
