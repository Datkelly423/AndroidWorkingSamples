package com.downunderdev.confirmscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class ConfirmActivity extends AppCompatActivity {

    EditText code_et;
    TextView code_tv;
    Button confirm_button;

    Random r;
    String code;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        code_et = (EditText) findViewById(R.id.code_et);
        code_tv = (TextView) findViewById(R.id.code_tv);
        confirm_button = (Button) findViewById(R.id.confirm_button);

        r = new Random();
        code = String.valueOf(r.nextInt(2000)+1000);
        code_tv.setText(code);

        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = code_et.getText().toString();
                if(number.equals(code)) {
                    Intent intent = new Intent();
                    setResult(RESULT_OK, intent);
                }
                finish();
            }
        });


    }
}
