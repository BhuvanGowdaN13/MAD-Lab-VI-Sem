package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {

    Button btnspeak;
    EditText txtspeak;
    TextToSpeech texttospeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtspeak= (EditText)findViewById(R.id.edit_txt);
        btnspeak=(Button)findViewById(R.id.btn_speech);
        btnspeak.setOnClickListener(this);
        texttospeech=new TextToSpeech(getBaseContext(),  this);
        texttospeech.setLanguage(Locale.ENGLISH);
    }

    @Override
    public void onClick(View v) {
        String text=txtspeak.getText().toString();
        texttospeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }

    @Override
    public void onInit(int status) {
        if (status!=TextToSpeech.ERROR){
            Toast.makeText(getBaseContext(),"Success", Toast.LENGTH_LONG).show();
        }
    }
}