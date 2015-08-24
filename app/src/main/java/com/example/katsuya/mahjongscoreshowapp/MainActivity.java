package com.example.katsuya.mahjongscoreshowapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //値たち
    private int gameRound = 0;
    private int windNum = 0;
    private TextView gameText;
    private TextView wind1, wind2, wind3, wind4;
    private TextView score1, score2, score3, score4;
    private TextView score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //値をonCreate時に初期化
        gameText = (TextView) findViewById(R.id.roundText);

        wind1 = (TextView) findViewById(R.id.wind1);
        wind2 = (TextView) findViewById(R.id.wind2);
        wind3 = (TextView) findViewById(R.id.wind3);
        wind4 = (TextView) findViewById(R.id.wind4);

        score1 = (TextView) findViewById(R.id.score1);
        score2 = (TextView) findViewById(R.id.score2);
        score3 = (TextView) findViewById(R.id.score3);
        score4 = (TextView) findViewById(R.id.score4);

        //南西北側のレイアウト回転
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.linearLayout2);
        linearLayout2.setRotation(270.0f);
        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.linearLayout3);
        linearLayout3.setRotation(180.0f);
        LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.linearLayout4);
        linearLayout4.setRotation(90.0f);
    }


    public void nextGame(View view) {
        String[] games = {"東1", "東2", "東3", "東4", "南1", "南2", "南3", "南4"};
        String[] wind = {"東", "北", "西", "南"};

        //局変更
        gameRound = (gameRound + 1) % 8;
        gameText.setText(games[gameRound]);

        //それぞれの風(東南西北)変更
        windNum++;
        wind1.setText(wind[(windNum + 4) % 4]);
        wind2.setText(wind[(windNum + 3) % 4]);
        wind3.setText(wind[(windNum + 2) % 4]);
        wind4.setText(wind[(windNum + 1) % 4]);

    }

    public void changeScore(View view) {

        //どのスコアがクリックされたか
        switch (view.getId()){
            case R.id.score1:
                score = score1;
                break;
            case R.id.score2:
                score = score2;
                break;
            case R.id.score3:
                score = score3;
                break;
            case R.id.score4:
                score = score4;
                break;
            default:
        }

        //EditTextとAlertDialog作製
        final EditText editView = new EditText(MainActivity.this);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        //ダイアログの実装
        alertDialogBuilder
                .setTitle("点数入力")
                .setMessage("点数を入力してください。")
                .setView(editView);

        alertDialogBuilder.setPositiveButton("＋",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick( DialogInterface dialog, int which ) {
                        int changeScore = Integer.parseInt( editView.getText().toString() );
                        int sum = Integer.parseInt( score.getText().toString() ) + changeScore;
                        score.setText( String.valueOf(sum) );
                    }
                });

        alertDialogBuilder.setNegativeButton("ー",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick( DialogInterface dialog, int which ) {
                        int changeScore = Integer.parseInt (editView.getText().toString() );
                        int sum = Integer.parseInt( score.getText().toString() ) - changeScore;
                        score.setText( String.valueOf(sum) );
                    }
                });

        alertDialogBuilder.setNeutralButton("Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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
