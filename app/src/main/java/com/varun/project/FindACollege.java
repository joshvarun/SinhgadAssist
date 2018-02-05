package com.varun.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class FindACollege extends AppCompatActivity {

    EditText getCet;

    Spinner first, second, third, four, five, six, seven, eight, stream;

    int firstPref, secondPref, thirdPref, fourthPref, fifthPref, sixthPref, seventhPref, eighthPref;

    String sel1, sel2, sel3, sel4, sel5, sel6, sel7, sel8;

    String streamPref;

    int cet;

    int[] studentPref;

    Button submit;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_acollege);

        //changing statusbar color
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.blueGrey));
        }

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, Login.class));
        }

        getCet = (EditText) findViewById(R.id.cet);
        first = (Spinner) findViewById(R.id.first);
        second = (Spinner) findViewById(R.id.second);
        third = (Spinner) findViewById(R.id.third);
        four = (Spinner) findViewById(R.id.four);
        five = (Spinner) findViewById(R.id.five);
        six = (Spinner) findViewById(R.id.six);
        seven = (Spinner) findViewById(R.id.seven);
        eight = (Spinner) findViewById(R.id.eight);

        stream = (Spinner) findViewById(R.id.spinnerStream);

        submit = (Button) findViewById(R.id.submit);

        stream.setSelection(0);


        List<String> streams = new ArrayList<String>();

        final List<String> college = new ArrayList<String>();

        streams.add("Select a Stream");
        streams.add("Computers");
        streams.add("IT");
        streams.add("Mechanical");
        streams.add("Civil");
        streams.add("Chemical");
        streams.add("Electrical");
        streams.add("Electronics");
        streams.add("Production");

        college.add("Select a Preference");
        college.add("Sinhgad College of Engineering, Vadgoan");
        college.add("Smt. Kashibai Navale College of Engineering, Vadgoan");
        college.add("Sinhgad Academy Of Engineering, Kondhwa");
        college.add("Sinhgad Institute of Technology and Science, Narhe");
        college.add("NBN Sinhgad School of Engineering, Ambegoan");
        college.add("RMD Sinhgad School of Engineering, Warje");
        college.add("Sinhgad Institute of Technology, Lonavala");
        college.add("SKN Sinhgad Institute of Technology and Science, Lonavala");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.spinner_whatsnearby, streams);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        stream.setAdapter(dataAdapter);

        final ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.spinner_whatsnearby, college);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        first.setAdapter(dataAdapter1);

        stream.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                if (!item.equals("Select a Stream")) {
                    streamPref = item;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        first.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                if (!item.equals("Select a Preference")) {
                    // 0. SCOE, 1. SKNCOE, 2. SAE, 3. SITS, 4. NBN, 5. RMD, 6. SIT, 7. SKNSITS
                    if (item.equals("Sinhgad College of Engineering, Vadgoan")) {
                        firstPref = 0;
                    }
                    if (item.equals("Smt. Kashibai Navale College of Engineering, Vadgoan")) {
                        firstPref = 1;
                    }
                    if (item.equals("Sinhgad Academy Of Engineering, Kondhwa")) {
                        firstPref = 2;
                    }
                    if (item.equals("Sinhgad Institute of Technology and Science, Narhe")) {
                        firstPref = 3;
                    }
                    if (item.equals("NBN Sinhgad School of Engineering, Ambegoan")) {
                        firstPref = 4;
                    }
                    if (item.equals("RMD Sinhgad School of Engineering, Warje")) {
                        firstPref = 5;
                    }
                    if (item.equals("Sinhgad Institute of Technology, Lonavala")) {
                        firstPref = 6;
                    }
                    if (item.equals("SKN Sinhgad Institute of Technology and Science, Lonavala")) {
                        firstPref = 7;
                    }

                    college.remove(i);
                    second.setAdapter(dataAdapter1);
                } else {
                    sel1 = "Select a Preference";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        second.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                if (!item.equals("Select a Preference")) {
                    // 0. SCOE, 1. SKNCOE, 2. SAE, 3. SITS, 4. NBN, 5. RMD, 6. SIT, 7. SKNSITS
                    if (item.equals("Sinhgad College of Engineering, Vadgoan")) {
                        secondPref = 0;
                    }
                    if (item.equals("Smt. Kashibai Navale College of Engineering, Vadgoan")) {
                        secondPref = 1;
                    }
                    if (item.equals("Sinhgad Academy Of Engineering, Kondhwa")) {
                        secondPref = 2;
                    }
                    if (item.equals("Sinhgad Institute of Technology and Science, Narhe")) {
                        secondPref = 3;
                    }
                    if (item.equals("NBN Sinhgad School of Engineering, Ambegoan")) {
                        secondPref = 4;
                    }
                    if (item.equals("RMD Sinhgad School of Engineering, Warje")) {
                        secondPref = 5;
                    }
                    if (item.equals("Sinhgad Institute of Technology, Lonavala")) {
                        secondPref = 6;
                    }
                    if (item.equals("SKN Sinhgad Institute of Technology and Science, Lonavala")) {
                        secondPref = 7;
                    }

                    college.remove(i);
                    third.setAdapter(dataAdapter1);
                } else {
                    sel2 = "Select a Preference";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        third.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                if (!item.equals("Select a Preference")) {
                    // 0. SCOE, 1. SKNCOE, 2. SAE, 3. SITS, 4. NBN, 5. RMD, 6. SIT, 7. SKNSITS
                    if (item.equals("Sinhgad College of Engineering, Vadgoan")) {
                        thirdPref = 0;
                    }
                    if (item.equals("Smt. Kashibai Navale College of Engineering, Vadgoan")) {
                        thirdPref = 1;
                    }
                    if (item.equals("Sinhgad Academy Of Engineering, Kondhwa")) {
                        thirdPref = 2;
                    }
                    if (item.equals("Sinhgad Institute of Technology and Science, Narhe")) {
                        thirdPref = 3;
                    }
                    if (item.equals("NBN Sinhgad School of Engineering, Ambegoan")) {
                        thirdPref = 4;
                    }
                    if (item.equals("RMD Sinhgad School of Engineering, Warje")) {
                        thirdPref = 5;
                    }
                    if (item.equals("Sinhgad Institute of Technology, Lonavala")) {
                        thirdPref = 6;
                    }
                    if (item.equals("SKN Sinhgad Institute of Technology and Science, Lonavala")) {
                        thirdPref = 7;
                    }
                    college.remove(i);
                    four.setAdapter(dataAdapter1);
                } else {
                    sel3 = "Select a Preference";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        four.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                if (!item.equals("Select a Preference")) {
                    // 0. SCOE, 1. SKNCOE, 2. SAE, 3. SITS, 4. NBN, 5. RMD, 6. SIT, 7. SKNSITS
                    if (item.equals("Sinhgad College of Engineering, Vadgoan")) {
                        fourthPref = 0;
                    }
                    if (item.equals("Smt. Kashibai Navale College of Engineering, Vadgoan")) {
                        fourthPref = 1;
                    }
                    if (item.equals("Sinhgad Academy Of Engineering, Kondhwa")) {
                        fourthPref = 2;
                    }
                    if (item.equals("Sinhgad Institute of Technology and Science, Narhe")) {
                        fourthPref = 3;
                    }
                    if (item.equals("NBN Sinhgad School of Engineering, Ambegoan")) {
                        fourthPref = 4;
                    }
                    if (item.equals("RMD Sinhgad School of Engineering, Warje")) {
                        fourthPref = 5;
                    }
                    if (item.equals("Sinhgad Institute of Technology, Lonavala")) {
                        fourthPref = 6;
                    }
                    if (item.equals("SKN Sinhgad Institute of Technology and Science, Lonavala")) {
                        fourthPref = 7;
                    }
                    college.remove(i);
                    five.setAdapter(dataAdapter1);
                } else {
                    sel4 = "Select a Preference";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        five.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                if (!item.equals("Select a Preference")) {
                    // 0. SCOE, 1. SKNCOE, 2. SAE, 3. SITS, 4. NBN, 5. RMD, 6. SIT, 7. SKNSITS
                    if (item.equals("Sinhgad College of Engineering, Vadgoan")) {
                        fifthPref = 0;
                    }
                    if (item.equals("Smt. Kashibai Navale College of Engineering, Vadgoan")) {
                        fifthPref = 1;
                    }
                    if (item.equals("Sinhgad Academy Of Engineering, Kondhwa")) {
                        fifthPref = 2;
                    }
                    if (item.equals("Sinhgad Institute of Technology and Science, Narhe")) {
                        fifthPref = 3;
                    }
                    if (item.equals("NBN Sinhgad School of Engineering, Ambegoan")) {
                        fifthPref = 4;
                    }
                    if (item.equals("RMD Sinhgad School of Engineering, Warje")) {
                        fifthPref = 5;
                    }
                    if (item.equals("Sinhgad Institute of Technology, Lonavala")) {
                        fifthPref = 6;
                    }
                    if (item.equals("SKN Sinhgad Institute of Technology and Science, Lonavala")) {
                        fifthPref = 7;
                    }

                    college.remove(i);
                    six.setAdapter(dataAdapter1);
                } else {
                    sel5 = "Select a Preference";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        six.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                if (!item.equals("Select a Preference")) {
                    // 0. SCOE, 1. SKNCOE, 2. SAE, 3. SITS, 4. NBN, 5. RMD, 6. SIT, 7. SKNSITS
                    if (item.equals("Sinhgad College of Engineering, Vadgoan")) {
                        sixthPref = 0;
                    }
                    if (item.equals("Smt. Kashibai Navale College of Engineering, Vadgoan")) {
                        sixthPref = 1;
                    }
                    if (item.equals("Sinhgad Academy Of Engineering, Kondhwa")) {
                        sixthPref = 2;
                    }
                    if (item.equals("Sinhgad Institute of Technology and Science, Narhe")) {
                        sixthPref = 3;
                    }
                    if (item.equals("NBN Sinhgad School of Engineering, Ambegoan")) {
                        sixthPref = 4;
                    }
                    if (item.equals("RMD Sinhgad School of Engineering, Warje")) {
                        sixthPref = 5;
                    }
                    if (item.equals("Sinhgad Institute of Technology, Lonavala")) {
                        sixthPref = 6;
                    }
                    if (item.equals("SKN Sinhgad Institute of Technology and Science, Lonavala")) {
                        sixthPref = 7;
                    }

                    college.remove(i);
                    seven.setAdapter(dataAdapter1);
                } else {
                    sel6 = "Select a Preference";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        seven.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                if (!item.equals("Select a Preference")) {
                    // 0. SCOE, 1. SKNCOE, 2. SAE, 3. SITS, 4. NBN, 5. RMD, 6. SIT, 7. SKNSITS
                    if (item.equals("Sinhgad College of Engineering, Vadgoan")) {
                        seventhPref = 0;
                    }
                    if (item.equals("Smt. Kashibai Navale College of Engineering, Vadgoan")) {
                        seventhPref = 1;
                    }
                    if (item.equals("Sinhgad Academy Of Engineering, Kondhwa")) {
                        seventhPref = 2;
                    }
                    if (item.equals("Sinhgad Institute of Technology and Science, Narhe")) {
                        seventhPref = 3;
                    }
                    if (item.equals("NBN Sinhgad School of Engineering, Ambegoan")) {
                        seventhPref = 4;
                    }
                    if (item.equals("RMD Sinhgad School of Engineering, Warje")) {
                        seventhPref = 5;
                    }
                    if (item.equals("Sinhgad Institute of Technology, Lonavala")) {
                        seventhPref = 6;
                    }
                    if (item.equals("SKN Sinhgad Institute of Technology and Science, Lonavala")) {
                        seventhPref = 7;
                    }

                    college.remove(i);
                    eight.setAdapter(dataAdapter1);
                } else {
                    sel7 = "Select a Preference";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        eight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                if (!item.equals("Select a Preference")) {
                    // 0. SCOE, 1. SKNCOE, 2. SAE, 3. SITS, 4. NBN, 5. RMD, 6. SIT, 7. SKNSITS
                    if (item.equals("Sinhgad College of Engineering, Vadgoan")) {
                        eighthPref = 0;
                    }
                    if (item.equals("Smt. Kashibai Navale College of Engineering, Vadgoan")) {
                        eighthPref = 1;
                    }
                    if (item.equals("Sinhgad Academy Of Engineering, Kondhwa")) {
                        eighthPref = 2;
                    }
                    if (item.equals("Sinhgad Institute of Technology and Science, Narhe")) {
                        eighthPref = 3;
                    }
                    if (item.equals("NBN Sinhgad School of Engineering, Ambegoan")) {
                        eighthPref = 4;
                    }
                    if (item.equals("RMD Sinhgad School of Engineering, Warje")) {
                        eighthPref = 5;
                    }
                    if (item.equals("Sinhgad Institute of Technology, Lonavala")) {
                        eighthPref = 6;
                    }
                    if (item.equals("SKN Sinhgad Institute of Technology and Science, Lonavala")) {
                        eighthPref = 7;
                    }

                    college.remove(i);
                } else {
                    sel8 = "Select a Preference";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sel1.equals("Select a Preference") && sel2.equals("Select a Preference") && sel3.equals("Select a Preference") &&
                        sel4.equals("Select a Preference") && sel5.equals("Select a Preference") &&
                        sel6.equals("Select a Preference") && sel7.equals("Select a Preference") &&
                        sel8.equals("Select a Preference") && streamPref.equals("Select a Stream")) {

                    Toast.makeText(FindACollege.this, "Please select a preference", Toast.LENGTH_SHORT).show();

                } else {
                    if (getCet.length() > 0) {
                        cet = Integer.parseInt(getCet.getText().toString());
                        if (cet >= 0 && cet <= 200) {
                            studentPref = new int[]{firstPref, secondPref, thirdPref, fourthPref, fifthPref, sixthPref, seventhPref,
                                    eighthPref};

                            Intent intent = new Intent(FindACollege.this, CollegeResult.class);
                            intent.putExtra("StudentPreference", studentPref);
                            intent.putExtra("StudentCET", cet);
                            intent.putExtra("StudentStream", streamPref);
                            finish();
                            startActivity(intent);

                        } else {
                            Toast.makeText(FindACollege.this, "Please enter correct MH-CET Marks", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
//                else{
//                    if (getCet.length() > 0){
//                        cet = Integer.parseInt(getCet.getText().toString());
//                        if(cet >= 0 && cet <= 200){
//                            studentPref = new int[] {firstPref, secondPref, thirdPref, fourthPref, fifthPref, sixthPref, seventhPref,
//                                    eighthPref};
//
//                        }
//                        else{
//                            Toast.makeText(FindACollege.this, "Please enter correct MH-CET Marks", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                    Toast.makeText(FindACollege.this, "Please select a correct value from the list", Toast.LENGTH_SHORT).show();
//                }

        });
    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sign_out: {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(this, Login.class));
                break;
            }
        }
        return false;
    }
}
