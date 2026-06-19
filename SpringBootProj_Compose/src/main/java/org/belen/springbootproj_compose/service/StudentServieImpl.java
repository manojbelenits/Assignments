package org.belen.springbootproj_compose.service;

import jakarta.transaction.Transactional;
import org.belen.springbootproj_compose.entity.Student;
import org.belen.springbootproj_compose.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServieImpl {

    @Autowired
    private StudentRepo sRepo;

    @Transactional
    public Student saveTheStudent(Student std){
        return sRepo.save(std);
    }


    public List<Student> getTheStudents(){
        return sRepo.findAll();
    }


    @Transactional
    public String deleteTheStudent(Integer sId){
        sRepo.deleteById(sId);
        return "Successfully deleted with Id:"+sId;
    }


    @Transactional
    public Student updateStudent(Student std){
        return sRepo.save(std);
    }

}
