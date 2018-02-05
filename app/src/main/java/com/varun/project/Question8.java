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

public class Question8 extends Fragment {

    RadioButton q8a1, q8a2, q8a3, q8a4;
    Button btn8;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question8, null);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        q8a1 = (RadioButton) getView().findViewById(R.id.q8a1);
        q8a2 = (RadioButton) getView().findViewById(R.id.q8a2);
        q8a3 = (RadioButton) getView().findViewById(R.id.q8a3);
        q8a4 = (RadioButton) getView().findViewById(R.id.q8a4);
        btn8 = (Button) getView().findViewById(R.id.btn8);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        btn8.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = app_preferences.edit();

                if (q8a3.isChecked()) {
                    if (app_preferences.getInt("MECH", 0) == 0) {
                        editor.putInt("MECH", 1);
                    } else if (app_preferences.getInt("MECH", 0) == 1) {
                        app_preferences.edit().putInt("MECH", 2).apply();
                    } else if (app_preferences.getInt("MECH", 0) == 2) {
                        app_preferences.edit().putInt("MECH", 3).apply();
                    }
                }
                editor.apply();
                if(q8a1.isChecked() || q8a2.isChecked() || q8a3.isChecked() || q8a4.isChecked()) {
                    Question9 question = new Question9();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, question);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
    }

}

