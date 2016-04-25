package com.app.yoga.yogaapplication;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import com.facebook.FacebookSdk;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Lenovo on 4/18/2016.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        facebookInitialize();
    }

    private void facebookInitialize() {
        FacebookSdk.sdkInitialize(getApplicationContext());
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.app.yoga.yogaapplication",  // replace with your unique package name
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.e("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }
}
