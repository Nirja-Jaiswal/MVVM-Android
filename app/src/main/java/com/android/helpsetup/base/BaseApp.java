package com.android.helpsetup.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseApp extends AppCompatActivity {

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(BaseApp.this);
    }

    public void hideLoader(){
            progressDialog.dismiss();
    }

    public void showLoader(){
        progressDialog.show();
    }

}
