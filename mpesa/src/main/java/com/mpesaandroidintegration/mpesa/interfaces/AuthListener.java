package com.mpesaandroidintegration.mpesa.interfaces;


import com.mpesaandroidintegration.mpesa.utils.Pair;

public interface AuthListener {
    public void onAuthError(Pair<Integer, String> result);
    public void onAuthSuccess();
}
