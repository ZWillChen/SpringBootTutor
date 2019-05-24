package com.example.demo.repository;

import com.example.demo.modal.Course;
import com.example.demo.modal.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CourseRepository {
    List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        Course javaOne = Course.builder()
                .className("Java I")
                .instructor(new Instructor("Steve", "Jobs", "Phd", "TownHall201"))
                .startDate(new Date("8/1/2018"))
                .endDate(new Date("12/24/2018"))
                .timeFrame("8am-10am")
                .build();
        courses.add(javaOne);
        Course javaTwo = Course.builder()
                .className("Java II")
                .instructor(new Instructor("Bill", "Gates", "Phd", "TownHall201"))
                .startDate(new Date("8/2/2019"))
                .endDate(new Date("12/20/2019"))
                .timeFrame("8am-11am")
                .build();
        courses.add(javaTwo);
        Course cOne = Course.builder()
                .className("C I")
                .instructor(new Instructor("Sakuya", "Izayoi", "Pad", "RedDevil001"))
                .startDate(new Date("8/2/2019"))
                .endDate(new Date("12/20/2019"))
                .timeFrame("8am-11am")
                .build();
        courses.add(cOne);
    }


    public List<Course> findAllClasses(){
        //链接数据库
        //返回数据库的信息
        return courses;
    }

    public List<Course> findAllCourse(String searchByCourseName){
        return courses;
    }

    public List<Course> findCourseByName(String courseName) {
        List<Course> res = new ArrayList<>();
        for (Course c : courses){
            if (c.getClassName().equals(courseName)){
                res.add(c);
                return res;
            }
        }
        return new ArrayList<Course>();
    }
    public void deleteCourseByName(String courseName){
        for(Course c : courses){
            if(c.getClassName().equals(courseName)){
                courses.remove(c);
            }
        }
    }
    public void addCourseByName(String courseName){
        Course newCourse = Course.builder()
                .className(courseName)
                .instructor(new Instructor("Smith", "John", "Phd", "BOB306"))
                .startDate(new Date("8/2/2019"))
                .endDate(new Date("12/20/2019"))
                .timeFrame("8am-11am")
                .build();
        courses.add(newCourse);
    }
    public void updateCourseName(String courseName){
        for(Course c : courses){
            if(c.getClassName().equals(courseName)){
                c.setInstructor("Sakuya");
            }
        }
    }
    public void addCourseByCourse(Course newCourse) {
        courses.add(newCourse);
    }
}
