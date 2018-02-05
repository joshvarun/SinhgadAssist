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

public class Question15 extends Fragment {

    RadioButton q15a1, q15a2, q15a3, q15a4;
    Button btn15;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question15, null);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        q15a1 = (RadioButton) getView().findViewById(R.id.q15a1);
        q15a2 = (RadioButton) getView().findViewById(R.id.q15a2);
        q15a3 = (RadioButton) getView().findViewById(R.id.q15a3);
        q15a4 = (RadioButton) getView().findViewById(R.id.q15a4);
        btn15 = (Button) getView().findViewById(R.id.btn15);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        btn15.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = app_preferences.edit();

                if (q15a4.isChecked()) {
                    if (app_preferences.getInt("BIO", 0) == 0) {
                        editor.putInt("BIO", 1);
                    } else if (app_preferences.getInt("BIO", 0) == 1) {
                        app_preferences.edit().putInt("BIO", 2).apply();
                    } else if (app_preferences.getInt("BIO", 0) == 2) {
                        app_preferences.edit().putInt("BIO", 3).apply();
                    }
                }
                editor.apply();
                if(q15a1.isChecked() || q15a2.isChecked() || q15a3.isChecked() || q15a4.isChecked()) {
                    Question16 question = new Question16();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, question);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
    }

}

