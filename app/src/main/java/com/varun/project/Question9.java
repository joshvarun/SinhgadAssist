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

public class Question9 extends Fragment {

    RadioButton q9a1, q9a2, q9a3, q9a4;
    Button btn9;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question9, null);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        q9a1 = (RadioButton) getView().findViewById(R.id.q9a1);
        q9a2 = (RadioButton) getView().findViewById(R.id.q9a2);
        q9a3 = (RadioButton) getView().findViewById(R.id.q9a3);
        q9a4 = (RadioButton) getView().findViewById(R.id.q9a4);
        btn9 = (Button) getView().findViewById(R.id.btn9);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        btn9.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = app_preferences.edit();

                if (q9a2.isChecked()) {
                    if (app_preferences.getInt("AUTO", 0) == 0) {
                        editor.putInt("AUTO", 1);
                    } else if (app_preferences.getInt("AUTO", 0) == 1) {
                        app_preferences.edit().putInt("AUTO", 2).apply();
                    } else if (app_preferences.getInt("AUTO", 0) == 2) {
                        app_preferences.edit().putInt("AUTO", 3).apply();
                    }
                }
                editor.apply();
                if(q9a1.isChecked() || q9a2.isChecked() || q9a3.isChecked() || q9a4.isChecked()) {
                    Question10 question = new Question10();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, question);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
    }
}


