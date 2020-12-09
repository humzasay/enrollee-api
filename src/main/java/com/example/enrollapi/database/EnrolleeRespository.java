package com.example.enrollapi.database;

import com.example.enrollapi.model.Enrollee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrolleeRespository extends JpaRepository<Enrollee, Long> {


}