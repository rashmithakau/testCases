package com.demo.Demo.controller;
import com.demo.Demo.dto.StudentDTO;
import com.demo.Demo.service.StudentService;
import com.demo.Demo.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController //Controller + ResponseBody
@RequestMapping("api/v1/student")
@CrossOrigin
public class StudentControler {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @GetMapping(path = "/get-student")
    public void getStudent(){
        System.out.println("Nimal");
    }

    @PostMapping("/save-student")
    public void saveStudent(@RequestBody StudentDTO student){
        studentService.saveStudent(student);
    }

}
