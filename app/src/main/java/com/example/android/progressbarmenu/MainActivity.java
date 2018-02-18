package com.example.android.progressbarmenu;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    SeekBar SR;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SR =(SeekBar)findViewById(R.id.simpleSeekBar);



        SR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
                final TextView RV = findViewById(R.id.red_rec);
                final TextView BV = findViewById(R.id.blue_rec);
                RV.setBackgroundColor(Color.argb(255, 200, progress, progress));
                BV.setBackgroundColor(Color.argb(255, progress, progress, 200));
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }



    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimpSlifiableIfStatement

        if (id == R.id.action_Resume) {



            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void viewDialog(MenuItem item) {
        String message="For more info for this Traning task"
                     + "\nPlease visit 1MAC Discussion forums!";



        AlertDialog.Builder aDB = new AlertDialog.Builder(this);

        aDB.setMessage(message);
        aDB.setPositiveButton("VISIT FORUMS", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://macdiscussions.udacity.com/t/topic/99751"));
                startActivity(browserIntent);

            }
        });

        aDB.setNegativeButton("NOT NOW", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        AlertDialog alertDialog = aDB.create();
        alertDialog.show();
    }


}
