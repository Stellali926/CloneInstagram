package com.example.yuxuanli.cloneinsta.Login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.yuxuanli.cloneinsta.R;

/**
 * Created by yuxuanli on 4/6/18.
 */

public class RegisterActivity extends AppCompatActivity{
    private static final String TAG = "RegisterActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Log.d(TAG, "onCreate: started");
    }
}
