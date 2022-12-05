package com.android.helpsetup.base;

public interface CommonStatusMessageListener {
    void onSuccessResponse(Object response);
    void onError(String error);
}
