package com.example.fromfragmenttoactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity1 extends AppCompatActivity {

    private EditText edtEmail;
    private Button btnActivityP1;
    private String mStrEmail = " ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        init();
    }

    private void init(){
        edtEmail = findViewById(R.id.edt_email);
        btnActivityP1 = findViewById(R.id.btn_send_activityP1);
        btnActivityP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendFragment();
            }
        });
    }
    private void SendFragment() {
//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        Fragment1 fragment = new Fragment1();
        fragmentTransaction.add(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
        String strEmail = edtEmail.getText().toString().trim();
        mStrEmail = strEmail;
//
    }

    public String getmStrEmail() {
        return mStrEmail;
    }


    public EditText getEdtEmail() {
        return edtEmail;
    }
//
//    public void setEdtEmail(EditText edtEmail) {
//        this.edtEmail = edtEmail;
//    }
}