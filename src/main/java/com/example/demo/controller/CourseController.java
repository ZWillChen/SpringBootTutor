package com.example.demo.controller;

import com.example.demo.modal.Course;
import com.example.demo.modal.dto.CourseDto;
import com.example.demo.service.CourseService;
import com.fasterxml.jackson.annotation.JsonRawValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

// single function interface
@RestController
@RequestMapping
public class CourseController {
    @Autowired // IOC
            CourseService courseService; // Singleton

    @GetMapping(path = "/", produces = "application/json")
    public HttpEntity findAllCourses(){
        List<Course> allCourses = courseService.findAllCourses();

        return new ResponseEntity<>(allCourses,HttpStatus.OK);
    }

//    @GetMapping(path = "/api/course/findAllCourses", produces = "application/json")
//    public HttpEntity<List<CourseDto>> findAllCourses(){
//        List<CourseDto> allCourses = courseService.findAllCourses();
//
//        return new ResponseEntity<>(allCourses, HttpStatus.OK);
//    }

    @GetMapping(path = "/look-up/{inputString}", produces = "application/json")
    public HttpEntity<Course> searchCourse(@PathVariable("inputString") String inputString) {

        List<Course> findedCourse = courseService.searchByCourseName(inputString);

        return new ResponseEntity(findedCourse, HttpStatus.OK);
    }
    @DeleteMapping(path = "/delete/{inputString}", produces = "application/json")
    public HttpEntity<Course> deleteCourse(@PathVariable("inputString") String inputString) {
        courseService.deleteCourse(inputString);
        List<Course> allCourses = courseService.findAllCourses();
        return new ResponseEntity(allCourses, HttpStatus.OK);
    }
    @PostMapping(path = "/create/{inputString}", produces = "application/json")
    public HttpEntity<Course> createCourse(@PathVariable("inputString") String inputString) {
        courseService.addCourse(inputString);
        List<Course> allCourses = courseService.findAllCourses();
        return new ResponseEntity(allCourses, HttpStatus.OK);
    }
    @PutMapping(path = "/update/{inputString}", produces = "application/json")
    public HttpEntity<Course> updateCourse(@PathVariable("inputString") String inputString) {
        courseService.updateCourse(inputString);
        List<Course> allCourses = courseService.findAllCourses();
        return new ResponseEntity(allCourses, HttpStatus.OK);
    }
    @PostMapping(path = "/create", produces = "application/json")
    public HttpStatus addCourse(@RequestBody @NotNull Course course) {
        try {
            courseService.createCourse(course);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.ACCEPTED;
        }
    }
}
//增加 删除 读取 更新
//DTO = data transfer object

