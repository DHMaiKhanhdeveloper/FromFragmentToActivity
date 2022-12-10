package com.example.fromfragmenttoactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity3 extends AppCompatActivity {


    private EditText edtEmail, edtPassword;
    private Button btnActivityP3;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        init();
    }

    private void init(){
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        btnActivityP3 = findViewById(R.id.btn_send_activityP3);
        btnActivityP3.setOnClickListener(new View.OnClickListener() {
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

        Fragment3 fragment3 = new Fragment3();
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_user",user);
//        bundle.putString("key_email",strEmail);

        fragment3.setArguments(bundle);
        fragmentTransaction.add(R.id.frameLayout, fragment3);
        fragmentTransaction.commit();

//        mStrEmail = strEmail;
//
    }

    public EditText getEdtEmail() {
        return edtEmail;
    }

    public EditText getEdtPassword() {
        return edtPassword;
    }


}