package pl.harpi.samples.spring.demo.ms.departments.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.harpi.samples.spring.demo.common.web.UriBuilder;
import pl.harpi.samples.spring.demo.ms.departments.dto.DepartmentDto;
import pl.harpi.samples.spring.demo.ms.departments.model.Department;
import pl.harpi.samples.spring.demo.ms.departments.service.DepartmentNotFoundException;
import pl.harpi.samples.spring.demo.ms.departments.service.DepartmentsService;

import java.net.URI;
import java.util.Locale;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.noContent;

@RequestMapping("departments")
@RestController
public class DepartmentsResourceImpl implements DepartmentsResource {
    private DepartmentsService departmentsService;
    private UriBuilder uriBuilder = new UriBuilder();

    public DepartmentsResourceImpl(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @Override
    public ResponseEntity createDepartment(@RequestBody DepartmentDto departmentDto) {
        Department department = new Department(departmentDto);
        long departmentId = departmentsService.addDepartment(department).getId();
        URI newDepartmentUri = uriBuilder.requestUriWithId(departmentId);
        return created(newDepartmentUri).build();
    }

    @Override
    public DepartmentDto getDepartmentById(@PathVariable("department-id") Long id) {
        Department department = departmentsService.getDepartmentById(id);
        return department.createDTO();
    }

    @Override
    public ResponseEntity updateDepartment(@PathVariable("department-id") Long id,
                                           @RequestBody DepartmentDto departmentDto) {
        Department department = new Department(departmentDto);
        department.setId(id);
        departmentsService.updateDepartment(department);
        return noContent().build();
    }

    @Override
    public ResponseEntity deleteDepartment(@PathVariable("department-id") Long id) {
        departmentsService.deleteDepartmentWithId(id);
        return noContent().build();
    }

    @Override
    public ResponseEntity onOrganizationNotFound(DepartmentNotFoundException ex, Locale locale) {
        return new ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
    }
}

