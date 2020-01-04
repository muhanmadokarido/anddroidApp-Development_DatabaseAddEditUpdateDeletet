package com.mk_kadish.mk1_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private sharedPreferenceConfig preferenceConfig;
    EditText UserName, UserPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferenceConfig= new sharedPreferenceConfig(getApplicationContext());
        UserName=findViewById(R.id.user_name);
        UserPassword=findViewById(R.id.user_password);

        if(preferenceConfig.readLoginStatus())
        {
            startActivity(new Intent(this,HomeActivity.class));
            finish();
        }
    }

    public void loginUser(View view)
    {
        String name=UserName.getText().toString();
        String password=UserPassword.getText().toString();

        if(name.equals(getResources().getString(R.string.user_name)) && password.equals(getResources().getString(R.string.user_password)))
        {
          startActivity(new Intent(this,HomeActivity.class));
          preferenceConfig.writeLoginStatus(true);
          finish();
        }
        else
        {
            Toast.makeText(this,"Error Credentials....Try again",Toast.LENGTH_SHORT).show();
            UserName.setText("");
            UserPassword.setText("");
        }
    }
}
