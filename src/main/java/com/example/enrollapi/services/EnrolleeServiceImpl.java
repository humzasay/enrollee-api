package com.example.enrollapi.services;

import com.example.enrollapi.controllers.EnrolleeController;
import com.example.enrollapi.database.EnrolleeRespository;
import com.example.enrollapi.handlers.RecordNotFoundException;
import com.example.enrollapi.model.Enrollee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnrolleeServiceImpl implements EnrolleeService {

    protected static final Logger LOGGER = LoggerFactory.getLogger(EnrolleeService.class);

    @Autowired
    EnrolleeRespository enrolleeRespository;

    @Override
    public void deleteEnrolleeById(Long id) throws RecordNotFoundException {
        Optional<Enrollee> enrollee = enrolleeRespository.findById(id);
        if(enrollee.isPresent()) {
            LOGGER.info("Found Enrolle removing it for Id: "+id);
            enrolleeRespository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No enrollee record exist for given id");
        }
    }

    @Override
    public Enrollee createOrUpdateEnrollee(Enrollee enrollee) throws RecordNotFoundException {
        Optional<Enrollee> eventualEnrollee = enrolleeRespository.findById(enrollee.getId());

        if(eventualEnrollee.isPresent())
        {
            Enrollee newEnrollee = eventualEnrollee.get();
            newEnrollee.setName(enrollee.getName());
            newEnrollee.setActive(enrollee.getActive());
            newEnrollee.setBirthDate(enrollee.getBirthDate());

            newEnrollee = enrolleeRespository.save(newEnrollee);

            return newEnrollee;
        } else {
            enrollee = enrolleeRespository.save(enrollee);

            return enrollee;
        }
    }

    @Override
    public Enrollee getEnrolleeById(Long id) throws RecordNotFoundException {
        Optional<Enrollee> enrollee = enrolleeRespository.findById(id);

        if(enrollee.isPresent()) {
            return enrollee.get();
        } else {
            throw new RecordNotFoundException("No enrollee record exist for given id");
        }    }
}
