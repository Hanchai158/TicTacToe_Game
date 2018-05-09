package com.hanchai.tictactoe_game;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class TicTacToe extends AppCompatActivity {
    ImageButton btn_01;
    ImageButton btn_02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        String UserName = getIntent().getStringExtra("UserName");
        setContentView(R.layout.activity_tic_tac_toe);
        TextView namePlayer =  findViewById(R.id.namePlayer);
        Log.d("show",UserName);
        namePlayer.setText(UserName);


        btn_01 = (ImageButton)findViewById(R.id.box_01);
        btn_02 = (ImageButton)findViewById(R.id.box_02);

        btn_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_01.setImageResource(R.drawable.bg_x);
            }
        });
        btn_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_02.setImageResource(R.drawable.bg_o);
            }
        });
    }

}
