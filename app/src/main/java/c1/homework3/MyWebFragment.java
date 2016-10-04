package c1.homework3;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewFragment;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by Jordan on 9/28/16.
 */
public class MyWebFragment extends Fragment {

    WebView weby;
    View v;
    public  String website;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle state) {
        v = inflater.inflate(R.layout.web_layout, container, false);
        weby = (WebView) v.findViewById(R.id.webViewie);
        weby.getSettings().setJavaScriptEnabled(true);
        website = "http://www.google.com";

        weby.loadUrl(website);
        weby.setWebViewClient(new HelloWebViewClient());


        return v;

    }
    public void updateUrl(String url)
    {
        website = url;
        weby.loadUrl(url);

    }


    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);
           return true;

        }
    }


}
