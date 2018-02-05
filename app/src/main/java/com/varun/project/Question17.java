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

public class Question17 extends Fragment {

    RadioButton q17a1, q17a2, q17a3, q17a4;
    Button btn17;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question17, null);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        q17a1 = (RadioButton) getView().findViewById(R.id.q17a1);
        q17a2 = (RadioButton) getView().findViewById(R.id.q17a2);
        q17a3 = (RadioButton) getView().findViewById(R.id.q17a3);
        q17a4 = (RadioButton) getView().findViewById(R.id.q17a4);

        btn17 = (Button) getView().findViewById(R.id.btn17);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        btn17.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = app_preferences.edit();

                if (q17a2.isChecked()) {
                    if (app_preferences.getInt("AUTO", 0) == 0) {
                        editor.putInt("AUTO", 1);
                    } else if (app_preferences.getInt("AUTO", 0) == 1) {
                        app_preferences.edit().putInt("AUTO", 2).apply();
                    } else if (app_preferences.getInt("AUTO", 0) == 2) {
                        app_preferences.edit().putInt("AUTO", 3).apply();
                    }
                }
                editor.apply();
                if(q17a1.isChecked() || q17a2.isChecked() || q17a3.isChecked() || q17a4.isChecked()) {
                    Question18 question = new Question18();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, question);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
    }

}

