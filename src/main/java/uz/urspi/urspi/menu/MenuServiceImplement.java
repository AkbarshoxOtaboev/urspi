package uz.urspi.urspi.menu;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImplement implements MenuService {

    private final MenuRepository menuRepository;

    @Override
    public void create(Menu menu) {
        menu.setStatus(1);
        menuRepository.save(menu);
    }

    @Override
    public void edit(Menu menu, Long id) {
        Menu updatedMenu = menuRepository.findById(id).orElse(null);
        updatedMenu.setName(menu.getName());
        menuRepository.save(updatedMenu);
    }

    @Override
    public void delete(Long id) {
        Menu menu = menuRepository.findById(id).orElseThrow();
        menu.setStatus(0);
        menuRepository.save(menu);
    }

    @Override
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    @Override
    public Menu findById(Long id) {
        return menuRepository.findById(id).orElseThrow();
    }

    @Override
    public boolean checkMenuName(String name) {
        return menuRepository.existsByName(name);
    }
}
