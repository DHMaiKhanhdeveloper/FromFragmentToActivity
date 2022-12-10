package com.example.fromfragmenttoactivity;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment4 extends Fragment {

    private View mView;
    private EditText edtEmail,edtPassword;
    private Button btnFragmentP4;
    private User user;
    private static ISendFromFragmentToAcivity iSendFromFragmentToAcivity;
    private Activity4 activity4;

    public static Fragment4 getInstance1(User users,ISendFromFragmentToAcivity listenerSendFromFragmentToAcivity){
        iSendFromFragmentToAcivity = listenerSendFromFragmentToAcivity;
        Fragment4 fragment4 = new Fragment4();
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_user",users);
//        bundle.putString("key_email",strEmail);

        fragment4.setArguments(bundle);
        return  fragment4;

    }

    public static Fragment4 getInstance2(User users){
        Fragment4 fragment4 = new Fragment4();
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_user",users);
//        bundle.putString("key_email",strEmail);

        fragment4.setArguments(bundle);
        return  fragment4;

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_4, container, false);
        init();
        return mView;
    }
    private void init() {

        edtEmail = mView.findViewById(R.id.edt_email);
        edtPassword = mView.findViewById(R.id.edt_password);
        btnFragmentP4 = mView.findViewById(R.id.btn_send_fragmentP4);
        activity4 = (Activity4) getActivity();
        user = (User) getArguments().get("object_user");

        edtEmail.setText(user.getEmail());
        edtPassword.setText(user.getPassword());

        btnFragmentP4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendActivity();
            }
        });
    }

    private void SendActivity() {
        String strEmail = edtEmail.getText().toString().trim();
        String strPassword = edtPassword.getText().toString().trim();
        User user = new User(strEmail ,strPassword );
//        iSendFromFragmentToAcivity = activity4;
        iSendFromFragmentToAcivity.SendData(user);
//        activity3.getEdtEmail().setText(user.getEmail());
//        activity3.getEdtPassword().setText(user.getPassword());
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        iSendFromFragmentToAcivity = (ISendFromFragmentToAcivity) context;
    }
}