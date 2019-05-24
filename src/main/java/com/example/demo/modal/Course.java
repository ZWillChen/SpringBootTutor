package com.example.demo.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class Course {
    private String className;
    private Instructor instructor;
    private Date startDate;
    private Date endDate;
    private String timeFrame;
    public Course(){}
    public Course(String className, Instructor instructor, Date startDate, Date endDate, String timeFrame){
        this.className = className;
        this.instructor = instructor;
        this.startDate = startDate;
        this.endDate = endDate;
        this.timeFrame = timeFrame;
    }
    public String getClassName(){
        return this.className;
    }
    public void setClassName(String className){
        this.className = className;
    }
    public void setInstructor(String instructorName){
        this.instructor.setName(instructorName);
    }

}

