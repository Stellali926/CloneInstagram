package com.example.yuxuanli.cloneinsta.Profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.yuxuanli.cloneinsta.R;


import com.example.yuxuanli.cloneinsta.R;
import com.example.yuxuanli.cloneinsta.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by yuxuanli on 4/3/18.
 */

public class EditProfileFragment extends Fragment {

    private static final String TAG = "EditProfileFragment";

    private ImageView mProfilePhoto;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editprofile, container,false);
        mProfilePhoto = (ImageView)view.findViewById(R.id.profile_photo);

        setProfileImage();

        //back arrow for navigating back to "ProfileActivity"
        ImageView backArrow = (ImageView) view.findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating to ProfileActivity");
                getActivity().finish();
            }
        });

        return view;
    }


    private void setProfileImage(){
        Log.d(TAG, "setProfileImage: setting profile image.");
        String imgURL = "theappentrepreneur.com/wp-content/uploads/2017/08/Android-Oreo.jpg";
        UniversalImageLoader.setImage(imgURL, mProfilePhoto, null, "http://");
    }
}
