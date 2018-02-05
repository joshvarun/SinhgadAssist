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

public class Question13 extends Fragment {

    RadioButton q13a1, q13a2, q13a3, q13a4;
    Button btn13;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question13, null);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        q13a1 = (RadioButton) getView().findViewById(R.id.q13a1);
        q13a2 = (RadioButton) getView().findViewById(R.id.q13a2);
        q13a3 = (RadioButton) getView().findViewById(R.id.q13a3);
        q13a4 = (RadioButton) getView().findViewById(R.id.q13a4);

        btn13 = (Button) getView().findViewById(R.id.btn13);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        btn13.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = app_preferences.edit();

                if (q13a3.isChecked()) {
                    if (app_preferences.getInt("ELEC", 0) == 0) {
                        editor.putInt("ELEC", 1);
                    } else if (app_preferences.getInt("ELEC", 0) == 1) {
                        app_preferences.edit().putInt("ELEC", 2).apply();
                    } else if (app_preferences.getInt("ELEC", 0) == 2) {
                        app_preferences.edit().putInt("ELEC", 3).apply();
                    }
                }
                editor.apply();
                if(q13a1.isChecked() || q13a2.isChecked() || q13a3.isChecked() || q13a4.isChecked()) {
                    Question14 question = new Question14();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, question);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
    }

}

