package com.example.enrollapi.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name="TBL_ENROLLEE")
public class Enrollee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollee_id")
    private Long id;

    @Column(name="full_name")
    private String name;

    @Column(name="activation_status")
    private Boolean isActive;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="birth_date")
    private Date birthDate;

    @OneToMany(mappedBy="enrollee")
    private Set<Dependents> dependents;

    public Enrollee(Long id, String name, Boolean isActive, String phoneNumber, Date birthDate, Set<Dependents> dependents) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.dependents = dependents;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Dependents> getDependents() {
        return dependents;
    }

    public void setDependents(Set<Dependents> dependents) {
        this.dependents = dependents;
    }

    @Override
    public String toString() {
        return "Enrollee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                ", birthDate=" + birthDate +
                '}';
    }
}

