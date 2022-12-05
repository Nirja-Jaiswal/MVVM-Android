package com.android.helpsetup.util;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.helpsetup.R;
import com.android.helpsetup.base.CommonStatusErrorResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.ResponseBody;

public class Utils {

    public void replaceFragment(Fragment fragment, String tag, FragmentManager fragmentManager) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.contentContainer, fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commit();
    }
    // to add fragment next fragment pr kamkrke waps usi pr aana
    public  void addFragmentBackStack(FragmentManager fragmentManager, Fragment fragment,String tag, boolean isAddToBackStack) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.contentContainer, fragment);
        if (isAddToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }



    // method to check for backprass
    public Fragment getVisibleFragment(FragmentManager fragmentmanager) {
        FragmentManager fragmentManager = fragmentmanager;
        List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment != null && fragment.isVisible())
                    return fragment;
            }
        }
        return null;
    }

    public static String getServerError(int responseCode, ResponseBody responseBody) {
        String serverHandling = "Error " + responseCode + " " + "Please try again.";

                try {
                    if (responseBody != null) {
                        Gson gson = new GsonBuilder().create();
                        CommonStatusErrorResponse commonStatusMessageResponseOne = gson.fromJson(responseBody.string(), CommonStatusErrorResponse.class);
                        Log.i("ERROR_BODY", commonStatusMessageResponseOne.getMessage());
                        serverHandling = commonStatusMessageResponseOne.getMessage();
                        return serverHandling;
                    }
                } catch (Exception e) {

                    e.printStackTrace();
                }

        return serverHandling;

    }


}
