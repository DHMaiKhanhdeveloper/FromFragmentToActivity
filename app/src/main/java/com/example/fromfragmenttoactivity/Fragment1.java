package com.example.fromfragmenttoactivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment1 extends Fragment {

   private View mView;
   private EditText edtEmail;
   private Button btnFragmentP1;
   private Activity1 activity1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_1, container, false);
        init();
        return mView;
    }

    private void init() {

        edtEmail = mView.findViewById(R.id.edt_email);
        btnFragmentP1 = mView.findViewById(R.id.btn_send_fragmentP1);
        activity1 = (Activity1) getActivity();

        edtEmail.setText(activity1.getmStrEmail());

        btnFragmentP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendActivity();
            }
        });
    }

    private void SendActivity() {
        String strEmail = edtEmail.getText().toString().trim();

        activity1.getEdtEmail().setText(strEmail);
    }
}