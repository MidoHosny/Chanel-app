package com.example.android.channels;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AllChannel extends AppCompatActivity implements TextWatcher {
    EditText searchView_all_channel;
    ListView list_all_channel;
    aDapterAllChannel aDapterAllChannel;
    ArrayList<allChannel_item> allChannel_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_channel);

        searchView_all_channel = (EditText) findViewById(R.id.searchView);
        searchView_all_channel.addTextChangedListener(this);
        list_all_channel = (ListView) findViewById(R.id.list_all_channel);


        allChannel_items = new ArrayList<allChannel_item>();

        allChannel_items.add(new allChannel_item("روتانا سينما", "11959", "v", "عمودى"));
        allChannel_items.add(new allChannel_item("روتانا سينما", "11959", "v", "عمودى"));
        allChannel_items.add(new allChannel_item("روتانا سينما", "11959", "v", "عمودى"));
        allChannel_items.add(new allChannel_item("  سينما", "11959", "v", "عمودى"));
        allChannel_items.add(new allChannel_item("عبدالله", "11959", "v", "عمودى"));
        allChannel_items.add(new allChannel_item("mido", "11959", "v", "عمودى"));
        allChannel_items.add(new allChannel_item("روتانا سينما", "11959", "v", "عمودى"));

        aDapterAllChannel = new aDapterAllChannel(AllChannel.this, allChannel_items);

        list_all_channel.setAdapter(aDapterAllChannel);


    }

    /**************************End_onCreate**********************************/

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {


        this.aDapterAllChannel.getFilter().filter(s);
 

    }

    @Override
    public void afterTextChanged(Editable s) {

    }


}
