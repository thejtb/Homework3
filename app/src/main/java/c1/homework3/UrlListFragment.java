package c1.homework3;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;

/**
 * Created by Jordan on 9/26/16.
 */
public class UrlListFragment extends ListFragment implements AdapterView.OnItemClickListener{

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle state) {


        return inflater.inflate(R.layout.list_layout, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<String> str = MainActivity.str;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext() ,android.R.layout.simple_list_item_1, str);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {

        Intent myIntent = new Intent(getContext(),
                MainActivity.class);
        String selected = getListView().getItemAtPosition(position).toString();
        myIntent.putExtra("select", selected );
        getContext().startActivity(myIntent);

    }



}
