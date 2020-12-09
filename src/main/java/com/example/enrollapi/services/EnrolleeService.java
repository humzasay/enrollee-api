package com.example.enrollapi.services;

import com.example.enrollapi.handlers.RecordNotFoundException;
import com.example.enrollapi.model.Enrollee;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrolleeService {

     void deleteEnrolleeById(Long id) throws RecordNotFoundException;
     Enrollee createOrUpdateEnrollee(Enrollee entity) throws RecordNotFoundException;
     Enrollee getEnrolleeById(Long id) throws RecordNotFoundException;

}
