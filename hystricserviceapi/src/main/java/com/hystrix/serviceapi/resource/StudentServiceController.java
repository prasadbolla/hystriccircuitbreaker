package com.hystrix.serviceapi.resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hystrix.serviceapi.domain.Student;
 
@RestController
public class StudentServiceController {
 
    private static Map<String, List<Student>> schoolDB = new HashMap<String, List<Student>>();
 
    static {
        schoolDB = new HashMap<String, List<Student>>();
 
        List<Student> lst = new ArrayList<Student>();
        Student std = new Student("Nakul", "Grade 3");
        lst.add(std);
        std = new Student("Lohitha", "SK");
        lst.add(std);
 
        schoolDB.put("St Teresa", lst);
 
        lst = new ArrayList<Student>();
        std = new Student("Student 1", "Grade 1");
        lst.add(std);
        std = new Student("Student 2", "Grade 2");
        lst.add(std);
 
        schoolDB.put("Student School", lst);
 
    }
 
    @RequestMapping(value = "/getStudentDetails/{schoolname}", method = RequestMethod.GET)
    public List<Student> getStudents(@PathVariable String schoolname) {
        System.out.println("Getting Student details for " + schoolname);
 
        List<Student> studentList = schoolDB.get(schoolname);
        if (studentList == null) {
            studentList = new ArrayList<Student>();
            Student std = new Student("Not Found", "N/A");
            studentList.add(std);
        }
        return studentList;
    }
}