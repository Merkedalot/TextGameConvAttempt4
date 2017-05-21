package com.example.admin.textgameconvattempt4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TextGameActivity extends AppCompatActivity {

    Button mButton;
    Button myButton;
    EditText mEdit;
    TextView mText;

    int location=0;

    CompositeOnClickListener groupListener = new CompositeOnClickListener();

    private class CompositeOnClickListener implements View.OnClickListener{
        List<View.OnClickListener> listeners;

        public CompositeOnClickListener(){
            listeners = new ArrayList<View.OnClickListener>();
        }

        public void addOnClickListener(View.OnClickListener listener){
            listeners.add(listener);
        }

        @Override
        public void onClick(View v){
            for(View.OnClickListener listener : listeners){
                listener.onClick(v);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_game);

        myButton = (Button)findViewById(R.id.button1);
        myButton.setOnClickListener(groupListener);

        mText = (TextView)findViewById(R.id.textView1);
        mEdit = (EditText)findViewById(R.id.editText1);
        mText.setText("Please enter your name \n \n location equals: "+location);

        groupListener.addOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (location==0) {
                    mText.setText("Welcome, " + mEdit.getText().toString() + ", to the world of Vashiran! \n \n location equals: "+location); //\n \n Make a choice: \n \n 1-Town \n 2-Sewers \n 3-Town Inn \n 4-Town shop");
                }
                if (location>=1){
                    mText.setText("You entered: "+mEdit.getText().toString()+". \n \n location equals: "+location+" \n \n Enter any command to enter town"); //Enter another command: ");
                    //if (location >=2) {
                        town();
                    //}
                }
                location++;
                mEdit.setText("");
            }
        });

        /*void town(){
            groupListener.addOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mText.setText("You entered have entered the Town: " + mEdit.getText().toString() + ".");
                }
            });
        }*/

    }
    void town(){
        groupListener.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mText.setText("You entered have entered the Town: " + mEdit.getText().toString() + ".");
            }
        });
    }
}
