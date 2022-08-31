package com.ssm.domain;

import lombok.Data;
//import javax.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Data
public class Course {
    private Integer id;
    private String title;
    private String dept_name;
    private Integer credits;
}
