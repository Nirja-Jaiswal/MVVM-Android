package com.android.helpsetup.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;

public class AppSession {

    public static AppSession yourPreference;
    public SharedPreferences sharedPreferences;

    public static AppSession getInstance(Context context) {
        if (yourPreference == null) {
            yourPreference = new AppSession(context);
            Log.d("TAG", "GETINSTANCE: ");
        }
        return yourPreference;
    }

    public void clear() {
        sharedPreferences.edit().clear().apply();
    }

    public AppSession(Context context) {
        sharedPreferences = context.getSharedPreferences(com.android.helpsetup.sharedpreferences.Constant.PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public void setValue(String key, String value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString(key, value);
        prefsEditor.apply();
    }

    public String   getValue(String key) {
        if (sharedPreferences != null) {
            return sharedPreferences.getString(key, "");
        }
        return "";
    }

    public void setInt(String key, int value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putInt(key, value);
        prefsEditor.apply();
    }

    public int getInt(String key, int defaultValue) {
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(key, defaultValue);
        }
        return 0;
    }

    public void setBoolean(String key, boolean value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.apply();
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(key, defaultValue);
        }
        return false;
    }



/*
    public CartResponseModel.Cart getCartData(){
        return (CartResponseModel.Cart) getObject(Constant.SELLER_CART, CartResponseModel.Cart.class);
    }

  public ExchangeModel getExchangeModel(){

        return (ExchangeModel) getObject(Constant.EXCHANGE_BODY,ExchangeModel.class);

    }
    public ExchangePickupBody getExchangePickupBody(){
        return (ExchangePickupBody) getObject(Constant.EXCHANGE_PICKUP,ExchangePickupBody.class);
    }*/




    public Object getObject(String key, Class<?> classOfT) {
        String json = getString(key);
        return new Gson().fromJson(json, classOfT);
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    public void putObject(String key, Object obj) {
        checkForNullKey(key);
        Gson gson = new Gson();
        putString(key, gson.toJson(obj));
    }


    public void putString(String key, String value) {
        checkForNullKey(key);
        checkForNullValue(value);
        sharedPreferences.edit().putString(key, value).apply();
    }

    public boolean checkForNullKey(String key) {
        return key == null;
    }

    public void checkForNullValue(String value) {
        if (value == null) {
            throw new NullPointerException();
        }
    }


}
