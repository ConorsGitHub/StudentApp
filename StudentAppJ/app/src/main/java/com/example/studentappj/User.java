package com.example.studentappj;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class User {
    public String fullname, courses, email, monday, tuesday, wednesday, thursday, friday;
    public User(){}
    public User(String fullname,String courses,String email) {
        this.fullname = fullname;
        this.courses = courses;
        this.email = email;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;


    }
}