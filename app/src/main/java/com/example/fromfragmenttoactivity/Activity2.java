package com.example.fromfragmenttoactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    private EditText edtEmail;
    private Button btnActivityP2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        init();
    }

    private void init(){
        edtEmail = findViewById(R.id.edt_email);
        btnActivityP2 = findViewById(R.id.btn_send_activityP2);
        btnActivityP2.setOnClickListener(new View.OnClickListener() {
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
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        Fragment2 fragment2 = new Fragment2();
        Bundle bundle = new Bundle();
        bundle.putString("key_email",strEmail);
        fragment2.setArguments(bundle);
        fragmentTransaction.add(R.id.frameLayout, fragment2);
        fragmentTransaction.commit();

//        mStrEmail = strEmail;
//
    }

    public EditText getEdtEmail() {
        return edtEmail;
    }
}