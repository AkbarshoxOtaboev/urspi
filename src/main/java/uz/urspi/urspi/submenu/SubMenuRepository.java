package uz.urspi.urspi.submenu;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubMenuRepository extends JpaRepository<SubMenu, Long> {
    boolean existsBySubMenuName(String subMenuName);
    List<SubMenu> findByMenuId(Long id, Sort sort);
}
