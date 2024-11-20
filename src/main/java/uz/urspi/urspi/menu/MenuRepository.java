package uz.urspi.urspi.menu;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    boolean existsByName(String name);
    List<Menu> findByStatus(Integer status, Sort sort);
}
