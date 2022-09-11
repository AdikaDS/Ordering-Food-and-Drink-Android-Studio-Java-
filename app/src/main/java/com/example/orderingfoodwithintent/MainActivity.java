package com.example.orderingfoodwithintent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inputMenu;
    Button makanan;
    Button minuman;
    TextView jumleh;
    public static final String MESSAGE_EXTRA = "MESSAGE_KEY";

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        String replyText = result.getData().getStringExtra(MainActivity2.REPLY_EXTRA);
                        jumleh.setText(replyText);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputMenu = findViewById(R.id.input_menu);
        makanan = findViewById(R.id.food);
        minuman = findViewById(R.id.drink);
        jumleh = findViewById(R.id.total_jumlah);


        makanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity2.class);
                String pesan = inputMenu.getText().toString();
                intent.putExtra(MESSAGE_EXTRA, pesan);
                intent.putExtra("key", "Makanan");
                launcher.launch(intent);
            }
        });

        minuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(view.getContext(),MainActivity2.class);
                String pesan1 = inputMenu.getText().toString();
                intent1.putExtra(MESSAGE_EXTRA, pesan1);
                intent1.putExtra("key", "Minuman");
                launcher.launch(intent1);
            }
        });
    }
}