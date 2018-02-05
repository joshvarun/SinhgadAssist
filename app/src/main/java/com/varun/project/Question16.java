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

public class Question16 extends Fragment {

    RadioButton q16a1, q16a2, q16a3, q16a4;
    Button btn16;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question16, null);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        q16a1 = (RadioButton) getView().findViewById(R.id.q16a1);
        q16a2 = (RadioButton) getView().findViewById(R.id.q16a2);
        q16a3 = (RadioButton) getView().findViewById(R.id.q16a3);
        q16a4 = (RadioButton) getView().findViewById(R.id.q16a4);
        btn16 = (Button) getView().findViewById(R.id.btn16);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        btn16.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = app_preferences.edit();

                if (q16a4.isChecked()) {
                    if (app_preferences.getInt("MECH", 0) == 0) {
                        editor.putInt("MECH", 1);
                    } else if (app_preferences.getInt("MECH", 0) == 1) {
                        app_preferences.edit().putInt("MECH", 2).apply();
                    } else if (app_preferences.getInt("MECH", 0) == 2) {
                        app_preferences.edit().putInt("MECH", 3).apply();
                    }
                }
                editor.apply();
                if(q16a1.isChecked() || q16a2.isChecked() || q16a3.isChecked() || q16a4.isChecked()) {
                    Question17 question = new Question17();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, question);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
    }

}

