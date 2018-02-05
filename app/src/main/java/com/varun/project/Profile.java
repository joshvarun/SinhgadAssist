package com.varun.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Profile extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText name, cet, hsc;
    RadioButton male, female;
    Spinner spinner;
    Button submit;
    String sex;

    DatabaseReference databaseReference;

    FirebaseAuth firebaseAuth;

    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //changing statusbar color
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.profile));
        }

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, Login.class));
        }

        databaseReference = FirebaseDatabase.getInstance().getReference();

        firebaseUser = firebaseAuth.getCurrentUser();

        name = (EditText) findViewById(R.id.profileName);
        cet = (EditText) findViewById(R.id.profileCET);
        hsc = (EditText) findViewById(R.id.profileHSC);

        male = (RadioButton) findViewById(R.id.sexMale);
        female = (RadioButton) findViewById(R.id.sexFemale);

        spinner = (Spinner) findViewById(R.id.spinnerProfile);
        submit = (Button) findViewById(R.id.submit);

        spinner.setSelection(0);

        spinner.setOnItemSelectedListener(Profile.this);

        List<String> castes = new ArrayList<String>();

        castes.add("Select a Caste");
        castes.add("Open");
        castes.add("OBC");
        castes.add("VJ-NT");
        castes.add("SC, ST");
        castes.add("Others");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.spinner_profile, castes);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        final String item1 = parent.getItemAtPosition(position).toString();

        if(male.isChecked()){
            sex = "Male";
        }
        else if (female.isChecked()){
            sex = "Female";
        }
        if (name.length() > 0 && cet.length() > 0 && hsc.length() > 0 && (male.isChecked() || female.isChecked()) && !item1.equals("Select a Caste")) {
            submit.setEnabled(true);
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int cetMarks = Integer.parseInt(cet.getText().toString());
                    float hscMarks = Float.parseFloat(hsc.getText().toString());

                    if ((cetMarks < 200 && cetMarks > 0) && (hscMarks > 0 && hscMarks < 100)){
                        if (hscMarks > 40){
                            Candidate candidate = new Candidate(name.getText().toString().trim(),
                                    sex, cetMarks, hscMarks, item1);

                            FirebaseUser user = firebaseAuth.getCurrentUser();

                            databaseReference.child(user.getUid()).setValue(candidate);

                            Toast.makeText(Profile.this, "Hey, there! We are happy to help you with your admission process!", Toast.LENGTH_LONG).show();

                            finish();
                            startActivity(new Intent(Profile.this, MainActivity.class));
                        }
                        else{
                            Toast.makeText(Profile.this, "Sorry! You are not eligible for engineering!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    else{
                        Toast.makeText(Profile.this, "Invalid marks. Try again.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }
}