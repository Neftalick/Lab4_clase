package com.example.lab4_clase.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name="employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;

    @Column(name = "first_name", length = 20)
    @NotBlank(message = "No puede estar vacío")

    private String firstName;

    @NotBlank(message = "No puede estar vacío")
    @Column(name = "last_name", nullable = false, length = 25)
    private String lastName;

    @NotBlank(message = "No puede estar vacío")
    @Column(name = "email", nullable = false, length = 25)
    private String email;

    @NotBlank(message = "No puede estar vacío")
    @Size(min = 8,message = "Debe tener un minimo de 8 caracteres")
    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "hire_date", nullable = false)
    private LocalDateTime hireDate;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private com.example.lab4_clase.entity.Jobs job = new com.example.lab4_clase.entity.Jobs();

    @Positive(message = "Tiene que ser mayor que 0")
    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "commission_pct", precision = 2, scale = 2)
    private BigDecimal commissionPct;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employees manager;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private com.example.lab4_clase.entity.Departments department = new com.example.lab4_clase.entity.Departments();

    @Column(name = "enabled")
    private Integer enabled;

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public com.example.lab4_clase.entity.Departments getDepartment() {
        return department;
    }

    public void setDepartment(com.example.lab4_clase.entity.Departments department) {
        this.department = department;
    }

    public Employees getManager() {
        return manager;
    }

    public void setManager(Employees manager) {
        this.manager = manager;
    }

    public BigDecimal getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(BigDecimal commissionPct) {
        this.commissionPct = commissionPct;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public com.example.lab4_clase.entity.Jobs getJob() {
        return job;
    }

    public void setJob(com.example.lab4_clase.entity.Jobs job) {
        this.job = job;
    }

    public LocalDateTime getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
