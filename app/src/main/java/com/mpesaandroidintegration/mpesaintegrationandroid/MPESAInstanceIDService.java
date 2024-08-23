package com.mpesaandroidintegration.mpesaintegrationandroid;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.messaging.FirebaseMessagingService;

public class MPESAInstanceIDService extends FirebaseMessagingService {
    private static final String TAG = "MPESAInstanceIDService";
    @Override
    public void onNewToken(@NonNull String token) {
        Log.d(TAG, "Refreshed token: " + token);

        // Save token to shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.SHARED_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("InstanceID", token);
        editor.apply();

        // Optionally, send token to your app server.
        sendRegistrationToServer(token);
    }

    private void sendRegistrationToServer(String token) {
        // Implement this method to send token to your app server.
    }
}

