package com.pws.JpaCurdOperation.controller;

import com.pws.JpaCurdOperation.config.SwaggerLogsConstants;
import com.pws.JpaCurdOperation.dto.StudentDto;
import com.pws.JpaCurdOperation.entity.Student;
import com.pws.JpaCurdOperation.service.StudentServiceImpl;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    //Logger configurations(Import from slf4j)
    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentServiceImpl studentService;

    @Operation(summary = "Save Student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student Data Saved Successfully", content = {
                    @Content(mediaType = "application/json",examples = {@ExampleObject(value = SwaggerLogsConstants.STUDENT_SAVED_200_SUCCESSFULL)}) }),
            @ApiResponse(responseCode = "400", description = "Invalid Data supplied", content = {
                    @Content(mediaType = "application/json",examples = {@ExampleObject(value = SwaggerLogsConstants.STUDENT_SAVED_400_FAILURE)})}),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content) })
    @PostMapping("/saveStudent")
    public ResponseEntity<Object> saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return new ResponseEntity<>("Student Details saved", HttpStatus.OK);
    }

    @GetMapping("/fetchAllStudent")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<Object> updateStudent(@RequestBody StudentDto studentDto) throws Exception {
        studentService.updateStudent(studentDto);
        return new ResponseEntity<>("Student updated",HttpStatus.OK);
    }

    @GetMapping("/getStudentById")
    public Optional<Student> getStudentById(@RequestParam Integer id) throws Exception{
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/deleteById")
    public String deleteStudentById(@RequestParam Integer id){
        return studentService.deleteStudentById(id);
    }

    @GetMapping("/fetch/name")
    public ResponseEntity<Object> getAllStudentName(){
    List<String> students=studentService.getAllStudentName();
        return ResponseEntity.ok(students);
    }

}
