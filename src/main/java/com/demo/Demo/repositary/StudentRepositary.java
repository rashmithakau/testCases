package com.demo.Demo.repositary;

import com.demo.Demo.entiry.StudentEntity;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@EnableJpaRepositories
public interface StudentRepositary extends CrudRepository<StudentEntity,Integer> {

}
