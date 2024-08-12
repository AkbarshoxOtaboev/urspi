package uz.urspi.urspi.department;

import java.util.List;

public interface DepartmentService {

    void create(Department department);

    Department fetchDepartmentById(Long departmentId);

    List<Department> fetchAllDepartments();

    void update(Long departmentId, Department department);

    void delete(Long departmentId);

    boolean exists(String departmentName);

}
