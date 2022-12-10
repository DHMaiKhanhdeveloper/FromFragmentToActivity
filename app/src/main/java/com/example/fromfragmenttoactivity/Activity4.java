package com.example.fromfragmenttoactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity4 extends AppCompatActivity implements ISendFromFragmentToAcivity {

    private EditText edtEmail, edtPassword;
    private Button btnActivityP4;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        init();
    }

    private void init(){
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        btnActivityP4 = findViewById(R.id.btn_send_activityP4);
        btnActivityP4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendFragment();
            }
        });
    }
    private void SendFragment() {
//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        String strEmail = edtEmail.getText().toString().trim();
        String strPassword = edtPassword.getText().toString().trim();
        user = new User( strEmail, strPassword);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();


        fragmentTransaction.add(R.id.frameLayout, Fragment4.getInstance1(user,this));
        fragmentTransaction.commit();

//        mStrEmail = strEmail;
//
    }

    @Override
    public void SendData(User user) {
        edtEmail.setText(user.getEmail());
        edtPassword.setText(user.getPassword());
    }
}