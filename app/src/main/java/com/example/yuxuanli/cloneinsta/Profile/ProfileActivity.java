package com.example.yuxuanli.cloneinsta.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.yuxuanli.cloneinsta.R;
import com.example.yuxuanli.cloneinsta.Utils.BottomNavigationViewHelper;
import com.example.yuxuanli.cloneinsta.Utils.GridImageAdapter;
import com.example.yuxuanli.cloneinsta.Utils.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

/**
 * Created by yuxuanli on 1/8/18.
 */

public class ProfileActivity extends AppCompatActivity{

    private static final String TAG = "ProfileActivity";
    private static final int ACTIVITY_NUM = 4;
    private static final int NUM_GRID_COLUMNS = 3;

    private Context mContext = ProfileActivity.this;

    private ProgressBar mProgressBar;
    private ImageView profilePhoto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: started");

        setupBottomNavigationView();
        setupToolbar();
        setupActivityWidgets();
        setProfileImage();

        tempGridSetup();
    }

    private void tempGridSetup(){
        ArrayList<String> imgURLs = new ArrayList<>();
        imgURLs.add("http://www.rideresponsibly.org/wp-content/uploads/2015/12/Alaska.jpg");
        imgURLs.add("http://media.nj.com/skiing/photo/welcome-alaskajpg-77664ea9021b75a5_large.jpg");
        imgURLs.add("https://i.pinimg.com/originals/88/ba/af/88baafb60ed85f97e83a7125b2b18321.jpg");
        imgURLs.add("https://upload.wikimedia.org/wikipedia/commons/3/3f/Downtown_street_in_Fairbanks_1955_Meyer.jpg");
        imgURLs.add("https://i.pinimg.com/originals/86/92/43/8692430b5a6ad416de0e646eddb4c542.jpg");
        imgURLs.add("https://www.rd.com/wp-content/uploads/2016/10/insta-worthy-selfie-1024x683.jpg");
        imgURLs.add("https://www.photobook.com.my/media/catalog/product/cache/1/thumbnail/9df78eab33525d08d6e5fb8d27136e95/4/_/4_3_1.jpg");
        imgURLs.add("https://i.pinimg.com/736x/4d/fd/b4/4dfdb4413bf53d387f467b6bbf08b914--pic-ideas-instagram-insta-photo-ideas.jpg");
        imgURLs.add("http://www.prettyforum.com/wp-content/uploads/2015/08/Tushie-up-pose-Tips-for-Newborn-Posing-by-Avnida-Photography-NJ-Newborn-Photographer.jpg");
        imgURLs.add("https://i.pinimg.com/originals/8e/19/a8/8e19a8fc524a8a3b5cc3c4105b2b1f2e.jpg");

        setupImageGrid(imgURLs);
    }

    private void setupImageGrid(ArrayList<String> imgURLs) {
        GridView gridView = (GridView) findViewById(R.id.gridView);

        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int imageWidth = gridWidth/NUM_GRID_COLUMNS;
        gridView.setColumnWidth(imageWidth);

        GridImageAdapter adapter = new GridImageAdapter(mContext, R.layout.layout_grid_imageview, "", imgURLs);
        gridView.setAdapter(adapter);
    }

    private void setProfileImage(){
        Log.d(TAG, "setPtofileImage: setting profile photo.");
        String imgURL = "theappentrepreneur.com/wp-content/uploads/2017/08/Android-Oreo.jpg";
        UniversalImageLoader.setImage(imgURL, profilePhoto, mProgressBar, "http://");
    }

    private void setupActivityWidgets(){
        mProgressBar = (ProgressBar) findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);
        profilePhoto = (ImageView) findViewById(R.id.profile_photo);
    }
    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);

        ImageView profileMenu = (ImageView) findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating to account settings.");
                Intent intent = new Intent(mContext, AccountSettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * BottomNavigationView setup
     */
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);//The type here is to declare the widget
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx); // use another class, because later we will use it over and over again
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

}
