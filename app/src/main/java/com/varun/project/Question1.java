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


public class Question1 extends Fragment {

    RadioButton q1a1;
    RadioButton q1a2;
    RadioButton q1a3;

    Button btn1;
    //FragmentManager manager= getFragmentManager();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.question1, null);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        q1a1 = (RadioButton) getView().findViewById(R.id.q1a1);
        q1a2 = (RadioButton) getView().findViewById(R.id.q1a2);
        q1a3 = (RadioButton) getView().findViewById(R.id.q1a3);



        btn1 = (Button) getView().findViewById(R.id.btn1);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        btn1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = app_preferences.edit();

                editor.putInt("COMP", 0);
                editor.putInt("EnTC", 0);
                editor.putInt("BIO", 0);
                editor.putInt("MECH", 0);
                editor.putInt("CIVIL", 0);
                editor.putInt("CHEM", 0);
                editor.putInt("ELEC", 0);
                editor.putInt("AUTO", 0);

                if (q1a1.isChecked()) {
                    if (app_preferences.getInt("AUTO", 0) == 0) {
                        editor.putInt("AUTO", 1);
                    } else if (app_preferences.getInt("AUTO", 0) == 1) {
                        app_preferences.edit().putInt("AUTO", 2).apply();
                    } else if (app_preferences.getInt("AUTO", 0) == 2) {
                        app_preferences.edit().putInt("AUTO", 3).apply();
                    }

                    if (app_preferences.getInt("MECH", 0) == 0) {
                        editor.putInt("MECH", 1);
                    } else if (app_preferences.getInt("MECH", 0) == 1) {
                        app_preferences.edit().putInt("MECH", 2).apply();
                    } else if (app_preferences.getInt("MECH", 0) == 2) {
                        app_preferences.edit().putInt("MECH", 3).apply();
                    }
                }
                if (q1a2.isChecked()) {
                    if (app_preferences.getInt("CHEM", 0) == 0) {
                        editor.putInt("CHEM", 1);
                    } else if (app_preferences.getInt("CHEM", 0) == 1) {
                        app_preferences.edit().putInt("CHEM", 2).apply();
                    } else if (app_preferences.getInt("CHEM", 0) == 2) {
                        app_preferences.edit().putInt("CHEM", 3).apply();
                    }
                    if (app_preferences.getInt("CIVIL", 0) == 0) {
                        editor.putInt("CIVIL", 1);
                    } else if (app_preferences.getInt("CIVIL", 0) == 1) {
                        app_preferences.edit().putInt("CIVIL", 2).apply();
                    } else if (app_preferences.getInt("CIVIL", 0) == 2) {
                        app_preferences.edit().putInt("CIVIL", 3).apply();
                    }
                }

                if (q1a3.isChecked()){
                    if (app_preferences.getInt("MECH", 0) == 0) {
                        editor.putInt("MECH", 1);
                    } else if (app_preferences.getInt("MECH", 0) == 1) {
                        app_preferences.edit().putInt("MECH", 2).apply();
                    } else if (app_preferences.getInt("MECH", 0) == 2) {
                        app_preferences.edit().putInt("MECH", 3).apply();
                    }

                    if (app_preferences.getInt("COMP", 0) == 0) {
                        editor.putInt("COMP", 1);
                    } else if (app_preferences.getInt("COMP", 0) == 1) {
                        app_preferences.edit().putInt("COMP", 2).apply();
                    } else if (app_preferences.getInt("COMP", 0) == 2) {
                        app_preferences.edit().putInt("COMP", 3).apply();
                    }

                    if (app_preferences.getInt("ELEC", 0) == 0) {
                        editor.putInt("ELEC", 1);
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

                editor.apply();

                if(q1a1.isChecked() || q1a2.isChecked() || q1a3.isChecked()){
                    Question2 question = new Question2();
                    getActivity().getSupportFragmentManager().popBackStack();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, question);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }

            }
        });

    }

}
