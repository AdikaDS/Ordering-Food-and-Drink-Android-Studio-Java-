package com.example.orderingfoodwithintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView tipe;
    TextView nama;
    EditText jumlah;
    Button btn_ok;

    public static final String REPLY_EXTRA = "REPLY_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tipe = findViewById(R.id.type);
        nama = findViewById(R.id.name);
        jumlah = findViewById(R.id.amount);
        btn_ok = findViewById(R.id.buttonOk);

        Intent intent = getIntent();
        String pesan = intent.getStringExtra(MainActivity.MESSAGE_EXTRA);
        nama.setText(pesan);

        String pesan1 = intent.getStringExtra("key");
        tipe.setText(pesan1);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String replyPesan = jumlah.getText().toString();
                intent.putExtra(REPLY_EXTRA, replyPesan);
                setResult(RESULT_OK, intent);
                finish();

            }
        });


    }
}