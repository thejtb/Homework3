package c1.homework3;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity {


    public static ArrayList<String> str;
    public static String currentWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyWebFragment fraggie = (MyWebFragment) getFragmentManager().findFragmentById(R.id.webFragment);
        str = new ArrayList<String>();
        str.add("http://www.google.com");
        str.add("http://www.skype.com");

        UrlListFragment lFrag = (UrlListFragment) getFragmentManager().findFragmentById(R.id.listFragment);
        Intent intent = getIntent();
        if (intent.hasExtra("myKey")) {
            Log.i("44", "yes it works");
            Bundle extras = intent.getExtras();
            String tmp = extras.getString("myKey");
            Toast.makeText(getApplicationContext(), tmp, Toast.LENGTH_LONG).show();
            fraggie.updateUrl(tmp);
            str.add(tmp);

        }
        else if(intent.hasExtra("select"))
        {
            Bundle extras = intent.getExtras();
            String tmp = extras.getString("select");
            fraggie.updateUrl(tmp);


        }




    }








    }


