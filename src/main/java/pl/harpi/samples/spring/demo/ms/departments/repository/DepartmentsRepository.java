package pl.harpi.samples.spring.demo.ms.departments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.harpi.samples.spring.demo.ms.departments.model.Department;

import java.util.Optional;

public interface DepartmentsRepository extends JpaRepository<Department, Long> {
    Optional<Department> getById(Long id);
}
