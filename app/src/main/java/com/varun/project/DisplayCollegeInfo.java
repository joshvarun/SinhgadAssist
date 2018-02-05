package com.varun.project;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ms.square.android.expandabletextview.ExpandableTextView;


public class DisplayCollegeInfo extends AppCompatActivity {

    String item, caste;
    Intent intent;

    TextView title1;

    ImageView collegePhoto;
    TextView collegeTitle;
    TextView collegeAddress;

    TextView fee1;
    Button intake;
    TextView hostel1;
    Button placement;

    TextView book1;
    TextView book2;
    TextView book3;

    TextView acc1;
    TextView acc2;
    TextView acc3;

    TextView food1;
    TextView food2;
    TextView food3;

    TextView fun1;
    TextView fun2;
    TextView fun3;

    ImageView contact;

    FirebaseAuth firebaseAuth;

    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_college_info);

        //changing statusbar color
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.blueGrey));
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.showOverflowMenu();

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, Login.class));
        }

        firebaseUser = firebaseAuth.getCurrentUser();

        intent = getIntent();
        item = intent.getStringExtra("Selected");

        title1 = (TextView) findViewById(R.id.sample1).findViewById(R.id.title);
        ExpandableTextView expTv1 = (ExpandableTextView) findViewById(R.id.sample1).findViewById(R.id.expand_text_view);

        collegePhoto = (ImageView) findViewById(R.id.collegePhoto);
        collegeTitle = (TextView) findViewById(R.id.collegeTitle);
        collegeAddress = (TextView) findViewById(R.id.addressCollege);

        contact = (ImageView) findViewById(R.id.imageViewCall);

        fee1 = (TextView) findViewById(R.id.fee1);
        intake = (Button) findViewById(R.id.intake);
        hostel1 = (TextView) findViewById(R.id.hostel1);
        placement = (Button) findViewById(R.id.placements);

        book1 = (TextView) findViewById(R.id.book1);
        book2 = (TextView) findViewById(R.id.book2);
        book3 = (TextView) findViewById(R.id.book3);

        food1 = (TextView) findViewById(R.id.food1);
        food2 = (TextView) findViewById(R.id.food2);
        food3 = (TextView) findViewById(R.id.food3);

        acc1 = (TextView) findViewById(R.id.acc1);
        acc2 = (TextView) findViewById(R.id.acc2);
        acc3 = (TextView) findViewById(R.id.acc3);

        fun1 = (TextView) findViewById(R.id.fun1);
        fun2 = (TextView) findViewById(R.id.fun2);
        fun3 = (TextView) findViewById(R.id.fun3);


        placement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(DisplayCollegeInfo.this, DisplayPlacements.class);
                intent.putExtra("Selected", item);
                startActivity(intent);

            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DisplayCollegeInfo.this);
                // Get the layout inflater
                LayoutInflater inflater = getLayoutInflater();

                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                builder.setView(inflater.inflate(R.layout.contact_dialog, null))
                        // Add action buttons
                        .setPositiveButton("Call", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(Intent.ACTION_DIAL);
                                intent.setData(Uri.parse("tel:+912024100234"));
                                startActivity(intent);
                            }
                        })
                        .setPositiveButton("E-Mail", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(Intent.ACTION_SEND);

                                intent.setData(Uri.parse("mailto:"));
                                intent.setType("text/plain");
                                intent.putExtra(Intent.EXTRA_EMAIL, "registrar.scoe@sinhgad.edu");
                            }
                        });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });

        intake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (item.equals("RMD Sinhgad School of Engineering (RMDSSOE)")) {
                    finish();
                    Intent intent = new Intent(DisplayCollegeInfo.this, IntakeRMD.class);
                    intent.putExtra("item", item);
                    startActivity(intent);
                }


                if (item.equals("NBN Sinhgad School of Engineering (NBNSSOE)")) {
                    finish();
                    Intent intent = new Intent(DisplayCollegeInfo.this, IntakeNBN.class);
                    intent.putExtra("item", item);
                    startActivity(intent);                }

                if (item.equals("Sinhgad Institute of Technology (SIT)")) {
                    finish();
                    Intent intent = new Intent(DisplayCollegeInfo.this, IntakeSIT.class);
                    intent.putExtra("item", item);
                    startActivity(intent);
                }

                if (item.equals("Sinhgad Academy of Engineering (SAE)")) {
                    finish();
                    Intent intent = new Intent(DisplayCollegeInfo.this, IntakeSAE.class);
                    intent.putExtra("item", item);
                    startActivity(intent);
                }

                if (item.equals("Sinhgad College of Enigneering (SCOE)")) {
                    finish();
                    Intent intent = new Intent(DisplayCollegeInfo.this, IntakeSCOE.class);
                    intent.putExtra("item", item);
                    startActivity(intent);
                }

                if (item.equals("Sinhgad Institute of Technology & Science (SITS)")) {
                    finish();
                    Intent intent = new Intent(DisplayCollegeInfo.this, IntakeSITS.class);
                    intent.putExtra("item", item);
                    startActivity(intent);
                }

                if (item.equals("Smt. Kashibai Navale College of Enigneering (SKNCOE)")) {
                    finish();
                    Intent intent = new Intent(DisplayCollegeInfo.this, IntakeSKN.class);
                    intent.putExtra("item", item);
                    startActivity(intent);
                }

                if (item.equals("Smt. Kashibai Navale Sinhgad Institute of Technology & Science (SKNSITS)")) {
                    finish();
                    Intent intent = new Intent(DisplayCollegeInfo.this, IntakeSKNSITS.class);
                    intent.putExtra("item", item);
                    startActivity(intent);
                }


            }
        });


        if (item.equals("Sinhgad College of Engineering (SCOE)")) {
            collegeTitle.setText(getString(R.string.scoe));
            collegePhoto.setImageResource(R.drawable.scoe);
            title1.setText(getString(R.string.about_institute));
            collegeAddress.setText(getString(R.string.address_scoe));
            expTv1.setText(getString(R.string.about_scoe));
            getSupportActionBar().setTitle("Sinhgad College of Engineering");

            hostel1.setText(getResources().getString(R.string.hostelFee_scoe));

            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference(firebaseUser.getUid()).child("caste");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    caste = dataSnapshot.getValue().toString();
                    if (caste.equalsIgnoreCase("Open")) {
                        fee1.setText(getResources().getString(R.string.scoe_open));
                    }
                    if (caste.equalsIgnoreCase("OBC")) {
                        fee1.setText(getResources().getString(R.string.scoe_obc));
                    }
                    if (caste.equalsIgnoreCase("VJ-NT") || caste.equalsIgnoreCase("SC, ST")) {
                        fee1.setText(getResources().getString(R.string.scoe_sc_nt));
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });

            book1.setText(getString(R.string.book1_scoe));
            book2.setText(getString(R.string.book2_scoe));
            book3.setText(getString(R.string.book3_scoe));

            food1.setText(getString(R.string.food1_scoe));
            food2.setText(getString(R.string.food2_scoe));
            food3.setText(getString(R.string.food3_scoe));

            acc1.setText(getString(R.string.acc1_scoe));
            acc2.setText(getString(R.string.acc2_scoe));
            acc3.setText(getString(R.string.acc3_scoe));

            fun1.setText(getString(R.string.fun1_scoe));
            fun2.setText(getString(R.string.fun2_scoe));
            fun3.setText(getString(R.string.fun3_scoe));
        }

        if (item.equals("Sinhgad Academy of Engineering (SAE)")) {
            getSupportActionBar().setTitle(getString(R.string.sae));
            collegeTitle.setText(getString(R.string.sae));
            collegePhoto.setImageResource(R.drawable.sae);
            collegeAddress.setText(getString(R.string.address_sae));
            title1.setText(getString(R.string.about_institute));
            expTv1.setText(getString(R.string.about_sae));

            hostel1.setText(getResources().getString(R.string.sae_hostel));

            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference(firebaseUser.getUid()).child("caste");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    caste = dataSnapshot.getValue().toString();
                    if (caste.equalsIgnoreCase("Open")) {
                        fee1.setText(getResources().getString(R.string.sae_open));
                    }
                    if (caste.equalsIgnoreCase("OBC")) {
                        fee1.setText(getResources().getString(R.string.sae_obc));
                    }
                    if (caste.equalsIgnoreCase("VJ-NT")) {
                        fee1.setText(getResources().getString(R.string.sae_sc_nt));
                    }
                    if (caste.equalsIgnoreCase("SC, ST")) {
                        fee1.setText(getResources().getString(R.string.sae_sc_nt));
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });


            book1.setText(getString(R.string.book1_sae));
            book2.setText(getString(R.string.book2_sae));
            book3.setText(getString(R.string.book3_sae));

            food1.setText(getString(R.string.food1_sae));
            food2.setText(getString(R.string.food2_sae));
            food3.setText(getString(R.string.food3_sae));

            acc1.setText(getString(R.string.acc1_sae));
            acc2.setText(getString(R.string.acc2_sae));
            acc3.setText(getString(R.string.acc3_sae));

            fun1.setText(getString(R.string.fun1_sae));
            fun2.setText(getString(R.string.fun2_sae));
            fun3.setText(getString(R.string.fun3_sae));

        }

        if (item.equals("Smt. Kashibai Navale College of Enigneering (SKNCOE)")) {
            collegeTitle.setText(getString(R.string.skn));
            collegePhoto.setImageResource(R.drawable.skn_clg);
            collegeAddress.setText(getString(R.string.address_skn));
            title1.setText(getString(R.string.about_institute));
            expTv1.setText(getString(R.string.about_skn));

            hostel1.setText(getResources().getString(R.string.hostelFee_skn));

            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference(firebaseUser.getUid()).child("caste");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    caste = dataSnapshot.getValue().toString();
                    if (caste.equalsIgnoreCase("Open")) {
                        fee1.setText(getResources().getString(R.string.skn_open));
                    }
                    if (caste.equalsIgnoreCase("OBC")) {
                        fee1.setText(getResources().getString(R.string.skn_obc));
                    }
                    if (caste.equalsIgnoreCase("VJ-NT")) {
                        fee1.setText(getResources().getString(R.string.skn_nt));
                    }
                    if (caste.equalsIgnoreCase("SC, ST")) {
                        fee1.setText(getResources().getString(R.string.skn_sc));
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });


            book1.setText(getString(R.string.book1_skn));
            book2.setText(getString(R.string.book2_skn));
            book3.setText(getString(R.string.book3_skn));

            food1.setText(getString(R.string.food1_skn));
            food2.setText(getString(R.string.food2_skn));
            food3.setText(getString(R.string.food3_skn));

            acc1.setText(getString(R.string.acc1_skn));
            acc2.setText(getString(R.string.acc2_skn));
            acc3.setText(getString(R.string.acc3_skn));

            fun1.setText(getString(R.string.fun1_skn));
            fun2.setText(getString(R.string.fun2_skn));
            fun3.setText(getString(R.string.fun3_skn));

        }

        if (item.equals("NBN Sinhgad School of Engineering (NBNSSOE)")) {
            getSupportActionBar().setTitle(getString(R.string.nbn));
            collegeTitle.setText(getString(R.string.nbn));
            collegePhoto.setImageResource(R.drawable.nbn);
            collegeAddress.setText(getString(R.string.address_nbn));
            title1.setText(getString(R.string.about_institute));
            expTv1.setText(getString(R.string.about_nbn));

            hostel1.setText(getResources().getString(R.string.hostelFee_nbn));

            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference(firebaseUser.getUid()).child("caste");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    caste = dataSnapshot.getValue().toString();
                    if (caste.equalsIgnoreCase("Open")) {
                        fee1.setText(getResources().getString(R.string.nbn_open));
                    }
                    if (caste.equalsIgnoreCase("OBC")) {
                        fee1.setText(getResources().getString(R.string.nbn_obc));
                    }
                    if (caste.equalsIgnoreCase("VJ-NT")) {
                        fee1.setText(getResources().getString(R.string.nbn_nt));
                    }
                    if (caste.equalsIgnoreCase("SC, ST")) {
                        fee1.setText(getResources().getString(R.string.nbn_nt));
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });


            book1.setText(getString(R.string.book1_nbn));
            book2.setText(getString(R.string.book2_nbn));
            book3.setText(getString(R.string.book3_nbn));

            food1.setText(getString(R.string.food1_nbn));
            food2.setText(getString(R.string.food2_nbn));
            food3.setText(getString(R.string.food3_nbn));

            acc1.setText(getString(R.string.acc1_nbn));
            acc2.setText(getString(R.string.acc2_nbn));
            acc3.setText(getString(R.string.acc3_nbn));

            fun1.setText(getString(R.string.fun1_nbn));
            fun2.setText(getString(R.string.fun2_nbn));
            fun3.setText(getString(R.string.fun3_nbn));

        }

        if (item.equals("RMD Sinhgad School of Engineering (RMDSSOE)")) {
            getSupportActionBar().setTitle(getString(R.string.rmd));
            collegeTitle.setText(getString(R.string.rmd));
            collegePhoto.setImageResource(R.drawable.rmd);
            collegeAddress.setText(getString(R.string.address_rmd));

            title1.setText(getString(R.string.about_institute));
            expTv1.setText(getString(R.string.about_rmd));

            hostel1.setText(getResources().getString(R.string.hostelFee_rmd));

            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference(firebaseUser.getUid()).child("caste");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    caste = dataSnapshot.getValue().toString();
                    if (caste.equalsIgnoreCase("Open")) {
                        fee1.setText(getResources().getString(R.string.rmd_open));
                    }
                    if (caste.equalsIgnoreCase("OBC")) {
                        fee1.setText(getResources().getString(R.string.rmd_obc));
                    }
                    if (caste.equalsIgnoreCase("VJ-NT")) {
                        fee1.setText(getResources().getString(R.string.rmd_sc_nt));
                    }
                    if (caste.equalsIgnoreCase("SC, ST")) {
                        fee1.setText(getResources().getString(R.string.rmd_sc_nt));
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });

            book1.setText(getString(R.string.book1_rmd));
            book2.setText(getString(R.string.book2_rmd));
            book3.setText(getString(R.string.book3_rmd));

            food1.setText(getString(R.string.food1_rmd));
            food2.setText(getString(R.string.food2_rmd));
            food3.setText(getString(R.string.food3_rmd));

            acc1.setText(getString(R.string.acc1_rmd));
            acc2.setText(getString(R.string.acc2_rmd));
            acc3.setText(getString(R.string.acc3_rmd));

            fun1.setText(getString(R.string.fun1_rmd));
            fun2.setText(getString(R.string.fun2_rmd));
            fun3.setText(getString(R.string.fun3_rmd));
        }

        if (item.equals("Sinhgad Institute of Technology (SIT)")) {
            getSupportActionBar().setTitle(getString(R.string.sit));
            collegeTitle.setText(getString(R.string.sit));
            collegePhoto.setImageResource(R.drawable.sitlona);
            collegeAddress.setText(getString(R.string.address_sit));
            title1.setText(getString(R.string.about_institute));
            expTv1.setText(getString(R.string.about_sit));

            hostel1.setText(getResources().getString(R.string.sit_hostel));

            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference(firebaseUser.getUid()).child("caste");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    caste = dataSnapshot.getValue().toString();
                    if (caste.equalsIgnoreCase("Open")) {
                        fee1.setText(getResources().getString(R.string.sit_open));
                    }
                    if (caste.equalsIgnoreCase("OBC")) {
                        fee1.setText(getResources().getString(R.string.sit_obc));
                    }
                    if (caste.equalsIgnoreCase("VJ-NT")) {
                        fee1.setText(getResources().getString(R.string.sit_sc_nt));
                    }
                    if (caste.equalsIgnoreCase("SC, ST")) {
                        fee1.setText(getResources().getString(R.string.sit_sc_nt));
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });


            book1.setText(getString(R.string.book1_sit));
            book2.setText(getString(R.string.book2_sit));
            book3.setText(getString(R.string.book3_sit));

            food1.setText(getString(R.string.food1_sit));
            food2.setText(getString(R.string.food2_sit));
            food3.setText(getString(R.string.food3_sit));

            acc1.setText(getString(R.string.acc1_sit));
            acc2.setText(getString(R.string.acc2_sit));
            acc3.setText(getString(R.string.acc3_sit));

            fun1.setText(getString(R.string.fun1_sit));
            fun2.setText(getString(R.string.fun2_sit));
            fun3.setText(getString(R.string.fun3_sit));

        }

        if (item.equals("Sinhgad Institute of Technology & Science (SITS)")) {
            getSupportActionBar().setTitle(getString(R.string.sits));
            collegeTitle.setText(getString(R.string.sits));
            collegePhoto.setImageResource(R.drawable.sits_clg);
            collegeAddress.setText(getString(R.string.address_sits));
            title1.setText(getString(R.string.about_institute));
            expTv1.setText(getString(R.string.about_sits));

            hostel1.setText(getResources().getString(R.string.hostelFee_sits));

            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference(firebaseUser.getUid()).child("caste");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    caste = dataSnapshot.getValue().toString();
                    if (caste.equalsIgnoreCase("Open")) {
                        fee1.setText(getResources().getString(R.string.sits_open));
                    }
                    if (caste.equalsIgnoreCase("OBC")) {
                        fee1.setText(getResources().getString(R.string.sits_obc));
                    }
                    if (caste.equalsIgnoreCase("VJ-NT")) {
                        fee1.setText(getResources().getString(R.string.sits_sc_nt));
                    }
                    if (caste.equalsIgnoreCase("SC, ST")) {
                        fee1.setText(getResources().getString(R.string.sits_sc_nt));
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });

            book1.setText(getString(R.string.book1_sits));
            book2.setText(getString(R.string.book2_sits));
            book3.setText(getString(R.string.book3_sits));

            food1.setText(getString(R.string.food1_sits));
            food2.setText(getString(R.string.food2_sits));
            food3.setText(getString(R.string.food3_sits));

            acc1.setText(getString(R.string.acc1_sits));
            acc2.setText(getString(R.string.acc2_sits));
            acc3.setText(getString(R.string.acc3_sits));

            fun1.setText(getString(R.string.fun1_sits));
            fun2.setText(getString(R.string.fun2_sits));
            fun3.setText(getString(R.string.fun3_sits));

        }

        if (item.equals("Smt. Kashibai Navale Sinhgad Institute of Technology & Science (SKNSITS)")) {
            collegeTitle.setText(getString(R.string.sknsits));
            collegePhoto.setImageResource(R.drawable.sinhgadlonavala);
            collegeAddress.setText(getString(R.string.address_sknsits));
            title1.setText(getString(R.string.about_institute));
            expTv1.setText(getString(R.string.about_sknsits));

            hostel1.setText(getResources().getString(R.string.hostelFee_sknsits));

            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference(firebaseUser.getUid()).child("caste");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    caste = dataSnapshot.getValue().toString();
                    if(caste.equalsIgnoreCase("Open")){
                        fee1.setText(getResources().getString(R.string.sknsits_open));
                    }
                    if(caste.equalsIgnoreCase("OBC")){
                        fee1.setText(getResources().getString(R.string.sknsits_obc));
                    }
                    if(caste.equalsIgnoreCase("VJ-NT")){
                        fee1.setText(getResources().getString(R.string.sknsits_sc_nt));
                    }
                    if(caste.equalsIgnoreCase("SC, ST")){
                        fee1.setText(getResources().getString(R.string.sknsits_sc_nt));
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });

            book1.setText(getString(R.string.book1_sknsits));
            book2.setText(getString(R.string.book2_sknsits));
            book3.setText(getString(R.string.book3_sknsits));

            food1.setText(getString(R.string.food1_sknsits));
            food2.setText(getString(R.string.food2_sknsits));
            food3.setText(getString(R.string.food3_sknsits));

            acc1.setText(getString(R.string.acc1_sknsits));
            acc2.setText(getString(R.string.acc2_sknsits));
            acc3.setText(getString(R.string.acc3_sknsits));

            fun1.setText(getString(R.string.fun1_sknsits));
            fun2.setText(getString(R.string.fun2_sknsits));
            fun3.setText(getString(R.string.fun3_sknsits));
        }
    }

    public void openMapsBooks(View view) {
        intent = getIntent();
        item = intent.getStringExtra("Selected");
        Intent intent1;
        int id = view.getId();
        String map = "http://maps.google.co.in/maps?q=";
        String uri;

        if (item.equals("RMD Sinhgad School of Engineering (RMDSSOE)")) {
            if (id == R.id.book1 || id == R.id.book1_maps) {
                uri = map + getString(R.string.book1_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.book2 || id == R.id.book2_maps) {
                uri = map + getString(R.string.book2_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.book3 || id == R.id.book3_maps) {
                uri = map + getString(R.string.book3_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("Sinhgad College of Enigneering (SCOE)")) {
            if (id == R.id.book1 || id == R.id.book1_maps) {
                uri = map + getString(R.string.book1_scoe);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.book2 || id == R.id.book2_maps) {
                uri = map + getString(R.string.book2_scoe);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.book3 || id == R.id.book3_maps) {
                uri = map + getString(R.string.book3_scoe);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("Sinhgad Academy of Engineering (SAE)")) {
            if (id == R.id.book1 || id == R.id.book1_maps) {
                uri = map + getString(R.string.book1_sae);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.book2 || id == R.id.book2_maps) {
                uri = map + getString(R.string.book2_sae);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.book3 || id == R.id.book3_maps) {
                uri = map + getString(R.string.book3_sae);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("Smt. Kashibai Navale College of Enigneering (SKNCOE)")) {
            if (id == R.id.book1 || id == R.id.book1_maps) {
                uri = map + getString(R.string.book1_skn);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.book2 || id == R.id.book2_maps) {
                uri = map + getString(R.string.book2_skn);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.book3 || id == R.id.book3_maps) {
                uri = map + getString(R.string.book3_skn);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("NBN Sinhgad School of Engineering (NBNSSOE)")) {
            if (id == R.id.book1 || id == R.id.book1_maps) {
                uri = map + getString(R.string.book1_nbn);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.book2 || id == R.id.book2_maps) {
                uri = map + getString(R.string.book2_nbn);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.book3 || id == R.id.book3_maps) {
                uri = map + getString(R.string.book3_nbn);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("Smt. Kashibai Navale Sinhgad Institute of Technology & Science (SKNSITS)")) {
            if (id == R.id.book1 || id == R.id.book1_maps) {
                uri = map + getString(R.string.book1_sknsits);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.book2 || id == R.id.book2_maps) {
                uri = map + getString(R.string.book2_sknsits);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.book3 || id == R.id.book3_maps) {
                uri = map + getString(R.string.book3_sknsits);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("Sinhgad Institute of Technology & Science (SITS)")) {
            if (id == R.id.book1 || id == R.id.book1_maps) {
                uri = map + getString(R.string.book1_sits);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.book2 || id == R.id.book2_maps) {
                uri = map + getString(R.string.book2_sits);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.book3 || id == R.id.book3_maps) {
                uri = map + getString(R.string.book3_sits);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }
    }

    public void openMapsFood(View view) {
        intent = getIntent();
        item = intent.getStringExtra("Selected");
        Intent intent1;
        int id = view.getId();
        String map = "http://maps.google.co.in/maps?q=";
        String uri;

        if (item.equals("RMD Sinhgad School of Engineering (RMDSSOE)")) {
            if (id == R.id.food1 || id == R.id.food1_maps) {
                uri = map + getString(R.string.food1_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.food2 || id == R.id.food2_maps) {
                uri = map + getString(R.string.food2_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.food3 || id == R.id.food3_maps) {
                uri = map + getString(R.string.food3_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("Sinhgad College of Enigneering (SCOE)")) {
            if (id == R.id.food1 || id == R.id.food1_maps) {
                uri = map + getString(R.string.food1_scoe);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.food2 || id == R.id.food2_maps) {
                uri = map + getString(R.string.food2_scoe);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.food3 || id == R.id.food3_maps) {
                uri = map + getString(R.string.food3_scoe);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("Sinhgad Academy of Engineering (SAE)")) {
            if (id == R.id.food1 || id == R.id.food1_maps) {
                uri = map + getString(R.string.food1_sae);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.food2 || id == R.id.food2_maps) {
                uri = map + getString(R.string.food2_sae);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.food3 || id == R.id.food3_maps) {
                uri = map + getString(R.string.food3_sae);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("Smt. Kashibai Navale College of Enigneering (SKNCOE)")) {
            if (id == R.id.food1 || id == R.id.food1_maps) {
                uri = map + getString(R.string.food1_skn);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.food2 || id == R.id.food2_maps) {
                uri = map + getString(R.string.food2_skn);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.food3 || id == R.id.food3_maps) {
                uri = map + getString(R.string.food3_skn);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("NBN Sinhgad School of Engineering (NBNSSOE)")) {
            if (id == R.id.food1 || id == R.id.food1_maps) {
                uri = map + getString(R.string.food1_nbn);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.food2 || id == R.id.food2_maps) {
                uri = map + getString(R.string.food2_nbn);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.food3 || id == R.id.food3_maps) {
                uri = map + getString(R.string.food3_nbn);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("Smt. Kashibai Navale Sinhgad Institute of Technology & Science (SKNSITS)")) {
            if (id == R.id.food1 || id == R.id.food1_maps) {
                uri = map + getString(R.string.food1_sknsits);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.food2 || id == R.id.food2_maps) {
                uri = map + getString(R.string.food2_sknsits);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.food3 || id == R.id.food3_maps) {
                uri = map + getString(R.string.food3_sknsits);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("Sinhgad Institute of Technology & Science (SITS)")) {
            if (id == R.id.food1 || id == R.id.food1_maps) {
                uri = map + getString(R.string.food1_sits);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.food2 || id == R.id.food2_maps) {
                uri = map + getString(R.string.food2_sits);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.food3 || id == R.id.food3_maps) {
                uri = map + getString(R.string.food3_sits);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

    }

    public void openMapsAcc(View view) {
        intent = getIntent();
        item = intent.getStringExtra("Selected");
        Intent intent1;
        int id = view.getId();
        String map = "http://maps.google.co.in/maps?q=";
        String uri;

        if (item.equals("RMD Sinhgad School of Engineering (RMDSSOE)")) {
            if (id == R.id.acc1 || id == R.id.acc1_maps) {
                uri = map + getString(R.string.acc1_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.acc2 || id == R.id.acc2_maps) {
                uri = map + getString(R.string.acc2_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.acc3 || id == R.id.acc3_maps) {
                uri = map + getString(R.string.acc3_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("Sinhgad College of Enigneering (SCOE)")) {
            if (id == R.id.acc1 || id == R.id.acc1_maps) {
                uri = map + getString(R.string.acc1_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.acc2 || id == R.id.acc2_maps) {
                uri = map + getString(R.string.acc2_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.acc3 || id == R.id.acc3_maps) {
                uri = map + getString(R.string.acc3_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("Sinhgad Academy of Engineering (SAE)")) {
            if (id == R.id.acc1 || id == R.id.acc1_maps) {
                uri = map + getString(R.string.acc1_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.book2 || id == R.id.acc2_maps) {
                uri = map + getString(R.string.acc2_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.acc3 || id == R.id.acc3_maps) {
                uri = map + getString(R.string.acc3_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("Smt. Kashibai Navale College of Enigneering (SKNCOE)")) {
            if (id == R.id.acc1 || id == R.id.acc1_maps) {
                uri = map + getString(R.string.acc1_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.acc2 || id == R.id.acc2_maps) {
                uri = map + getString(R.string.acc2_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.acc3 || id == R.id.acc3_maps) {
                uri = map + getString(R.string.acc3_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("NBN Sinhgad School of Engineering (NBNSSOE)")) {
            if (id == R.id.acc1 || id == R.id.acc1_maps) {
                uri = map + getString(R.string.acc1_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.acc2 || id == R.id.acc2_maps) {
                uri = map + getString(R.string.acc2_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.acc3 || id == R.id.acc3_maps) {
                uri = map + getString(R.string.acc3_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("Smt. Kashibai Navale Sinhgad Institute of Technology & Science (SKNSITS)")) {
            if (id == R.id.acc1 || id == R.id.acc1_maps) {
                uri = map + getString(R.string.acc1_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.acc2 || id == R.id.acc2_maps) {
                uri = map + getString(R.string.acc2_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.acc3 || id == R.id.acc3_maps) {
                uri = map + getString(R.string.acc3_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("Sinhgad Institute of Technology & Science (SITS)")) {
            if (id == R.id.acc1 || id == R.id.acc1_maps) {
                uri = map + getString(R.string.acc1_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.acc2 || id == R.id.acc2_maps) {
                uri = map + getString(R.string.acc2_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.acc3 || id == R.id.acc3_maps) {
                uri = map + getString(R.string.acc3_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

    }

    public void openMapsFun(View view) {
        intent = getIntent();
        item = intent.getStringExtra("Selected");
        Intent intent1;
        int id = view.getId();
        String map = "http://maps.google.co.in/maps?q=";
        String uri;

        if (item.equals("RMD Sinhgad School of Engineering (RMDSSOE)")) {
            if (id == R.id.fun1 || id == R.id.fun1_maps) {
                uri = map + getString(R.string.fun1_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.fun2 || id == R.id.fun2_maps) {
                uri = map + getString(R.string.fun2_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.fun3 || id == R.id.fun3_maps) {
                uri = map + getString(R.string.book3_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("Sinhgad College of Enigneering (SCOE)")) {
            if (id == R.id.fun1 || id == R.id.fun1_maps) {
                uri = map + getString(R.string.fun1_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.fun2 || id == R.id.fun2_maps) {
                uri = map + getString(R.string.fun2_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.fun3 || id == R.id.fun3_maps) {
                uri = map + getString(R.string.fun3_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("Sinhgad Academy of Engineering (SAE)")) {
            if (id == R.id.fun1 || id == R.id.fun1_maps) {
                uri = map + getString(R.string.fun1_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.fun2 || id == R.id.fun2_maps) {
                uri = map + getString(R.string.fun2_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.fun3 || id == R.id.fun3_maps) {
                uri = map + getString(R.string.fun3_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("Smt. Kashibai Navale College of Enigneering (SKNCOE)")) {
            if (id == R.id.fun1 || id == R.id.fun1_maps) {
                uri = map + getString(R.string.fun1_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.fun2 || id == R.id.fun2_maps) {
                uri = map + getString(R.string.fun2_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.fun3 || id == R.id.fun3_maps) {
                uri = map + getString(R.string.fun3_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("NBN Sinhgad School of Engineering (NBNSSOE)")) {
            if (id == R.id.fun1 || id == R.id.fun1_maps) {
                uri = map + getString(R.string.fun1_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.fun2 || id == R.id.fun2_maps) {
                uri = map + getString(R.string.fun2_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.fun3 || id == R.id.fun3_maps) {
                uri = map + getString(R.string.fun3_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("Smt. Kashibai Navale Sinhgad Institute of Technology & Science (SKNSITS)")) {
            if (id == R.id.fun1 || id == R.id.fun1_maps) {
                uri = map + getString(R.string.fun1_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.fun2 || id == R.id.fun2_maps) {
                uri = map + getString(R.string.fun2_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.fun3 || id == R.id.fun3_maps) {
                uri = map + getString(R.string.fun3_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

        if (item.equals("Sinhgad Institute of Technology & Science (SITS)")) {
            if (id == R.id.fun1 || id == R.id.fun1_maps) {
                uri = map + getString(R.string.fun1_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.fun2 || id == R.id.fun2_maps) {
                uri = map + getString(R.string.fun2_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }

            if (id == R.id.fun3 || id == R.id.fun3_maps) {
                uri = map + getString(R.string.fun3_rmd);
                intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent1);
            }
        }

    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(this, WhatsNearby.class));
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

