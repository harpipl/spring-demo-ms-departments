package pl.harpi.samples.spring.demo.ms.departments.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentDto {
    private String name;
}
