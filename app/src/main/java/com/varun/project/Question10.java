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

public class Question10 extends Fragment {

    RadioButton q10a1, q10a2, q10a3, q10a4;
    Button btn10;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question10, null);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        q10a1 = (RadioButton) getView().findViewById(R.id.q10a1);
        q10a2 = (RadioButton) getView().findViewById(R.id.q10a2);
        q10a3 = (RadioButton) getView().findViewById(R.id.q10a3);
        q10a4 = (RadioButton) getView().findViewById(R.id.q10a4);
        btn10 = (Button) getView().findViewById(R.id.btn10);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        btn10.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = app_preferences.edit();

                if (q10a2.isChecked()) {
                    if (app_preferences.getInt("COMP", 0) == 0) {
                        editor.putInt("COMP", 1);
                    } else if (app_preferences.getInt("COMP", 0) == 1) {
                        app_preferences.edit().putInt("COMP", 2).apply();
                    } else if (app_preferences.getInt("COMP", 0) == 2) {
                        app_preferences.edit().putInt("COMP", 3).apply();
                    }
                }
                editor.apply();
                if(q10a1.isChecked() || q10a2.isChecked() || q10a3.isChecked() || q10a4.isChecked()) {
                    Question11 question = new Question11();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, question);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
    }
}

