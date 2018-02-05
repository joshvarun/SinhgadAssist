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

public class Question3 extends Fragment {

	RadioButton q3a1, q3a2, q3a3;
	RadioButton q3a4;
	Button btn3;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		return inflater.inflate(R.layout.question3, null);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		q3a1 = (RadioButton)getView().findViewById(R.id.q3a1);
        q3a2 = (RadioButton)getView().findViewById(R.id.q3a2);
        q3a3 = (RadioButton)getView().findViewById(R.id.q3a3);
        q3a4 = (RadioButton)getView().findViewById(R.id.q3a4);
		btn3 = (Button)getView().findViewById(R.id.btn3);

		
		final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
		btn3.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
                SharedPreferences.Editor editor = app_preferences.edit();
				
				if (q3a4.isChecked()) {
					if (app_preferences.getInt("CHEM", 0) == 0) {
						editor.putInt("CHEM", 1);
					} else if (app_preferences.getInt("CHEM", 0) == 1) {
						app_preferences.edit().putInt("CHEM", 2).apply();
					} else if (app_preferences.getInt("CHEM", 0) == 2) {
						app_preferences.edit().putInt("CHEM", 3).apply();
					}
				}
                editor.apply();
				if(q3a1.isChecked() || q3a2.isChecked() || q3a3.isChecked() || q3a4.isChecked()) {
					Question4 question = new Question4();
					FragmentTransaction transaction = getFragmentManager().beginTransaction();
					transaction.replace(R.id.fragment_container, question);
					transaction.addToBackStack(null);
					transaction.commit();
				}
            }

		});
	}
}
