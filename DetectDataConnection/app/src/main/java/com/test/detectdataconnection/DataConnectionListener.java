package com.test.detectdataconnection;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;
//Handle Network Connection state change events
public class DataConnectionListener extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        //Checking data connection and then show message based on that
        if (isConnected(context))
            Toast.makeText(context, "Data connection available", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(context, "Data connection not available", Toast.LENGTH_SHORT).show();
    }
    /* Check data connection
     * @param mContext context of current activity
     * @return status of connection;  True - connected  : False - connection failed; */
    private boolean isConnected(Context mContext)
    {
        //Create instance for Connectivity manager;
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        //Fetch active network connection ifo
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        //Checking data connection status
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }
}
