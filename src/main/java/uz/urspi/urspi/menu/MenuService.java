package uz.urspi.urspi.menu;

import java.util.List;

public interface MenuService {
    void create(Menu menu);
    void edit(Menu menu, Long id);
    void delete(Long id);
    List<Menu> findAll();
    Menu findById(Long id);
    boolean checkMenuName(String name);
}
