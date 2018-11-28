package com.example.android.channels;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class MenuActivity extends AppCompatActivity {

    TextView newChannel , shareApp , rateApp , contactUs ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        newChannel = (TextView) findViewById(R.id.newChannel);
        shareApp = (TextView) findViewById(R.id.shareApp);
        rateApp = (TextView) findViewById(R.id.rateApp);
        contactUs = (TextView) findViewById(R.id.contactUs);

        newChannel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MenuActivity.this,AddNewChannel.class));

            }
        });


        shareApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MenuActivity.this);
                LayoutInflater layoutInflater = LayoutInflater.from(MenuActivity.this);
                View view1 = layoutInflater.inflate(R.layout.share_app, null);

                alert.setView(view1);

                LinearLayout fb_Share_Oner = (LinearLayout) view1.findViewById(R.id.fb_Share_Oner);
                LinearLayout mass_share_oner = (LinearLayout) view1.findViewById(R.id.mass_share_oner);
                LinearLayout whatsapp_share_oner = (LinearLayout) view1.findViewById(R.id.whatsapp_share_oner);
                LinearLayout twetter_share_oner = (LinearLayout) view1.findViewById(R.id.twetter_share_oner);
                LinearLayout other_share_oner = (LinearLayout) view1.findViewById(R.id.other_share_oner);
                LinearLayout copyLinkShare = (LinearLayout) view1.findViewById(R.id.copyLinkShare);


                /**
                 *  on Click to Sar By twitterShare
                 */
                twetter_share_oner.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent twitter = new Intent(Intent.ACTION_SEND);
                            twitter.setType("text/plain");
                            twitter.putExtra(Intent.EXTRA_TEXT, "any Description" + "URL Application");
                            twitter.setPackage("advanced.twitter.android");
                            startActivity(twitter);
                        } catch (Exception e) {
                            Toast.makeText(MenuActivity.this, "عفوا ليس لديك هذا البرنامج", Toast.LENGTH_LONG).show();
                        }

                    }
                });

                /**
                 *  on Click to Sar By fbShareApp
                 */
                fb_Share_Oner.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent FB = new Intent(Intent.ACTION_SEND);
                        FB.setType("text/plain");
                        FB.putExtra(Intent.EXTRA_TEXT, "any Description" + "URL Application");
                        FB.setPackage("com.facebook.katana");
                        startActivity(FB);
                    }
                });

                /**
                 *  on Click to Sar By massShareApp
                 */
                mass_share_oner.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent
                                .putExtra(Intent.EXTRA_TEXT,
                                        "<---YOUR TEXT HERE--->.");
                        sendIntent.setType("text/plain");
                        sendIntent.setPackage("com.facebook.orca");
                        try {
                            startActivity(sendIntent);
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(MenuActivity.this, "عفوا ليس لديك هذا البرنامج", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                /**
                 *  on Click to Sar By whatsShareApp
                 */
                whatsapp_share_oner.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent WhatsApp = new Intent(Intent.ACTION_SEND);
                        WhatsApp.setType("text/plain");
                        WhatsApp.putExtra(Intent.EXTRA_TEXT, "any Description" + "URL Application");
                        WhatsApp.setPackage("com.whatsapp");
                        startActivity(WhatsApp);
                    }
                });

                /**
                 *  on Click to Sar By copyTextShareApp
                 */
                copyLinkShare.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("label", "Text to copy");
                        clipboard.setPrimaryClip(clip);
                        Toast.makeText(MenuActivity.this, "تم نسخ الرابط", Toast.LENGTH_LONG).show();

                    }
                });

                /**
                 *  on Click to Sar By otherShareApp
                 */
                other_share_oner.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent i = new Intent(Intent.ACTION_SEND);
                            i.setType("text/plain");
                            i.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                            String sAux = "\nLet me recommend you this application\n\n";
                            sAux = sAux + "https://play.google.com/store/apps/details?id=the.package.id \n\n";
                            i.putExtra(Intent.EXTRA_TEXT, sAux);
                            startActivity(Intent.createChooser(i, "choose one"));
                        } catch (Exception e) {
                            //e.toString();
                        }
                    }
                });

                alert.create();
                alert.show();

            }
        });


        rateApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("market://details?id=" + getApplicationContext().getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName())));
                }
            }
        });


        contactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alert = new AlertDialog.Builder(MenuActivity.this);
                LayoutInflater layoutInflater = LayoutInflater.from(MenuActivity.this);
                View view = layoutInflater.inflate(R.layout.countact_us, null);
                alert.setView(view);

                CircleImageView Facebook_mido = (CircleImageView) view.findViewById(R.id.Facebook_mido);
                CircleImageView whatsAppMido = (CircleImageView) view.findViewById(R.id.whatsAppMido);

                Facebook_mido.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {

                            Intent intent = new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("https://www.facebook.com/profile.php?id=100015232508613"));
                            startActivity(intent);

                        } catch (Exception e) {

                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/business/help/community/question/?id=1267743879941243")));

                        }
                    }
                });

                whatsAppMido.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String PhoneNumberwhatsApp = "+201206314232";
                        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://api.whatsapp.com/send?phone=+" + PhoneNumberwhatsApp)));

                    }
                });
                alert.create();
                alert.show();
            }
        });



        /**
         *  on click to navigation bottom
         */
        BottomNavigationView vav = (BottomNavigationView) findViewById(R.id.nav_menu);
        vav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if (id == R.id.Home_id) {
                    startActivity(new Intent(MenuActivity.this,HomeActivity.class));
                }
                else if (id == R.id.Menu_id){

                }

                return false;
            }
        });







    }

    /**
     *  when click back button
     */
    @Override
    public void onBackPressed() {
        startActivity(new Intent(MenuActivity.this,HomeActivity.class));
    }
}
