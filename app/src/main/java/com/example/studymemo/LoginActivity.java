package com.example.studymemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edtID;
    EditText edtPW;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtID = findViewById(R.id.edtID);
        edtPW = findViewById(R.id.edtPW);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtID.getText().toString().replace(" ", "").equals("")) {
                    Toast.makeText(getApplicationContext(), "ID를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
                else if (edtPW.getText().toString().replace(" ", "").equals("")) {
                    Toast.makeText(getApplicationContext(), "패스워드를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
                else if(!edtID.getText().toString().replace(" ", "").equals("")&& !edtPW.getText().toString().replace(" ", "").equals("")){
                    String id = edtID.getText().toString().trim();
                    String pw = edtPW.getText().toString().trim();

                    Intent in = new Intent(getApplicationContext(), MemoActivity.class);
                    startActivity(in);
                }


            }
        });
    }
}