package com.example.demo.service;


import com.example.demo.modal.Course;
import com.example.demo.modal.Instructor;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
@Service
@Component
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> findAllCourses(){

        return courseRepository.findAllClasses();
    }

    public List<Course> searchByCourseName(String input){

        return courseRepository.findCourseByName(input);
    }

    public void deleteCourse(String input){
        courseRepository.deleteCourseByName(input);
    }
    public void addCourse(String input){
        courseRepository.addCourseByName(input);
    }
    public List<Course> updateCourse(String input){
        courseRepository.updateCourseName(input);
        return courseRepository.findAllClasses();
    }
    public void createCourse(Course newCourse){
        Course courseBeingSaved = Course.builder()
                .className(newCourse.getClassName())
                .instructor(new Instructor("Sakuya", "Izayoi", "Pad", "RedDevil001"))
                .startDate(new Date("8/2/2019"))
                .endDate(new Date("12/20/2019"))
                .timeFrame("8am-11am")
                .build();
        courseRepository.addCourseByCourse(courseBeingSaved);
    }
}
