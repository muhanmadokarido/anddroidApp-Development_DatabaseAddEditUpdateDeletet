package com.mk_kadish.mk1_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class userManagementActivity extends AppCompatActivity implements HomeFragment.onDbOpListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_management);

        if(findViewById(R.id.fragment_container)!=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }
            HomeFragment homeFragment=new HomeFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,homeFragment).commit();
        }
    }

    @Override
    public void dBopPerformed(int methode) {

        switch (methode)
        {
            case 0:
                AddSchoolFragment addSchoolFragment=new AddSchoolFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,addSchoolFragment).addToBackStack(null).commit();
            break;
            case 1:
                ReadSchoolsFragment readSchoolsFragment=new ReadSchoolsFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,readSchoolsFragment).addToBackStack(null).commit();
                break;
        case 2:
        UpdateSchoolFragment updateSchoolFragment =new UpdateSchoolFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,updateSchoolFragment).addToBackStack(null).commit();
        break;

        case 3:
        DeleteSchoolFragment deleteSchoolFragment=new DeleteSchoolFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,deleteSchoolFragment).addToBackStack(null).commit();
        break;
    }
    }
        }

