package com.varun.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import static java.lang.Boolean.FALSE;

public class QuizResult extends AppCompatActivity {

    TextView comp_tv, mech_tv, entc_tv, elec_tv, civil_tv, chem_tv, bio_tv, auto_tv;
    TextView compsc, mechsc, entcsc, elecsc, civilsc, chemsc, autosc, biosc;

    int COMP, EnTC, BIO, MECH, CIVIL, CHEM, ELEC, AUTO;
    boolean COMP_Selected, ELEC_EnTC_Selected, CIVIL_Selected, BIO_Selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        //changing statusbar color
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.blueGrey));
        }

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
        COMP = app_preferences.getInt("COMP", 0);
        EnTC = app_preferences.getInt("EnTC", 0);
        BIO = app_preferences.getInt("BIO", 0);
        MECH = app_preferences.getInt("MECH", 0);
        CIVIL = app_preferences.getInt("CIVIL", 0);
        CHEM = app_preferences.getInt("CHEM", 0);
        ELEC = app_preferences.getInt("ELEC", 0);
        AUTO = app_preferences.getInt("AUTO", 0);
        COMP_Selected = app_preferences.getBoolean("COMP_SELECTED", FALSE);
        BIO_Selected = app_preferences.getBoolean("BIO_SELECTED", FALSE);
        ELEC_EnTC_Selected = app_preferences.getBoolean("ELEC_EnTC_SELECTED", FALSE);
        CIVIL_Selected = app_preferences.getBoolean("CIVIL_SELECTED", FALSE);

        comp_tv = (TextView) findViewById(R.id.comp_score);
        comp_tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, COMP));
        compsc = (TextView) findViewById(R.id.comp_score_val);
        compsc.setText(""+COMP);

        mech_tv = (TextView) findViewById(R.id.mech_score);
        mech_tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, MECH));
        mechsc = (TextView) findViewById(R.id.mech_score_val);
        mechsc.setText(""+MECH);

        entc_tv = (TextView) findViewById(R.id.entc_score);
        entc_tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, EnTC));
        entcsc = (TextView) findViewById(R.id.entc_score_val);
        entcsc.setText(""+EnTC);

        elec_tv = (TextView) findViewById(R.id.elec_score);
        elec_tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, ELEC));
        elecsc = (TextView) findViewById(R.id.elec_score_val);
        elecsc.setText(""+ELEC);

        civil_tv = (TextView) findViewById(R.id.civil_score);
        civil_tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, CIVIL));
        civilsc = (TextView) findViewById(R.id.civil_score_val);
        civilsc.setText(""+CIVIL);

        chem_tv = (TextView) findViewById(R.id.chem_score);
        chem_tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, CHEM));
        chemsc = (TextView) findViewById(R.id.chem_score_val);
        chemsc.setText(""+CHEM);

        bio_tv = (TextView) findViewById(R.id.bio_score);
        bio_tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, BIO));
        biosc = (TextView) findViewById(R.id.bio_score_val);
        biosc.setText(""+BIO);

        auto_tv = (TextView) findViewById(R.id.auto_score);
        auto_tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, AUTO));
        autosc = (TextView) findViewById(R.id.auto_score_val);
        autosc.setText(""+AUTO);

    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }
}
