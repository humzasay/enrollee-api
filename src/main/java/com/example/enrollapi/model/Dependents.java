package com.example.enrollapi.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name="TBL_DEPENDENTS")
public class Dependents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="full_name")
    private String name;

    @Column(name="birth_date")
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name="enrollee_id", nullable=false)
    private Enrollee enrollee;

    public Dependents(Long id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Enrollee getEnrollee() {
        return enrollee;
    }

    public void setEnrollee(Enrollee enrollee) {
        this.enrollee = enrollee;
    }
}

