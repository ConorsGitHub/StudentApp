package com.example.studentappj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Calender2 extends AppCompatActivity {
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender2);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userid = user.getUid();

        final TextView monday = (TextView) findViewById(R.id.monday);
        final TextView tuesday = (TextView) findViewById(R.id.tuesday);
        final TextView wednesday = (TextView) findViewById(R.id.wednesday);
        final TextView thursday = (TextView) findViewById(R.id.thursday);
        final TextView friday = (TextView) findViewById(R.id.friday);

        reference.child(userid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);
                if(userProfile != null){
                    String monday1 = userProfile.monday;
                    String tuesday2 = userProfile.tuesday;
                    String wednesday3 = userProfile.wednesday;
                    String thursday4 = userProfile.thursday;
                    String friday5 = userProfile.friday;

                    monday.setText(monday1);
                    tuesday.setText(tuesday2);
                    wednesday.setText(wednesday3);
                    thursday.setText(thursday4);
                    friday.setText(friday5);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error){
                Toast.makeText(Calender2.this, "Something went wrong", Toast.LENGTH_SHORT);
            }
        });
    }
}