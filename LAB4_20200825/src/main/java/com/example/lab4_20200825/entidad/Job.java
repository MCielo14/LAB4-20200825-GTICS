package com.example.lab4_20200825.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "jobs", schema = "hr")
public class Job {
    @Id
    @Column(name = "job_id", nullable = false, length = 10)
    private String jobId;

    @Column(name = "job_title", nullable = false, length = 35)
    private String jobTitle;

    @Column(name = "min_salary")
    private Integer minSalary;

    @Column(name = "max_salary")
    private Integer maxSalary;

    @OneToMany(mappedBy = "job")
    private Set<Employee> employees = new LinkedHashSet<>();

    @OneToMany(mappedBy = "job")
    private Set<JobHistory> jobHistories = new LinkedHashSet<>();

}