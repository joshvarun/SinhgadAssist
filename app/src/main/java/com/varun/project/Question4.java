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

public class Question4 extends Fragment {

    RadioButton q4a3, q4a1, q4a2, q4a4;
    Button btn4;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question4, null);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        q4a1 = (RadioButton) getView().findViewById(R.id.q4a1);
        q4a2 = (RadioButton) getView().findViewById(R.id.q4a2);
        q4a3 = (RadioButton) getView().findViewById(R.id.q4a3);
        q4a4 = (RadioButton) getView().findViewById(R.id.q4a4);
        btn4 = (Button) getView().findViewById(R.id.btn4);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        btn4.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = app_preferences.edit();

                if (q4a3.isChecked()) {
                    if (app_preferences.getInt("CIVIL", 0) == 0) {
                        editor.putInt("CIVIL", 1);
                    } else if (app_preferences.getInt("CIVIL", 0) == 1) {
                        app_preferences.edit().putInt("CIVIL", 2).apply();
                    } else if (app_preferences.getInt("CIVIL", 0) == 2) {
                        app_preferences.edit().putInt("CIVIL", 3).apply();
                    }
                }
                editor.apply();
                if(q4a1.isChecked() || q4a2.isChecked() || q4a3.isChecked() || q4a4.isChecked()) {
                    Question5 question = new Question5();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, question);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
    }
}
