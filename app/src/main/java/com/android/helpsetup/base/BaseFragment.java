package com.android.helpsetup.base;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {
    private ProgressDialog progressDialog;
     private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        progressDialog = new ProgressDialog(context);//object bnakr contex pass krenge
    }

    public void showLoader(){
        try {
            if (progressDialog == null) {
                progressDialog = new ProgressDialog(context);
            }
            progressDialog.show();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void hideLoader() {
        try {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
