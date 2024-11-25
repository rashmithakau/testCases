package com.demo.Demo.service.impl;

import com.demo.Demo.dto.StudentDTO;
import com.demo.Demo.entiry.StudentEntity;
import com.demo.Demo.repositary.StudentRepositary;
import com.demo.Demo.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private StudentRepositary studentRepositary;

    @Override
    public void saveStudent(StudentDTO student) {
        StudentEntity studentEntity=objectMapper.convertValue(student, StudentEntity.class);
        studentRepositary.save(studentEntity);
    }
}
