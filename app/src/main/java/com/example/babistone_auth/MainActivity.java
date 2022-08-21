package com.example.babistone_auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {


    // creating variables for our edit text
    private EditText courseNameEdt, courseDurationEdt, courseDescriptionEdt;

    // creating variable for button
    private Button submitCourseBtn;

    // creating a strings for storing
    // our values from edittext fields.
    private String courseName, courseDuration, courseDescription;

    // creating a variable
    // for firebasefirestore.
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firestore_page);

        // getting our instance
        // from Firebase Firestore.
        db = FirebaseFirestore.getInstance();

        // initializing our edittext and buttons
        courseNameEdt = findViewById(R.id.idEdtCourseName);
        courseDescriptionEdt = findViewById(R.id.idEdtCourseDescription);
        courseDurationEdt = findViewById(R.id.idEdtCourseDuration);
        submitCourseBtn = findViewById(R.id.idBtnSubmitCourse);

    }
}