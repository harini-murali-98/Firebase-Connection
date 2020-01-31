package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    TextView x,y,z;
    Button b;
   DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x = (TextView) findViewById(R.id.t1);
        y = (TextView) findViewById(R.id.t2);
        z = (TextView) findViewById(R.id.t3);

        b= (Button)findViewById(R.id.button);
        FirebaseApp.initializeApp(this);
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
       final DatabaseReference mGetReference = mDatabase.getReference();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mGetReference.child("X").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        mGetReference.child("Z").getKey();
                        Float value = dataSnapshot.getValue(Float.class);
                       x.setText(value.toString());

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                mGetReference.child("Y").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        mGetReference.child("Z").getKey();
                        Float value = dataSnapshot.getValue(Float.class);
                        y.setText(value.toString());

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


                mGetReference.child("Z").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        mGetReference.child("Z").getKey();
                        Float value = dataSnapshot.getValue(Float.class);
                        z.setText(value.toString());

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



            }
        });
    }
}
