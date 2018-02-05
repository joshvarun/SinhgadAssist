package com.varun.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.ms.square.android.expandabletextview.ExpandableTextView;

public class

AdmissionInfo extends AppCompatActivity {

    LinearLayout collapse_eligibility;
    LinearLayout collapse_exam;
    LinearLayout collapse_reservation;

    LinearLayout eligibility_contents;
    LinearLayout exam_contents;
    LinearLayout reservation_contents;

    Intent intent;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission_info);

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

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        eligibility_contents = (LinearLayout) findViewById(R.id.eligibility_contents);
        exam_contents = (LinearLayout) findViewById(R.id.exam_contents);
        reservation_contents = (LinearLayout) findViewById(R.id.reservation_contents);

        TextView title1 = (TextView) findViewById(R.id.sample1).findViewById(R.id.title);
        title1.setText(R.string.u);

        ExpandableTextView expTv1 = (ExpandableTextView) findViewById(R.id.sample1)
                .findViewById(R.id.expand_text_view);
        expTv1.setText(getString(R.string.uni_info_text));

        TextView title2 = (TextView) findViewById(R.id.sample2).findViewById(R.id.title);
        title2.setText(R.string.a);

        ExpandableTextView expTv2 = (ExpandableTextView) findViewById(R.id.sample2)
                .findViewById(R.id.expand_text_view);
        expTv2.setText(getString(R.string.admi_info_text));

        collapse_eligibility = (LinearLayout) findViewById(R.id.collapse_eligibility);
        collapse_eligibility.setVisibility(View.GONE);

        collapse_exam = (LinearLayout) findViewById(R.id.collapse_exam);
        collapse_exam.setVisibility(View.GONE);

        collapse_reservation = (LinearLayout) findViewById(R.id.collapse_reservation);
        collapse_reservation.setVisibility(View.GONE);

        eligibility_contents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (collapse_eligibility.isShown()) {
                    Fx.slide_up(getApplicationContext(), collapse_eligibility);
                    collapse_eligibility.setVisibility(View.GONE);
                } else {
                    collapse_eligibility.setVisibility(View.VISIBLE);
                    Fx.slide_down(getApplicationContext(), collapse_eligibility);
                }
            }
        });

        exam_contents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (collapse_exam.isShown()) {
                    Fx.slide_up(getApplicationContext(), collapse_exam);
                    collapse_exam.setVisibility(View.GONE);
                } else {
                    collapse_exam.setVisibility(View.VISIBLE);
                    Fx.slide_down(getApplicationContext(), collapse_exam);
                }
            }
        });

        reservation_contents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (collapse_reservation.isShown()) {
                    Fx.slide_up(getApplicationContext(), collapse_reservation);
                    collapse_reservation.setVisibility(View.GONE);
                } else {
                    collapse_reservation.setVisibility(View.VISIBLE);
                    Fx.slide_down(getApplicationContext(), collapse_reservation);
                }
            }
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