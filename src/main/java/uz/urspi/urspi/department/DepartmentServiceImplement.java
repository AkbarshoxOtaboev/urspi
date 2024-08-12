package uz.urspi.urspi.department;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImplement implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public void create(Department department) {
        department.setStatus(1);
        departmentRepository.save(department);
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow();
    }

    @Override
    public List<Department> fetchAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public void update(Long departmentId, Department department) {
        var updDepartment = departmentRepository.findById(departmentId).orElseThrow();
        updDepartment.setName(department.getName());

        updDepartment.setStatus(department.getStatus());
        departmentRepository.saveAndFlush(updDepartment);
    }

    @Override
    public void delete(Long departmentId) {
        var updDepartment = departmentRepository.findById(departmentId).orElseThrow();
        updDepartment.setStatus(0);
        departmentRepository.saveAndFlush(updDepartment);
    }

    @Override
    public boolean exists(String departmentName) {
        return departmentRepository.existsByName(departmentName);
    }
}
