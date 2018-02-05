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

public class Question11 extends Fragment {

    RadioButton q11a1, q11a2, q11a3, q11a4;
    Button btn11;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question11, null);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        q11a1 = (RadioButton) getView().findViewById(R.id.q11a1);
        q11a2 = (RadioButton) getView().findViewById(R.id.q11a2);
        q11a3 = (RadioButton) getView().findViewById(R.id.q11a3);
        q11a4 = (RadioButton) getView().findViewById(R.id.q11a4);
        btn11 = (Button) getView().findViewById(R.id.btn11);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        btn11.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = app_preferences.edit();

                if (q11a1.isChecked()) {
                    if (app_preferences.getInt("CHEM", 0) == 0) {
                        editor.putInt("CHEM", 1);
                    } else if (app_preferences.getInt("CHEM", 0) == 1) {
                        app_preferences.edit().putInt("CHEM", 2).apply();
                    } else if (app_preferences.getInt("CHEM", 0) == 2) {
                        app_preferences.edit().putInt("CHEM", 3).apply();
                    }
                }
                editor.apply();
                if(q11a1.isChecked() || q11a2.isChecked() || q11a3.isChecked() || q11a4.isChecked()) {
                    Question12 question = new Question12();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, question);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
    }
}

