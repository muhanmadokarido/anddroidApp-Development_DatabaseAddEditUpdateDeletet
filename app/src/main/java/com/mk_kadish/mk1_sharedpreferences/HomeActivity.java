package com.mk_kadish.mk1_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    private sharedPreferenceConfig preferenceConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        preferenceConfig=new sharedPreferenceConfig(getApplicationContext());
    }

    public void logOut(View view)
    {
        preferenceConfig.writeLoginStatus(false);
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
