package com.example.lab4_clase.entity;

import javax.persistence.*;

@Entity
@Table(name="departments")
public class Departments {

    @Id
    @Column(name = "department_id")
    private int id;
    @Column(name = "department_name")
    private String departmentname;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private com.example.lab4_clase.entity.Employees managerid;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private com.example.lab4_clase.entity.Locations locationid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public com.example.lab4_clase.entity.Employees getManagerid() {
        return managerid;
    }

    public void setManagerid(com.example.lab4_clase.entity.Employees managerid) {
        this.managerid = managerid;
    }

    public com.example.lab4_clase.entity.Locations getLocationid() {
        return locationid;
    }

    public void setLocationid(com.example.lab4_clase.entity.Locations locationid) {
        this.locationid = locationid;
    }
}
