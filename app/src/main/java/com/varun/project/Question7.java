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

public class Question7 extends Fragment {

    RadioButton q7a1, q7a2, q7a3, q7a4;
    Button btn7;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question7, null);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        q7a1 = (RadioButton) getView().findViewById(R.id.q7a1);
        q7a2 = (RadioButton) getView().findViewById(R.id.q7a2);
        q7a3 = (RadioButton) getView().findViewById(R.id.q7a3);
        q7a4 = (RadioButton) getView().findViewById(R.id.q7a4);
        btn7 = (Button) getView().findViewById(R.id.btn7);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        btn7.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = app_preferences.edit();

                if (q7a4.isChecked()) {
                    if (app_preferences.getInt("BIO", 0) == 0) {
                        editor.putInt("BIO", 1);
                    } else if (app_preferences.getInt("BIO", 0) == 1) {
                        app_preferences.edit().putInt("BIO", 2).apply();
                    } else if (app_preferences.getInt("BIO", 0) == 2) {
                        app_preferences.edit().putInt("BIO", 3).apply();
                    }
                }
                editor.apply();
                if(q7a1.isChecked() || q7a2.isChecked() || q7a3.isChecked() || q7a4.isChecked()) {
                    Question8 question = new Question8();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, question);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
    }
}

