package pl.harpi.samples.spring.demo.ms.departments.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.harpi.samples.spring.demo.ms.departments.dto.DepartmentDto;
import pl.harpi.samples.spring.demo.ms.departments.service.DepartmentNotFoundException;

import java.util.Locale;

public interface DepartmentsResource {
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity createDepartment(@RequestBody DepartmentDto departmentDto);

    @RequestMapping(value = "{department-id}", method = RequestMethod.GET)
    DepartmentDto getDepartmentById(@PathVariable("department-id") Long id);

    @RequestMapping(value = "{department-id}", method = RequestMethod.PUT)
    ResponseEntity updateDepartment(@PathVariable("department-id") Long id, @RequestBody DepartmentDto departmentDto);

    @RequestMapping(value = "{department-id}", method = RequestMethod.DELETE)
    ResponseEntity deleteDepartment(@PathVariable("department-id") Long id);

    @ExceptionHandler(DepartmentNotFoundException.class)
    ResponseEntity onOrganizationNotFound(DepartmentNotFoundException ex, Locale locale);
}
