package com.example.program5counter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnstart,btnstop,reset;
    TextView txtcounter;
    int i=1;
    Handler myhandler=new Handler();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnstart=findViewById(R.id.button);
        btnstop=findViewById(R.id.button2);
        txtcounter=findViewById(R.id.txtcounter);
        reset=findViewById(R.id.button3);

    }
    public void start(View v)
    {
        i=1;
        myhandler.postDelayed(Threadcount,0);
    }
    public void stop(View v)
    {
        myhandler.removeCallbacks(Threadcount);
    }

    public void reset(View v)
    {
        txtcounter.setText("0");
        i=1;
    }
    public Runnable Threadcount=new Runnable()


    {
        @Override
        public void run()
        { txtcounter.setText(""+i);
            i++;
            myhandler.postDelayed(Threadcount,0);
        }
    };
}