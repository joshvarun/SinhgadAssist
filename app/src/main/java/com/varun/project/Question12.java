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

public class Question12 extends Fragment {

    RadioButton q12a1, q12a2, q12a3, q12a4;
    Button btn12;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question12, null);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        q12a1 = (RadioButton) getView().findViewById(R.id.q12a1);
        q12a2 = (RadioButton) getView().findViewById(R.id.q12a2);
        q12a3 = (RadioButton) getView().findViewById(R.id.q12a3);
        q12a4 = (RadioButton) getView().findViewById(R.id.q12a4);
        btn12 = (Button) getView().findViewById(R.id.btn12);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        btn12.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = app_preferences.edit();

                if (q12a4.isChecked()) {
                    if (app_preferences.getInt("CIVIL", 0) == 0) {
                        editor.putInt("CIVIL", 1);
                    } else if (app_preferences.getInt("CIVIL", 0) == 1) {
                        app_preferences.edit().putInt("CIVIL", 2).apply();
                    } else if (app_preferences.getInt("CIVIL", 0) == 2) {
                        app_preferences.edit().putInt("CIVIL", 3).apply();
                    }
                }
                editor.apply();
                if(q12a1.isChecked() || q12a2.isChecked() || q12a3.isChecked() || q12a4.isChecked()) {
                    Question13 question = new Question13();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, question);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
    }

}

