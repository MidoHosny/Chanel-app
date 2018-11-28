package com.example.android.channels;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {

    GridView list_view_channel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView vav = (BottomNavigationView) findViewById(R.id.nav_Home);

        vav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                int id = item.getItemId();

                /** coding in hear */

                if (id == R.id.Home_id) {

                } else if (id == R.id.Menu_id) {

                    startActivity(new Intent(HomeActivity.this, MenuActivity.class));
                }

                return false;
            }
        });


        list_view_channel = (GridView) findViewById(R.id.list_view_channel);

        final ArrayList<chanel_item> items = new ArrayList<chanel_item>();
        items.add(new chanel_item(R.drawable.logo_icon, "كل القناوات"));
        items.add(new chanel_item(R.drawable.quran, "القران الكريم"));
        items.add(new chanel_item(R.drawable.movie_ar, "افلام عربيه"));
        items.add(new chanel_item(R.drawable.sport, "رياضه"));
        items.add(new chanel_item(R.drawable.move_en, "افلام اجنبيه"));
        items.add(new chanel_item(R.drawable.neiws, "اخبار"));
        items.add(new chanel_item(R.drawable.baby, "اطفال"));
        items.add(new chanel_item(R.drawable.song, "اغانى"));
        items.add(new chanel_item(R.drawable.msehy, "قنوات قبطيه"));

        Adapter mAdapter = new Adapter(items);
        list_view_channel.setAdapter(mAdapter);
        list_view_channel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Toast.makeText(getApplicationContext(), "0", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(HomeActivity.this, AllChannel.class));
                }
                if (position == 1) {
                    Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(HomeActivity.this, Quran.class));
                }
                if (position == 2) {
                    Toast.makeText(getApplicationContext(), "2", Toast.LENGTH_LONG).show();
                }
                if (position == 3) {
                    Toast.makeText(getApplicationContext(), "3", Toast.LENGTH_LONG).show();
                }
                if (position == 4) {
                    Toast.makeText(getApplicationContext(), "4", Toast.LENGTH_LONG).show();
                }
                if (position == 5) {
                    Toast.makeText(getApplicationContext(), "5", Toast.LENGTH_LONG).show();
                }
                if (position == 6) {
                    Toast.makeText(getApplicationContext(), "6", Toast.LENGTH_LONG).show();
                }
                if (position == 7) {
                    Toast.makeText(getApplicationContext(), "7", Toast.LENGTH_LONG).show();
                }
                if (position == 8) {
                    Toast.makeText(getApplicationContext(), "7", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public class Adapter extends BaseAdapter {

        ArrayList<chanel_item> chanel_items = new ArrayList<chanel_item>();


        public Adapter(ArrayList<chanel_item> chanel_items) {
            this.chanel_items = chanel_items;
        }

        @Override
        public int getCount() {
            return chanel_items.size();
        }

        @Override
        public Object getItem(int position) {
            return chanel_items.get(position).mTxtCannel;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = getLayoutInflater();

            View view = layoutInflater.inflate(R.layout.channel_item_row, null);
            CircleImageView mImage_channel = (CircleImageView) view.findViewById(R.id.img_channel);
            TextView mTxt = (TextView) view.findViewById(R.id.txt_channel);

            mImage_channel.setImageResource(chanel_items.get(position).mImageCannel);
            mTxt.setText(chanel_items.get(position).mTxtCannel);
            return view;
        }
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
