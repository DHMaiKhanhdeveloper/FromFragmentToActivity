package com.example.fromfragmenttoactivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment3 extends Fragment {

    private View mView;
    private EditText edtEmail,edtPassword;
    private Button btnFragmentP3;
    private User user;
    private Activity3 activity3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_3, container, false);
        init();
        return mView;
    }
    private void init() {

        edtEmail = mView.findViewById(R.id.edt_email);
        edtPassword = mView.findViewById(R.id.edt_password);
        btnFragmentP3 = mView.findViewById(R.id.btn_send_fragmentP3);
        activity3 = (Activity3) getActivity();
        user = (User) getArguments().get("object_user");

        edtEmail.setText(user.getEmail());
        edtPassword.setText(user.getPassword());

        btnFragmentP3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendActivity();
            }
        });
    }

    private void SendActivity() {
        String strEmail = edtEmail.getText().toString().trim();
        String strPassword = edtPassword.getText().toString().trim();
        user = new User(strEmail ,strPassword );
        activity3.getEdtEmail().setText(user.getEmail());
        activity3.getEdtPassword().setText(user.getPassword());
    }
}