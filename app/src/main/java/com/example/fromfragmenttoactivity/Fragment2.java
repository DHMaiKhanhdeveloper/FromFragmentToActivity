package com.example.fromfragmenttoactivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment2 extends Fragment {

    private View mView;
    private EditText edtEmail;
    private Button btnFragmentP2;
    private Activity2 activity2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_2, container, false);
        init();
        return mView;
    }
    private void init() {

        edtEmail = mView.findViewById(R.id.edt_email);
        btnFragmentP2 = mView.findViewById(R.id.btn_send_fragmentP2);
        activity2 = (Activity2) getActivity();

        edtEmail.setText(getArguments().getString("key_email"));

        btnFragmentP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendActivity();
            }
        });
    }

    private void SendActivity() {
        String strEmail = edtEmail.getText().toString().trim();

        activity2.getEdtEmail().setText(strEmail);
    }
}