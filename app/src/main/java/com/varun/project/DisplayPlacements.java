package com.varun.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class DisplayPlacements extends AppCompatActivity {

    String item;

    FirebaseAuth firebaseAuth;

    private final String placement_company_names[] = {
            "Accenture", "ACI Payment Systems", "Aker Solutions", "Alfa Laval", "Alkyl Amines Chemical Limited", "Ambuja Cement",
            "Ansys Fluent", "Atlas Copco", "AtoS", "Barclays", "Bosch", "Burckhardt Compression", "Capgemini", "Carborundum", "Cognizant",
            "Cummins", "Cybage", "Daimler Crysler", "Deepak Nitrate", "Emerson", "eQ Technologic", "EQ Technologies", "Essar",
            "GKN Sinter Metals", "Greaves", "Grindwell Norton Ltd.", "Honeywell", "HSBC", "Hyundai", "Hexaware Technologies",
            "iGATE", "iNautix", "IndiaBulls", "Infosys", "John Deere", "JSW Group", "Kirloskar", "KPIT Cummins", "L&T Infotech",
            "Larsen & Turbro", "Mahindra Satyam", "Mahindra", "Mahindra Rise", "Mercedes Benz", "MICO", "Microsoft", "MindTree",
            "Mphasis", "nVidia", "Oracle", "Persistent", "PRAJ", "S1 Corporation", "Shapoorji Pallonji & Co. Ltd.", "Simplex",
            "Synechron", "TATA Motors", "TATA Technologies", "TATA Consultancy Services", "Tech Mahindra", "Thermax", "ThoughtWorks",
            "TOYO India", "TVS", "Zensar Technologies", "3dPLM Software"};
    private final String[] imageURLArray = new String[]{
            "http://logok.org/wp-content/uploads/2014/03/Accenture-red-arrow-logo.png",//Accenture
            "http://res.cloudinary.com/crunchbase-production/image/upload/v1397191993/d70c19098c7668c0afbe849c747bb35a.jpg",//ACI
            "http://i442.photobucket.com/albums/qq146/emberland_2008/AkerSolutionslogo.jpg", //Aker Solutions
            "http://www.alfalaval.com/ui/css/img/logo-alfalaval.png",//Alfa Laval
            "http://investmentguruindia.com/admin/newsimage//2013-14/7e665009-3Alkyl_Amines_Chemicals_Ltd.jpg",//Alkyl
            "http://iitsol.com/wp-content/uploads/2016/06/ambuja.png",//Ambuja
            "http://www.fea-optimization.com/pics/ANSYS_logo_02.png",//AnsysFluent
            "http://logonoid.com/images/atlas-copco-logo.png",//AtlasCopco
            //AtoS
            "http://media.licdn.com/mpr/mpr/shrink_200_200/AAEAAQAAAAAAAASMAAAAJDlkOGYwOWYzLWQ4OTUtNGFlMC1iMWRlLTc0MTViNjhhNDk3OQ.png",
            "http://www.ymcaeastsurrey.org.uk/wp-content/uploads/Barclays-Logo1.png",//Barclays
            "http://lofrev.net/wp-content/photos/2014/09/Bosch-logo-3D.jpg", //Bosch
            "https://upload.wikimedia.org/wikipedia/de/thumb/f/f9/Logo_Burckhardt.svg/400px-Logo_Burckhardt.svg.png",//Burckhardt Compression
            "http://ittalentcollege.com/wp-content/uploads/2016/02/partner-capgemini.jpg",//Capgemini
            "http://colorsedge.com/wp-content/uploads/2014/01/Carbo-logo.png",//Carborundum
            "http://tnp.pec.edu/placements/cl/10.png",// Cognizant
            "http://www.cummins.com/sites/default/files/cummins%20logo-large%20-black.png",//Cummins
            "http://2.bp.blogspot.com/-i0VBFJmepTc/VYUbPnyUDYI/AAAAAAAAAu0/f6NwS5R_eQw/s1600/Cybage-Logo-hi-res.jpg",//Cybage
            "http://www.stealingshare.com/wp-content/uploads/2014/07/daimlerchrysler-corporation-logo.jpg",//Daimler
            "http://bsmedia.business-standard.com/_media/bs/img/article/2014-06/26/full/1403780893-6313.jpg",//Deepak Nitrate
            "http://www.logodesignblog.net/logos/emerson-logo.jpg",//Emerson
            "http://i.ytimg.com/vi/0S2WVfdH3BQ/maxresdefault.jpg",//eQ
            "http://pbs.twimg.com/profile_images/643502714287206404/qF2WCd6w.png",//EQ
            "https://xinix.net/images/clients/essar.png",//Essar
            "http://jnswire.s3.amazonaws.com/jns-media/8a/f7/120489/gkn-logo.jpg",//GKN Sinter Metals
            //Greaves
            "http://media.licdn.com/mpr/mpr/shrink_200_200/AAEAAQAAAAAAAAj9AAAAJDc2OTU5NzlhLTFjMTUtNDM2YS04Y2E1LTY3MzQzYTAyZGU5Zg.png",
            "http://img.moneycontrol.co.in/news_image_files/2012/g/grindwell_norton_190.jpg",//Grindwell Norton
            "http://www.hometechintegration.com/wp-content/uploads/2013/05/honeywell-logo.png",//Honeywell
            "http://logodatabases.com/wp-content/uploads/2012/02/hsbc-premier-logo.jpg",//HSBC
            "http://www.car-brand-names.com/wp-content/uploads/2016/01/Hyundai-symbol-6.png",//Hyundai
            "http://topnews.in/files/Hexaware.jpg",//Hexaware
            "http://3.bp.blogspot.com/-Yd5cVuB-HJo/TWusraZkCVI/AAAAAAAAmSo/uvoDP1xr2nk/s1600/iGate_Logo.jpg",//IGATE
            "http://images.all-free-download.com/images/graphiclarge/inautix_technologies_66344.jpg",//iNautix
            "http://img01.ibnlive.in/ibnlive/uploads/875x584/jpg/2016/07/indiabulls.jpg",//IndiaBulls
            "http://thehindustanpost.com/wp-content/uploads/2015/01/infosys-logo-baseline-PNG.png",//Infosys
            "http://www.deere.com/en_US/media/corporate_images/citizenship/john_deere_inspire/green_yellow_vert_logo.jpg",//JohnDeere
            "https://upload.wikimedia.org/wikipedia/en/thumb/3/3c/JSW_Group_logo.svg/400px-JSW_Group_logo.svg.png",//JSW Group
            "http://www.siliconindia.com/news/newsimages/special/9Qb2Y3SU.jpeg",//Kirloskar
            "http://imtnagpur.ac.in/images/Company%20Logo/KPIT%20Cummins.jpg",//KPIT Cummins
            "http://4.bp.blogspot.com/-RYphuuLNgg8/VTcsYhRYy9I/AAAAAAAAA5U/7lFoYL6FpXE/s1600/lnt-logo-clr.png",//L&T Infotech
            "http://www.ltshf.com/media/28889/lt_logo.jpg",//Larsen & Turbro
            "http://image3.mouthshut.com/images/imagesp/925664546s.jpg",//Mahindra Satyam
            "http://www.carlogos.org/logo/Mahindra-logo-2560x1440.png",//Mahindra
            "http://www.carlogos.org/logo/Mahindra-Rise-logo-2560x1440.png",//Mahindra Rise
            "http://www.car-brand-names.com/wp-content/uploads/2015/05/Mercedes-Benz-logo-2.jpg",//Mercedes Benz
            "http://www.ashvinindustries.com/images/mico_logo.jpg",//MICO
            "http://diylogodesigns.com/blog/wp-content/uploads/2016/04/Microsoft-Logo-PNG.png",//Microsoft
            //Mindtree
            "http://media-assets-02.thedrum.com/cache/images/thedrum-prod/public-drum_basic_article-96581-main_images-New-Mindtree-logo_0--default--1280.jpg",
            "http://www.enable-india.org/new/images/employers/companylogos/mphasis-an-hp-company%20logo.png",//Mphasis
            "http://logos-download.com/wp-content/uploads/2016/10/Nvidia_logo.png",//nVidia
            "https://swisdev.oracle.com/_files/OracleLogo.png",//Oracle
            "http://info.shine.com/media/images/821/2821/Persistent-logo-660x350_medium.jpg",//Persistent
            "http://www.topnews.in/files/praj_logo_jpg.jpg",//PRAJ
            "http://media.licdn.com/mpr/mpr/shrink_200_100/p/1/000/04b/353/2a11f99.png",//S1
            "http://www.coalpost.in/wp-content/uploads/2015/08/spcoalpost.jpg",//Shapoorji Pallonji
            "http://www.ifssgroup.com/wp-content/uploads/2016/01/simplex_logo.png",//Simplex
            "https://static1.squarespace.com/static/55110550e4b0dd8c456d6cf4/551181b0e4b03838f989d814/56d6daeef699bbc00b72958d/1456921443102/Synechron+Logo_White+Background.jpg",//Synechron
            "http://www.carblogindia.com/wp-content/uploads/2015/01/Tata-Motors-Logo-Wallpaper.jpg",//Tata Motors
            "http://1.bp.blogspot.com/-JTZ7vOOAkLg/T88b0Rk61oI/AAAAAAAAA60/aPxv1IqbfSc/s320/tata.png",//TATA Technologies
            "http://www.acsfoundation.com.au/images/Tata%20and%20TCS%20Marks%20-%20Stacked%20with%20Tagline%20RGB.jpg",//TCS
            "https://4.bp.blogspot.com/-VRd8sD2j6-k/V4OSpgOrhwI/AAAAAAAAA5Q/u7ERmHlDsD4YUTlBgxGmaPShIrsH4nhFQCLcB/s1600/techmahindra_logo.png",//Tech Mahindra
            "http://www.airaindia.com/wp-content/gallery/clients/Thermax_logo.jpg",//Thermax
            "http://www.devnetwork.com/wp-content/uploads/2016/03/ThoughtWorks-logo-transpare.png",//ThoughtWorks
            "http://aesinspections.com/wp-content/gallery/clients/58.jpg",//Toyo India
            "http://www.logosurfer.com/sites/default/files/tvs-logo_0.png",//TVS
            "http://focustech.in/wp-content/uploads/2016/03/ZENSAR-TECHNOLOGY-.jpg",//Zensar
            "http://media.glassdoor.com/l/bf/7a/7f/f9/3dplm-software-solutions.jpg"//3dPLM
    };
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_placements);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, Login.class));
        }

        //changing statusbar color
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.blueGrey));
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        item = intent.getStringExtra("Selected");

        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Company> companyNames = prepareData();
        DataAdapter adapter = new DataAdapter(getApplicationContext(), companyNames);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<Company> prepareData() {

        ArrayList<Company> company_names = new ArrayList<>();
        for (int i = 0; i < placement_company_names.length; i++) {
            Company company = new Company();
            company.setCompany_name(placement_company_names[i]);
            company.setCompany_logo_url(imageURLArray[i]);
            company_names.add(company);
        }
        return company_names;
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(this, DisplayCollegeInfo.class);
        intent.putExtra("Selected", item);
        startActivity(intent);
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
