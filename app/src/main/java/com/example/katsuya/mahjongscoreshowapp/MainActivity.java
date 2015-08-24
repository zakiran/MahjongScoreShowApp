package com.example.katsuya.mahjongscoreshowapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int gameRound = 0;
    private int windNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void nextGame(View view) {
        String[] games = {"東1", "東2", "東3", "東4", "南1", "南2", "南3", "南4"};
        String[] wind = {"東", "北", "西", "南"};

        //局変更
        TextView tv = (TextView) findViewById(R.id.gameText);

        gameRound = (gameRound + 1) % 8;
        tv.setText(games[gameRound]);

        //それぞれの風(東南西北)変更
        TextView wind1 = (TextView) findViewById(R.id.wind1);
        TextView wind2 = (TextView) findViewById(R.id.wind2);
        TextView wind3 = (TextView) findViewById(R.id.wind3);
        TextView wind4 = (TextView) findViewById(R.id.wind4);

        windNum++;
        wind1.setText(wind[(windNum + 4) % 4]);
        wind2.setText(wind[(windNum + 3) % 4]);
        wind3.setText(wind[(windNum + 2) % 4]);
        wind4.setText(wind[(windNum + 1) % 4]);

    }

    public void changeScore(View view) {
        final TextView score1 = (TextView) findViewById(R.id.score1);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder
                .setTitle("点数入力")
                .setMessage("点数を入力");

        alertDialogBuilder.setPositiveButton(
                "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        score1.setText("1000");
                    }
                });

        alertDialogBuilder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
