package com.varun.project;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Varun Joshi on 15-Feb-17.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(FragmentManager fm) {

        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new Question1();
        switch(position){
            case 0:
                fragment = new Question1();
                break;
            case 1:
                fragment = new Question2();
                break;
            case 2:
                fragment = new Question3();
                break;
            case 3:
                fragment = new Question4();
                break;
            case 4:
                fragment = new Question5();
                break;
            case 5:
                fragment = new Question6();
                break;
            case 6:
                fragment = new Question7();
                break;
            case 7:
                fragment = new Question8();
                break;
            case 8:
                fragment = new Question9();
                break;
            case 9:
                fragment = new Question10();
                break;
            case 10:
                fragment = new Question11();
                break;
            case 11:
                fragment = new Question12();
                break;
            case 12:
                fragment = new Question13();
                break;
            case 13:
                fragment = new Question14();
                break;
            case 14:
                fragment = new Question15();
                break;
            case 15:
                fragment = new Question16();
                break;
            case 16:
                fragment = new Question17();
                break;
            case 17:
                fragment = new Question18();
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 17;
    }

    @Override
    public CharSequence getPageTitle(int position){
        String title = "";
        switch(position){
            case 0:
                title = "Question 1";
                break;
            case 1:
                title = "Question 2";
                break;
            case 2:
                title = "Question 3";
                break;
            case 3:
                title = "Question 4";
                break;
            case 4:
                title = "Question 5";
                break;
            case 5:
                title = "Question 6";
                break;
            case 6:
                title = "Question 7";
                break;
            case 7:
                title = "Question 8";
                break;
            case 8:
                title = "Question 9";
                break;
            case 9:
                title = "Question 10";
                break;
            case 10:
                title = "Question 11";
                break;
            case 11:
                title = "Question 12";
                break;
            case 12:
                title = "Question 13";
                break;
            case 13:
                title = "Question 14";
                break;
            case 14:
                title = "Question 15";
                break;
            case 15:
                title = "Question 16";
                break;
            case 16:
                title = "Question 17";
                break;
            case 17:
                title = "Question 18";
                break;
            case 18:
                title = "Submit Quiz";
                break;
        }
        return title;
    }

}
