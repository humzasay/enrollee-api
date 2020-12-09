package com.example.enrollapi.services;

import com.example.enrollapi.database.EnrolleeRespository;
import com.example.enrollapi.handlers.RecordNotFoundException;
import com.example.enrollapi.model.Dependents;
import com.example.enrollapi.model.Enrollee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
public class EnrolleeServiceImplTest {

    @InjectMocks
    EnrolleeService enrolleeService = new EnrolleeServiceImpl();

    @Mock
    EnrolleeRespository enrolleeRespository;

    Enrollee enrollee;

    @Before
    public void setUp() {
        Dependents dependents = new Dependents(101L, "Jobs", new Date(13081989));
        Set dependentsSet = new HashSet<>();
        dependentsSet.add(dependents);
        enrollee = new Enrollee(101L, "Steve", true,
                "8390613173", new Date(13081987), dependentsSet);
    }

    @Test
    public void shouldReturnValidResponseForGetEnrolleeById() throws RecordNotFoundException {
        Long input = 101L;
        Mockito.when(enrolleeRespository.findById(input)).thenReturn(java.util.Optional.ofNullable(enrollee));
        Enrollee eventualAlbumApiResponse = enrolleeService.getEnrolleeById(input);
        Assert.assertNotNull(eventualAlbumApiResponse);
        Assert.assertNotNull(eventualAlbumApiResponse.getDependents());
    }

}