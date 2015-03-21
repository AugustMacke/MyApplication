package de.fh_muenster.myapplication;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

/**
 * Created by user on 19.03.15.
 */
public class CalcService extends IntentService
{
    private BroadcastNotifier mBroadcaster = new BroadcastNotifier(this);

    public CalcService()
    {
        super("CalcService");
    }

    @Override
    protected void onHandleIntent(Intent workIntent)
    {
        // Gets data from the incoming Intent
        String dataString = workIntent.getDataString();

        int result = 0;
        for(int i=0; i<1000; i++)
        {
            result += i;
        }

    /*
     * Creates a new Intent containing a Uri object
     * BROADCAST_ACTION is a custom Intent action
     */
        Intent localIntent =
                new Intent(Constants.BROADCAST_ACTION)
                        // Puts the status into the Intent
                        .putExtra(Constants.EXTENDED_DATA_STATUS, result);
        // Broadcasts the Intent to receivers in this app.
        LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);

        mBroadcaster.broadcastIntentWithState(result);

    }
}