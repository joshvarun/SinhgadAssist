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

public class Question14 extends Fragment {

    RadioButton q14a1, q14a2, q14a3, q14a4;
    Button btn14;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question14, null);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        q14a1 = (RadioButton) getView().findViewById(R.id.q14a1);
        q14a2 = (RadioButton) getView().findViewById(R.id.q14a2);
        q14a3 = (RadioButton) getView().findViewById(R.id.q14a3);
        q14a4 = (RadioButton) getView().findViewById(R.id.q14a4);
        btn14 = (Button) getView().findViewById(R.id.btn14);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        btn14.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = app_preferences.edit();

                if (q14a1.isChecked()) {
                    if (app_preferences.getInt("EnTC", 0) == 0) {
                        editor.putInt("EnTC", 1);
                    } else if (app_preferences.getInt("EnTC", 0) == 1) {
                        app_preferences.edit().putInt("EnTC", 2).apply();
                    } else if (app_preferences.getInt("EnTC", 0) == 2) {
                        app_preferences.edit().putInt("EnTC", 3).apply();
                    }
                }
                editor.apply();
                if(q14a1.isChecked() || q14a2.isChecked() || q14a3.isChecked() || q14a4.isChecked()) {
                    Question15 question = new Question15();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, question);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
    }

}

