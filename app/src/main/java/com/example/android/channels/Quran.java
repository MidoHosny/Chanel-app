package com.example.android.channels;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Quran extends AppCompatActivity implements TextWatcher {

    EditText searchView_quran;
    ListView list_quran;
    aDapterAllChannel aDapterAllChannel;
    ArrayList<allChannel_item> allChannel_items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran);

        searchView_quran=(EditText) findViewById(R.id.searchView_quran);
        searchView_quran.addTextChangedListener(this);
        list_quran = (ListView)findViewById(R.id.list_quran);


        allChannel_items = new ArrayList<allChannel_item>();

        allChannel_items.add(new allChannel_item("قناه المجد","23453","v","افقى"));
        allChannel_items.add(new allChannel_item("قناه مكه","23453","v","افقى"));
        allChannel_items.add(new allChannel_item("قناه الفجر","23453","v","افقى"));
        allChannel_items.add(new allChannel_item("قناه الجنه","23453","v","افقى"));

        aDapterAllChannel = new aDapterAllChannel(Quran.this, allChannel_items);

        list_quran.setAdapter(aDapterAllChannel);




    }


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
