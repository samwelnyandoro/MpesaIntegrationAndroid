package com.mpesaandroidintegration.mpesa.interfaces;


import com.mpesaandroidintegration.mpesa.utils.Pair;

public interface MpesaListener {
    public void onMpesaError(Pair<Integer, String> result);
    public void onMpesaSuccess(String MerchantRequestID, String CheckoutRequestID, String CustomerMessage);
}
