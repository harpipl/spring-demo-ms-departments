package pl.harpi.samples.spring.demo.ms.departments.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.harpi.samples.spring.demo.ms.departments.dto.DepartmentDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "departments")
@Entity
@Data
@NoArgsConstructor
public class Department {
    public Department(DepartmentDto departmentDto) {
        this.name = departmentDto.getName();
    }

    @GeneratedValue
    @Id
    private Long id;
    private String name;

    public DepartmentDto createDTO() {
        return DepartmentDto.builder()
                .name(this.name)
                .build();
    }
}
