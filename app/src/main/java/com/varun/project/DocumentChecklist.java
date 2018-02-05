package com.varun.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class DocumentChecklist extends AppCompatActivity {

    CheckBox allotment, sscMarkList, hscMarkList, leaving, proformaCap, jeeScoreCard, gapCer, casteCer, casteVal, nonCreamyL, domicileCertificate, photograph, migration, adhaarCard, nationalityCertificate;
    boolean hasAllotment, hasSscMarkList, hasHscMarkList, hasLeaving, hasproforma, hasJeeScore, hasGapCertificate, hasCasteCertificate, hasCasteValidity, hasNonCreamyLayer, hasDomicileCertificate, hasPhoto, hasMigCertificate, hasadhaarCard, hasNationalityCertificate;

    Button mahaState, outMahaState;

    TextView note1, note2, copies;

    Toolbar toolbar;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_checklist);

        //changing statusbar color
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.blueGrey));
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, Login.class));
        }

        mahaState = (Button) findViewById(R.id.mahaState);
        outMahaState = (Button) findViewById(R.id.outMahaState);

        allotment = (CheckBox) findViewById(R.id.allot);
        sscMarkList = (CheckBox) findViewById(R.id.ssc);
        hscMarkList = (CheckBox) findViewById(R.id.hsc);
        leaving = (CheckBox) findViewById(R.id.leaving);
        proformaCap = (CheckBox) findViewById(R.id.proforma);
        jeeScoreCard = (CheckBox) findViewById(R.id.jeeScore);
        gapCer = (CheckBox) findViewById(R.id.gapCertificate);
        casteCer = (CheckBox) findViewById(R.id.casteCertificate);
        casteVal = (CheckBox) findViewById(R.id.casteValidity);
        nonCreamyL = (CheckBox) findViewById(R.id.nonCreamyLayer);
        adhaarCard = (CheckBox) findViewById(R.id.adhaarCard);
        nationalityCertificate = (CheckBox) findViewById(R.id.nationalityCer);
        domicileCertificate = (CheckBox) findViewById(R.id.domicile);
        photograph = (CheckBox) findViewById(R.id.photo);
        migration = (CheckBox) findViewById(R.id.migration);

        note1 = (TextView) findViewById(R.id.note1);
        note2 = (TextView) findViewById(R.id.note2);
        copies = (TextView) findViewById(R.id.copies);

        mahaState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                migration.setVisibility(View.GONE);

                allotment.setText(getString(R.string.allot));
                allotment.setVisibility(View.VISIBLE);
                hasAllotment = allotment.isChecked();


                sscMarkList.setText(getString(R.string.ssc));
                sscMarkList.setVisibility(View.VISIBLE);
                hasSscMarkList = sscMarkList.isChecked();

                hscMarkList.setText(getString(R.string.hscboard));
                hscMarkList.setVisibility(View.VISIBLE);
                hasHscMarkList = hscMarkList.isChecked();

                leaving.setText(getString(R.string.leaving));
                leaving.setVisibility(View.VISIBLE);
                hasLeaving = leaving.isChecked();

                proformaCap.setText(getString(R.string.proforma));
                proformaCap.setVisibility(View.VISIBLE);
                hasproforma = proformaCap.isChecked();

                jeeScoreCard.setText(getString(R.string.jee));
                jeeScoreCard.setVisibility(View.VISIBLE);
                hasJeeScore = jeeScoreCard.isChecked();

                gapCer.setText(getString(R.string.gap_cert));
                gapCer.setVisibility(View.VISIBLE);
                hasGapCertificate = gapCer.isChecked();

                casteCer.setText(getString(R.string.caste_cert));
                casteCer.setVisibility(View.VISIBLE);
                hasCasteCertificate = casteCer.isChecked();

                casteVal.setText(getString(R.string.caste_validity));
                casteVal.setVisibility(View.VISIBLE);
                hasCasteValidity = casteVal.isChecked();

                nonCreamyL.setText(getString(R.string.non_creamy));
                nonCreamyL.setVisibility(View.VISIBLE);
                hasNonCreamyLayer = nonCreamyL.isChecked();

                adhaarCard.setText(getString(R.string.aadhar));
                adhaarCard.setVisibility(View.VISIBLE);
                hasadhaarCard = adhaarCard.isChecked();

                nationalityCertificate.setText(getString(R.string.nationality_cert));
                nationalityCertificate.setVisibility(View.VISIBLE);
                hasNationalityCertificate = nationalityCertificate.isChecked();

                domicileCertificate.setText(getString(R.string.domicile));
                domicileCertificate.setVisibility(View.VISIBLE);
                hasDomicileCertificate = domicileCertificate.isChecked();

                photograph.setText(getString(R.string.photos));
                photograph.setVisibility(View.VISIBLE);
                hasPhoto = photograph.isChecked();

                note1.setText(R.string.note1);
                note2.setText(R.string.note2);
                copies.setText(R.string.copies);
            }
        });

        outMahaState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                casteCer.setVisibility(View.GONE);
                casteVal.setVisibility(View.GONE);
                nonCreamyL.setVisibility(View.GONE);

                allotment.setText(getString(R.string.allot));
                allotment.setVisibility(View.VISIBLE);

                sscMarkList.setText(getString(R.string.ssc));
                sscMarkList.setVisibility(View.VISIBLE);

                hscMarkList.setText(getString(R.string.hscboard));
                hscMarkList.setVisibility(View.VISIBLE);

                leaving.setText(getString(R.string.leaving));
                leaving.setVisibility(View.VISIBLE);

                proformaCap.setText(getString(R.string.proforma));
                proformaCap.setVisibility(View.VISIBLE);

                jeeScoreCard.setText(getString(R.string.jee));
                jeeScoreCard.setVisibility(View.VISIBLE);

                gapCer.setText(getString(R.string.gap_cert));
                gapCer.setVisibility(View.VISIBLE);

                adhaarCard.setText(getString(R.string.aadhar));
                adhaarCard.setVisibility(View.VISIBLE);

                nationalityCertificate.setText(getString(R.string.nationality_cert));
                nationalityCertificate.setVisibility(View.VISIBLE);

                domicileCertificate.setText(getString(R.string.domicile));
                domicileCertificate.setVisibility(View.VISIBLE);

                photograph.setText(getString(R.string.photos));
                photograph.setVisibility(View.VISIBLE);

                migration.setText(getString(R.string.migration_cert));
                migration.setVisibility(View.VISIBLE);

                note1.setText(R.string.note1);
                note2.setText(R.string.note2);
                copies.setText(R.string.copies);
            }
        });

    }


    @Override
    public void onPause() {
        super.onPause();
        save();
    }

    @Override
    public void onResume() {
        super.onResume();
        allotment.setChecked(load("allotment_check"));
        sscMarkList.setChecked(load("ssc_check"));
        hscMarkList.setChecked(load("hsc_check"));
        leaving.setChecked(load("leaving_check"));
        proformaCap.setChecked(load("proforma_check"));
        jeeScoreCard.setChecked(load("jee_check"));
        gapCer.setChecked(load("gap_check"));
        casteCer.setChecked(load("castecert_check"));
        casteVal.setChecked(load("casteval_check"));
        nonCreamyL.setChecked(load("noncreamy_check"));
        domicileCertificate.setChecked(load("dom_check"));
        photograph.setChecked(load("photo_check"));
        migration.setChecked(load("migration_check"));
        adhaarCard.setChecked(load("aadhar_check"));
        nationalityCertificate.setChecked(load("nat_check"));
    }

    private void save() {
        SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (allotment.isChecked()) {
            editor.putBoolean("allotment_check", true);
            editor.apply();
        } else {
            editor.putBoolean("allotment_check", false);
            editor.apply();
        }

        if (sscMarkList.isChecked()) {
            editor.putBoolean("ssc_check", true);
            editor.apply();
        } else {
            editor.putBoolean("ssc_check", false);
            editor.apply();
        }

        if (hscMarkList.isChecked()) {
            editor.putBoolean("hsc_check", true);
            editor.apply();
        } else {
            editor.putBoolean("hsc_check", false);
            editor.apply();
        }

        if (leaving.isChecked()) {
            editor.putBoolean("leaving_check", true);
            editor.apply();
        } else {
            editor.putBoolean("leaving_check", false);
            editor.apply();
        }

        if (proformaCap.isChecked()) {
            editor.putBoolean("proforma_check", true);
            editor.apply();
        } else {
            editor.putBoolean("proforma_check", false);
            editor.apply();
        }

        if (jeeScoreCard.isChecked()) {
            editor.putBoolean("jee_check", true);
            editor.apply();
        } else {
            editor.putBoolean("jee_check", false);
            editor.apply();
        }

        if (gapCer.isChecked()) {
            editor.putBoolean("gap_check", true);
            editor.apply();
        } else {
            editor.putBoolean("gap_check", false);
            editor.apply();
        }

        if (casteCer.isChecked()) {
            editor.putBoolean("castecert_check", true);
            editor.apply();
        } else {
            editor.putBoolean("castecert_check", false);
            editor.apply();
        }

        if (casteVal.isChecked()) {
            editor.putBoolean("casteval_check", true);
            editor.apply();
        } else {
            editor.putBoolean("casteval_check", false);
            editor.apply();
        }

        if (nonCreamyL.isChecked()) {
            editor.putBoolean("noncreamy_check", true);
            editor.apply();
        } else {
            editor.putBoolean("noncreamy_check", false);
            editor.apply();
        }

        if (domicileCertificate.isChecked()) {
            editor.putBoolean("dom_check", true);
            editor.apply();
        } else {
            editor.putBoolean("dom_check", false);
            editor.apply();
        }

        if (photograph.isChecked()) {
            editor.putBoolean("photo_check", true);
            editor.apply();
        } else {
            editor.putBoolean("photo_check", false);
            editor.apply();
        }

        if (migration.isChecked()) {
            editor.putBoolean("migration_check", true);
            editor.apply();
        } else {
            editor.putBoolean("migration_check", false);
            editor.apply();

        }

        if (adhaarCard.isChecked()) {
            editor.putBoolean("aadhar_check", true);
            editor.apply();
        } else {
            editor.putBoolean("aadhar_check", false);
            editor.apply();
        }

        if (nationalityCertificate.isChecked()) {
            editor.putBoolean("nat_check", true);
            editor.apply();
        } else {
            editor.putBoolean("nat_check", false);
            editor.apply();
        }
    }

    private boolean load(String key) {
        SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);

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
