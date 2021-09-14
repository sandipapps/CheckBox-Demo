package com.sandipbhattacharya.checkboxdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1, cb2, cb3, cb4;
    ImageButton btnReset, btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb1 = findViewById(R.id.checkBox);
        cb2 = findViewById(R.id.checkBox2);
        cb3 = findViewById(R.id.checkBox3);
        cb4 = findViewById(R.id.checkBox4);
        btnReset = findViewById(R.id.imageButton);
        btnSubmit  =findViewById(R.id.imageButton2);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                result.append("My expertise:");
                if(cb1.isChecked()){
                    result.append("\n" + cb1.getText().toString());
                }
                if(cb2.isChecked()){
                    result.append("\n" + cb2.getText().toString());
                }
                if(cb3.isChecked()){
                    result.append("\n" + cb3.getText().toString());
                }
                if(cb4.isChecked()){
                    result.append("\n" + cb4.getText().toString());
                }
                if(!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked())
                    result.append("\nNone");
                Message.message(MainActivity.this, result.toString());
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb1.isChecked())
                    cb1.setChecked(false);
                if(cb2.isChecked())
                    cb2.setChecked(false);
                if(cb3.isChecked())
                    cb3.setChecked(false);
                if(cb4.isChecked())
                    cb4.setChecked(false);
            }
        });
        /*cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                if(checked)
                    Message.message(MainActivity.this, "Learning Android is a great choice!");
                else
                    Message.message(MainActivity.this, "You may be losing some great opportunity.");
            }
        });*/

        /*cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Message.message(MainActivity.this, "Learning Android is a great choice!");
                else
                    Message.message(MainActivity.this, "You may be losing some great opportunity.");
            }
        });*/

        // For example:
        cb1.setOnCheckedChangeListener(new MyCheckedChangeListener());
        cb2.setOnCheckedChangeListener(new MyCheckedChangeListener());
    } // onCreate() ends.

    class MyCheckedChangeListener implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(buttonView == cb1){
                if(isChecked)
                    Log.d("CheckBox1", "Checked");
                else
                    Log.d("CheckBox1", "Uncheched");
            }
            if(buttonView == cb2){
                if(isChecked)
                    Log.d("CheckBox2", "Checked");
                else
                    Log.d("CheckBox2", "Uncheched");
            }
        }
    }

    public void onCheckBoxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.checkBox:
                if(checked)
                    Log.d("CheckBox1", "Checked");
                else
                    Log.d("CheckBox1", "Uncheched");
                break;
            case R.id.checkBox2:
                if(checked)
                    Log.d("CheckBox2", "Checked");
                else
                    Log.d("CheckBox2", "Uncheched");
                break;
            case R.id.checkBox3:
                if(checked)
                    Log.d("CheckBox3", "Checked");
                else
                    Log.d("CheckBox3", "Uncheched");
                break;
            case R.id.checkBox4:
                if(checked)
                    Log.d("CheckBox4", "Checked");
                else
                    Log.d("CheckBox4", "Uncheched");
                break;
        }
    }
}
