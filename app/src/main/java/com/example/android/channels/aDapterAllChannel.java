package com.example.android.channels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

public class aDapterAllChannel extends BaseAdapter implements Filterable {

    Context c;
    customFilter customFilter;
    ArrayList<allChannel_item> allChannel_items = new ArrayList<allChannel_item>();
    ArrayList<allChannel_item> temp = new ArrayList<allChannel_item>();

    public aDapterAllChannel(Context c ,ArrayList<allChannel_item> allChannel_items) {
        this.c=c;
        this.allChannel_items = allChannel_items;
        this.temp = allChannel_items;

    }

    @Override
    public int getCount() {
        return allChannel_items.size();
    }

    @Override
    public Object getItem(int position) {
        return allChannel_items.get(position).name_channel;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(c);
        View viewq = layoutInflater.inflate(R.layout.all_channel_item_row, null);


        TextView name_channel = (TextView) viewq.findViewById(R.id.name_channel);
        TextView trdd_channel = (TextView) viewq.findViewById(R.id.trdd_channel);
        TextView astqtap_tchannel = (TextView) viewq.findViewById(R.id.astqtap_tchannel);
        TextView veritical_channel = (TextView) viewq.findViewById(R.id.veritical_channel);

        name_channel.setText(allChannel_items.get(position).getName_channel());
        trdd_channel.setText(allChannel_items.get(position).getTrdd_channel());
        astqtap_tchannel.setText(allChannel_items.get(position).getAstqtap_tchannel());
        veritical_channel.setText(allChannel_items.get(position).getVeritical_channel());


        return viewq;
    }

    @Override
    public Filter getFilter() {

        if (customFilter == null) {
            customFilter = new customFilter();
        }
        return customFilter;
    }


    public class customFilter extends Filter {




        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();


            if (constraint != null && constraint.length() > 0) {

                constraint = constraint.toString().toUpperCase();

                ArrayList<allChannel_item> filter = new ArrayList<allChannel_item>();

                for ( int i = 0; i < temp.size(); i++) {

                    if (temp.get(i).getName_channel().toUpperCase().contains(constraint)) {

                        allChannel_item item = new allChannel_item(temp.get(i).getName_channel(),
                                temp.get(i).getTrdd_channel(),
                                temp.get(i).getAstqtap_tchannel(),
                                temp.get(i).getVeritical_channel());
                        filter.add(item);
                    }
                }

                filterResults.count = filter.size();
                filterResults.values = filter;
            } else {
                filterResults.count = temp.size();
                filterResults.values = temp;
            }
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            allChannel_items = (ArrayList<allChannel_item>) results.values;

            notifyDataSetChanged();

        }
    }

}