package com.varun.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    ListView list;

    FirebaseAuth firebaseAuth;

    LinearLayout linear1;

    String[] itemname ={
            "Admission Information",
            "Stream Suggestor",
            "Find A College",
            "What's Nearby?",
            "Document Checklist",
            "Edit Profile"
    };

    Integer[] imgid={
            R.drawable.drawer_admissioninfo,
            R.drawable.drawer_streamsuggestor,
            R.drawable.drawer_findclg,
            R.drawable.drawer_areainfo,
            R.drawable.drawer_documents,
            R.drawable.profile

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //changing statusbar color
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.blueGrey));
        }

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, Login.class));
        }

        linear1 = (LinearLayout) findViewById(R.id.linear1);
        Snackbar snackbar = Snackbar.make(linear1,"Need to edit your profile?",Snackbar.LENGTH_LONG)
                .setAction("Click Here", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                        startActivity(new Intent(MainActivity.this, Profile.class));
                    }
                });
        snackbar.show();

        HomeMenuAdapter adapter=new HomeMenuAdapter(this, itemname, imgid);
        list=(ListView)findViewById(R.id.menuList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position==0){
                    finish();
                    startActivity(new Intent(MainActivity.this, AdmissionInfo.class));
                }

                if (position==1){
                    finish();
                    startActivity(new Intent(MainActivity.this, StreamSuggestor.class));

                }
                if (position==2){
                    finish();
                    startActivity(new Intent(MainActivity.this, FindACollege.class));
                }
                if (position==3){
                    finish();
                    startActivity(new Intent(MainActivity.this, WhatsNearby.class));
                }
                if (position==4){
                    finish();
                    startActivity(new Intent(MainActivity.this, DocumentChecklist.class));
                }
                if (position==5){
                    finish();
                    startActivity(new Intent(MainActivity.this, Profile.class));
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sign_out: {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(this, Login.class));
                break;
            }
        }
        return false;
    }
}
