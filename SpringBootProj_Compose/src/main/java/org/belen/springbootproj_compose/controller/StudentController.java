package org.belen.springbootproj_compose.controller;

import org.belen.springbootproj_compose.entity.Student;
import org.belen.springbootproj_compose.service.StudentServieImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentServieImpl serv;

    @PostMapping ("/registerStudent")
    public ResponseEntity<Student> registerTheStudent(@RequestBody Student std){
        Student student = serv.saveTheStudent(std);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/fetchAllStudents")
    public ResponseEntity<List<Student>> fetchTheStudents(){
        List<Student> theStudents = serv.getTheStudents();
        return new ResponseEntity<>(theStudents,HttpStatus.OK);
    }

    @PostMapping("/updateTheStudent")
    public ResponseEntity<Student> updateTheStudent(@RequestBody Student std){
        Student student = serv.updateStudent(std);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }



    @DeleteMapping("/deletheStudent")
    public ResponseEntity<String> deleteTheStudent(@RequestParam Integer id){
        String s = serv.deleteTheStudent(id);
        return new ResponseEntity<>(s,HttpStatus.OK);
    }

}
