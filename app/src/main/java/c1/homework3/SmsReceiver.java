package c1.homework3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {
    public SmsReceiver() {
    }

    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent myIntent = new Intent(context,
                MainActivity.class);


        Bundle intentExtras = intent.getExtras();
        if (intentExtras != null) {
            Object[] sms = (Object[]) intentExtras.get("pdus");
            String smsMessageStr = "";
            for (int i = 0; i < sms.length; ++i) {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[i]);

                String smsBody = smsMessage.getMessageBody().toString();


                smsMessageStr += smsBody + "\n";
            }
            Toast.makeText(context, smsMessageStr, Toast.LENGTH_SHORT).show();

            myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            String temp = smsMessageStr.toString();

            if(temp.charAt(0) != ('h'))
                smsMessageStr = "http://" + smsMessageStr;
            myIntent.putExtra("myKey", smsMessageStr);
            context.startActivity(myIntent);


        }







    }
}
