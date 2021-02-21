package com.example.demoProject.student;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(path = "api/v1/student")
@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.ok(studentService.getStudents());
    }

    @PostMapping
    public void RecreateStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentID}")
    public void deleteStudent(
            @PathVariable ("studentID") Long studentID){
        studentService.deleteStudent(studentID);
    }

    @PutMapping(path = "{studentID}")
    public void updateStudent(
            @PathVariable("studentID") Long studentID,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentID, name, email);
    }


}
