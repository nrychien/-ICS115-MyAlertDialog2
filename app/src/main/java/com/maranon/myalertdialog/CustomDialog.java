package com.maranon.myalertdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CustomDialog extends DialogFragment {
    LayoutInflater inflater;
    View view;
    EditText etUser, etPwd;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.activity_custom_dialog, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                etUser = (view.findViewById(R.id.et_username));
                etPwd = (view.findViewById(R.id.et_password));

                String user = etUser.getText().toString();
                String password = etPwd.getText().toString();
                String msg = "Username is " + user + " Password is " + password;

                Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i){
                dialogInterface.cancel();
            }
        });

        builder.setTitle("Login");

        Dialog dialog = builder.create();
        return dialog;
    }
}