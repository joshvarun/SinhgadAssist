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

public class Question5 extends Fragment {

    RadioButton q5a2, q5a1, q5a3, q5a4;
    Button btn5;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question5, null);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        q5a1 = (RadioButton) getView().findViewById(R.id.q5a1);
        q5a2 = (RadioButton) getView().findViewById(R.id.q5a2);
        q5a3 = (RadioButton) getView().findViewById(R.id.q5a3);
        q5a4 = (RadioButton) getView().findViewById(R.id.q5a4);
        btn5 = (Button) getView().findViewById(R.id.btn5);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        btn5.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = app_preferences.edit();

                if (q5a2.isChecked()) {
                    if (app_preferences.getInt("ELEC", 0) == 0) {
                        editor.putInt("ELEC", 1);
                    } else if (app_preferences.getInt("ELEC", 0) == 1) {
                        app_preferences.edit().putInt("ELEC", 2).apply();
                    } else if (app_preferences.getInt("ELEC", 0) == 2) {
                        app_preferences.edit().putInt("ELEC", 3).apply();
                    }
                }
                editor.apply();
                if(q5a1.isChecked() || q5a2.isChecked() || q5a3.isChecked() || q5a4.isChecked()) {
                    Question6 question = new Question6();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, question);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
    }
}
