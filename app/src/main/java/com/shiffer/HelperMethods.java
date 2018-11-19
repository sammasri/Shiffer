package com.shiffer;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class HelperMethods {


    private static HelperMethods instance = new HelperMethods();


    static Context Context;
    ConnectivityManager ConnectivityManager;
    NetworkInfo WifiInfo, MobileInfo;
    boolean Connected = false;


    public static HelperMethods GetInstance(Context Context) {
        HelperMethods.Context = Context.getApplicationContext();
        return instance;
    }

    public boolean CheckConnection() {
        try {
            ConnectivityManager = (ConnectivityManager) Context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo NetworkInfo = ConnectivityManager.getActiveNetworkInfo();
            Connected = NetworkInfo != null && NetworkInfo.isAvailable() &&
                    NetworkInfo.isConnected();
            return Connected;


        } catch (Exception Ex) {

            System.out.println(Ex.getMessage());
            Log.v("connectivity", Ex.toString());
        }
        return Connected;
    }


}


