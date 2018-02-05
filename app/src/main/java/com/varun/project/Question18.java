package com.varun.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

public class Question18 extends Fragment {

    RadioButton q18a1, q18a2, q18a3, q18a4;
    Button btn18;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question18, null);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        q18a1 = (RadioButton) getView().findViewById(R.id.q18a1);
        q18a2 = (RadioButton) getView().findViewById(R.id.q18a2);
        q18a3 = (RadioButton) getView().findViewById(R.id.q18a3);
        q18a4 = (RadioButton) getView().findViewById(R.id.q18a4);
        btn18 = (Button) getView().findViewById(R.id.btn18);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        btn18.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = app_preferences.edit();

                if (q18a1.isChecked()) {
                    if (app_preferences.getInt("COMP", 0) == 0) {
                        editor.putInt("COMP", 1);
                    } else if (app_preferences.getInt("COMP", 0) == 1) {
                        app_preferences.edit().putInt("COMP", 2).apply();
                    } else if (app_preferences.getInt("COMP", 0) == 2) {
                        app_preferences.edit().putInt("COMP", 3).apply();
                    }
                }
                editor.apply();
                if(q18a1.isChecked() || q18a2.isChecked() || q18a3.isChecked() || q18a4.isChecked()) {
                    startActivity(new Intent(getActivity(),QuizResult.class));
                }
            }
        });
    }

}

