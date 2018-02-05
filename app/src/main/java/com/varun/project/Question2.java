package com.varun.project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import static java.lang.Boolean.TRUE;

public class Question2 extends Fragment {

    RadioButton q2a1;
    RadioButton q2a2;
    RadioButton q2a3;
    RadioButton q2a4;
    Button btn2;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.question2, null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        q2a1 = (RadioButton) getView().findViewById(R.id.q2a1);
        q2a2 = (RadioButton) getView().findViewById(R.id.q2a2);
        q2a3 = (RadioButton) getView().findViewById(R.id.q2a3);
        q2a4 = (RadioButton) getView().findViewById(R.id.q2a4);
        btn2 = (Button) getView().findViewById(R.id.btn2);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        btn2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = app_preferences.edit();

                if (q2a1.isChecked()) {
                    if (app_preferences.getInt("COMP", 0) == 0) {
                        editor.putInt("COMP", 1);
                        editor.putBoolean("COMP_SELECTED",TRUE);
                    } else if (app_preferences.getInt("COMP", 0) == 1) {
                        app_preferences.edit().putInt("COMP", 2).apply();
                    } else if (app_preferences.getInt("COMP", 0) == 2) {
                        app_preferences.edit().putInt("COMP", 3).apply();
                    }
                }
                if (q2a2.isChecked()) {
                    if (app_preferences.getInt("ELEC", 0) == 0) {
                        editor.putInt("ELEC", 1);
                        editor.putBoolean("ELEC_EnTC_SELECTED",TRUE);
                    } else if (app_preferences.getInt("ELEC", 0) == 1) {
                        app_preferences.edit().putInt("ELEC", 2).apply();
                    } else if (app_preferences.getInt("ELEC", 0) == 2) {
                        app_preferences.edit().putInt("ELEC", 3).apply();
                    }

                    if (app_preferences.getInt("EnTC", 0) == 0) {
                        editor.putInt("EnTC", 1);
                    } else if (app_preferences.getInt("EnTC", 0) == 1) {
                        app_preferences.edit().putInt("EnTC", 2).apply();
                    } else if (app_preferences.getInt("EnTC", 0) == 2) {
                        app_preferences.edit().putInt("EnTC", 3).apply();
                    }
                }

                if (q2a3.isChecked()) {
                    if (app_preferences.getInt("BIO", 0) == 0) {
                        editor.putInt("BIO", 1);
                        editor.putBoolean("BIO_SELECTED",TRUE);
                    } else if (app_preferences.getInt("BIO", 0) == 1) {
                        app_preferences.edit().putInt("BIO", 2).apply();
                    } else if (app_preferences.getInt("BIO", 0) == 2) {
                        app_preferences.edit().putInt("BIO", 3).apply();
                    }
                }
                if (q2a4.isChecked()) {
                    if (app_preferences.getInt("CIVIL", 0) == 0) {
                        editor.putInt("CIVIL", 1);
                        editor.putBoolean("CIVIL_SELECTED",TRUE);
                    } else if (app_preferences.getInt("CIVIL", 0) == 1) {
                        app_preferences.edit().putInt("CIVIL", 2).apply();
                    } else if (app_preferences.getInt("CIVIL", 0) == 2) {
                        app_preferences.edit().putInt("CIVIL", 3).apply();
                    }
                }
                editor.apply();

                if(q2a1.isChecked() || q2a2.isChecked() || q2a3.isChecked() || q2a4.isChecked()) {
                    Question3 question = new Question3();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, question);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
    }
}
