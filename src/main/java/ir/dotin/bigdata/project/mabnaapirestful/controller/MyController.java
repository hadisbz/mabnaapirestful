package ir.dotin.bigdata.project.mabnaapirestful.controller;

import ir.dotin.bigdata.project.mabnaapirestful.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dotin")
public class MyController {
    @Autowired
    private StudentModel studentModel;

    @GetMapping("/student/{name}/{id}")
    public ResponseEntity<StudentModel> studentModel(@PathVariable String name, @PathVariable long id) {
        studentModel.setName(name);
        studentModel.setId(id);

        return new ResponseEntity<>(studentModel, HttpStatus.OK);
    }

    @PostMapping("/student/setter")
    public ResponseEntity<StudentModel> set(@RequestBody StudentModel studentModel){
        System.out.println(studentModel);
        return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
    }
}
