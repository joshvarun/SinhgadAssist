package com.varun.project;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import static com.varun.project.R.layout.menu_list;

/**
 * Created by User on 22-Mar-17.
 */

public class HomeMenuAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;

    public HomeMenuAdapter(Activity context, String[] itemname, Integer[] imgid) {
        super(context, R.layout.menu_list, itemname);
        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(menu_list, null,true);

        TextView option = (TextView) rowView.findViewById(R.id.option);
        ImageView icon = (ImageView) rowView.findViewById(R.id.icon_menu);

        option.setText(itemname[position]);
        icon.setImageResource(imgid[position]);

        return rowView;
    };
}
