package com.example.demo.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    private String firstName;
    private String lastName;
    private String title;
    private String office;

    public void setName(String Name) {
        this.firstName = Name;
//        this.lastName = "";
    }
}
