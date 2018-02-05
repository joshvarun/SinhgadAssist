package com.varun.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class CollegeResult extends AppCompatActivity {

    Intent intent;

    int studentCET, college;
    int[] studentPref;
    String studentStream, finalButton;
    boolean flag = false;
    int[] College;

    TextView finalCollege, according;

    Button knowMore;

    de.hdodenhof.circleimageview.CircleImageView imageView;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_result);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, Login.class));
        }

        //changing statusbar color
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.blueGrey));
        }

        intent = getIntent();
        studentCET = intent.getIntExtra("StudentCET", 0);
        studentPref = intent.getIntArrayExtra("StudentPreference");
        studentStream = intent.getStringExtra("StudentStream");

        finalCollege = (TextView) findViewById(R.id.finalCollege);
        imageView = (de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.resultImage);
        according = (TextView) findViewById(R.id.according);
        knowMore = (Button) findViewById(R.id.knowMore);

        if (studentStream.equals("Computers")) {
            College = Computer();
        }
        if (studentStream.equals("Mechanical")) {
            College = Mechanical();
        }
        if (studentStream.equals("IT")) {
            College = IT();
        }
        if (studentStream.equals("Electrical")) {
            College = Electrical();
        }
        if (studentStream.equals("Electronics")) {
            College = Electronics();
        }
        if (studentStream.equals("Production")) {
            College = Production();
        }
        if (studentStream.equals("Chemical")) {
            College = Chemistry();
        }
        if (studentStream.equals("Civil")) {
            College = Civil();
        }

        for (int j = 0; j < 8; j++) {
            int i = studentPref[j];

            if (College[i] < studentCET) {
                college = i;
                flag = true;
                break;
            }
        }
        // 0. SCOE, 1. SKNCOE, 2. SAE, 3. SITS, 4. NBN, 5. RMD, 6. SIT, 7. SKNSITS
        if (college == 0) {
            finalCollege.setText("Sinhgad College of Engineering, Vadgoan");
            imageView.setImageResource(R.drawable.scoe);
            finalButton = "Sinhgad College of Enigneering (SCOE)";
        }
        if (college == 1) {
            finalCollege.setText("Smt. Kashibai Navale College of Engineering, Vadgoan");
            imageView.setImageResource(R.drawable.skn_clg);
            finalButton = "Smt. Kashibai Navale College of Enigneering (SKNCOE)";
        }
        if (college == 2) {
            finalCollege.setText("Sinhgad Academy Of Engineering, Kondhwa");
            imageView.setImageResource(R.drawable.sae);
            finalButton = "Sinhgad Academy of Engineering (SAE)";
        }
        if (college == 3) {
            finalCollege.setText("Sinhgad Institute of Technology and Science, Narhe");
            imageView.setImageResource(R.drawable.sits_clg);
            finalButton = "Sinhgad Institute of Technology & Science (SITS)";
        }
        if (college == 4) {
            finalCollege.setText("NBN Sinhgad School of Engineering, Ambegoan");
            imageView.setImageResource(R.drawable.nbn);
            finalButton = "NBN Sinhgad School of Engineering (NBNSSOE)";
        }
        if (college == 5) {
            finalCollege.setText("RMD Sinhgad School of Engineering, Warje");
            imageView.setImageResource(R.drawable.rmd);
            finalButton = "RMD Sinhgad School of Engineering (RMDSSOE)";
        }
        if (college == 6) {
            finalCollege.setText("Sinhgad Institute of Technology, Lonavala)");
            imageView.setImageResource(R.drawable.sinhgadlonavala);
            finalButton = "Sinhgad Institute of Technology (SIT)";
        }
        if (college == 7) {
            finalCollege.setText("SKN Sinhgad Institute of Technology and Science, Lonavala");
            imageView.setImageResource(R.drawable.sitlona);
            finalButton = "Smt. Kashibai Navale Sinhgad Institute of Technology & Science (SKNSITS)";
        }

        if (!flag) {
            according.setVisibility(View.GONE);
            knowMore.setVisibility(View.GONE);
            finalCollege.setText("Sorry, no match found.");
        }


        knowMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (finalButton.equals("Sinhgad College of Enigneering (SCOE)")) {
                    Intent intent = new Intent(CollegeResult.this, DisplayCollegeInfo.class);
                    intent.putExtra("Selected", finalButton);
                    finish();
                    startActivity(intent);
                }
                if (finalButton.equals("Smt. Kashibai Navale College of Enigneering (SKNCOE)")) {
                    Intent intent = new Intent(CollegeResult.this, DisplayCollegeInfo.class);
                    intent.putExtra("Selected", finalButton);
                    finish();
                    startActivity(intent);
                }
                if (finalButton.equals("Sinhgad Academy of Engineering (SAE)")) {
                    Intent intent = new Intent(CollegeResult.this, DisplayCollegeInfo.class);
                    intent.putExtra("Selected", finalButton);
                    finish();
                    startActivity(intent);
                }
                if (finalButton.equals("Sinhgad Institute of Technology & Science (SITS)")) {
                    Intent intent = new Intent(CollegeResult.this, DisplayCollegeInfo.class);
                    intent.putExtra("Selected", finalButton);
                    finish();
                    startActivity(intent);
                }
                if (finalButton.equals("NBN Sinhgad School of Engineering (NBNSSOE)")) {
                    Intent intent = new Intent(CollegeResult.this, DisplayCollegeInfo.class);
                    intent.putExtra("Selected", finalButton);
                    finish();
                    startActivity(intent);
                }
                if (finalButton.equals("RMD Sinhgad School of Engineering (RMDSSOE)")) {
                    Intent intent = new Intent(CollegeResult.this, DisplayCollegeInfo.class);
                    intent.putExtra("Selected", finalButton);
                    finish();
                    startActivity(intent);
                }
                if (finalButton.equals("Sinhgad Institute of Technology (SIT)")) {
                    Intent intent = new Intent(CollegeResult.this, DisplayCollegeInfo.class);
                    intent.putExtra("Selected", finalButton);
                    finish();
                    startActivity(intent);
                }
                if (finalButton.equals("Smt. Kashibai Navale Sinhgad Institute of Technology & Science (SKNSITS)")) {
                    Intent intent = new Intent(CollegeResult.this, DisplayCollegeInfo.class);
                    intent.putExtra("Selected", finalButton);
                    finish();
                    startActivity(intent);
                }
            }
        });

    }

    public static int[] Computer() {
        // 0. SCOE, 1. SKNCOE, 2. SAE, 3. SITS, 4. NBN, 5. RMD, 6. SIT, 7. SKNSITS
        return new int[]{126, 107, 98, 95, 88, 87, 78, 48};
    }

    public static int[] IT() {
        // 0. SCOE, 1. SKNCOE, 2. SAE, 3. SITS, 4. NBN, 5. RMD, 6. SIT, 7. SKNSITS
        return new int[]{106, 98, 89, 82, 80, 76, 69, 55};
    }

    public static int[] Mechanical() {
        // 0. SCOE, 1. SKNCOE, 2. SAE, 3. SITS, 4. NBN, 5. RMD, 6. SIT, 7. SKNSITS
        return new int[]{140, 129, 113, 107, 108, 97, 100, 80};
    }

    public static int[] Civil() {
        // 0. SCOE, 1. SKNCOE, 2. SAE, 3. SITS, 4. NBN, 5. RMD, 6. SIT, 7. SKNSITS
        return new int[]{126, 999, 100, 94, 999, 83, 999, 999};
    }

    public static int[] Electrical() {
        // 0. SCOE, 1. SKNCOE, 2. SAE, 3. SITS, 4. NBN, 5. RMD, 6. SIT, 7. SKNSITS
        return new int[]{999, 999, 999, 999, 78, 999, 70, 60};
    }

    public static int[] Electronics() {
        // 0. SCOE, 1. SKNCOE, 2. SAE, 3. SITS, 4. NBN, 5. RMD, 6. SIT, 7. SKNSITS
        return new int[]{113, 96, 86, 78, 77, 72, 60, 61};
    }

    public static int[] Production() {
        // 0. SCOE, 1. SKNCOE, 2. SAE, 3. SITS, 4. NBN, 5. RMD, 6. SIT, 7. SKNSITS
        return new int[]{110, 999, 999, 999, 999, 999, 999, 999};
    }

    public static int[] Chemistry() {
        // 0. SCOE, 1. SKNCOE, 2. SAE, 3. SITS, 4. NBN, 5. RMD, 6. SIT, 7. SKNSITS
        return new int[]{103, 999, 999, 999, 999, 999, 999, 999};
    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(this, FindACollege.class));
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