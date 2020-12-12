package com.nitish.qrhuntorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_id,et_clue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id=findViewById(R.id.et_id);
        et_clue=findViewById(R.id.et_clue);

        findViewById(R.id.btn_gen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_id=et_id.getText().toString();
                String str_clue=et_clue.getText().toString();
                if (str_id.length()<1){
                    str_id+="EMPTY";
                }
                startActivity(new Intent(getApplicationContext(),qrgenerated.class).putExtra("RAW_INFO",str_id).putExtra("CLUE",str_clue));
            }
        });

        findViewById(R.id.btn_decoder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),QrDecoder.class));
            }
        });
    }
}
