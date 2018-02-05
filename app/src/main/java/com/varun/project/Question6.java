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

public class Question6 extends Fragment {

    RadioButton q6a4, q6a1, q6a2, q6a3;
    Button btn6;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question6, null);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        q6a1 = (RadioButton) getView().findViewById(R.id.q6a1);
        q6a2 = (RadioButton) getView().findViewById(R.id.q6a2);
        q6a3 = (RadioButton) getView().findViewById(R.id.q6a3);
        q6a4 = (RadioButton) getView().findViewById(R.id.q6a4);
        btn6 = (Button) getView().findViewById(R.id.btn6);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        btn6.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = app_preferences.edit();

                if (q6a4.isChecked()) {
                    if (app_preferences.getInt("EnTC", 0) == 0) {
                        editor.putInt("EnTC", 1);
                    } else if (app_preferences.getInt("EnTC", 0) == 1) {
                        app_preferences.edit().putInt("EnTC", 2).apply();
                    } else if (app_preferences.getInt("EnTC", 0) == 2) {
                        app_preferences.edit().putInt("EnTC", 3).apply();
                    }
                }
                editor.apply();
                if(q6a1.isChecked() || q6a2.isChecked() || q6a3.isChecked() || q6a4.isChecked()) {
                    Question7 question = new Question7();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, question);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
    }

}
