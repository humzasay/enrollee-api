package com.example.enrollapi.controllers;

import com.example.enrollapi.handlers.RecordNotFoundException;
import com.example.enrollapi.model.Enrollee;
import com.example.enrollapi.services.EnrolleeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.enrollapi.utils.EndPoints.CREATE_ENROLLE;
import static com.example.enrollapi.utils.EndPoints.ENROLLE_ID;

@RestController
public class EnrolleeController {

    protected static final Logger LOGGER = LoggerFactory.getLogger(EnrolleeController.class);

    @Autowired
    EnrolleeService enrolleeService;

    @PostMapping(CREATE_ENROLLE)
    public ResponseEntity<Enrollee> createOrUpdateEnrollee(@RequestBody Enrollee enrollee)
            throws RecordNotFoundException {
        LOGGER.info("Received create request with data : "+enrollee);
        Enrollee updated = enrolleeService.createOrUpdateEnrollee(enrollee);
        return new ResponseEntity<Enrollee>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(ENROLLE_ID)
    public HttpStatus deleteEnrolleeById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        LOGGER.info("Received create request with data : "+id);
        enrolleeService.deleteEnrolleeById(id);
        return HttpStatus.FORBIDDEN;
    }

    @GetMapping(ENROLLE_ID)
    public ResponseEntity<Enrollee> getEnrolleeById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        LOGGER.info("Received create request with data : "+id);
        Enrollee entity = enrolleeService.getEnrolleeById(id);
        return new ResponseEntity<Enrollee>(entity, new HttpHeaders(), HttpStatus.OK);
    }

}
