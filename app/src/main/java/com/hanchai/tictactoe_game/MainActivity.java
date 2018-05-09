package com.hanchai.tictactoe_game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_start;
    EditText name;
    String UserName;
    TextView infoIP;
    Server server;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        infoIP = (TextView) findViewById(R.id.login_title);
        name = (EditText) findViewById(R.id.username);

        server = new Server(this);
        infoIP.setText(server.getIpAddress()+":"+server.getPort());

        btn_start =  (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        openActivity_TicTacToe();
                }
            }
        );
    }

    public void openActivity_TicTacToe(){
        Intent intent = new Intent(this,TicTacToe.class);
        /*String Name = name.toString();*/
        String Name = name.getText().toString();

        String Text = Name +" : ";
        intent.putExtra("UserName", Text);

        startActivity(intent);
    }
}
