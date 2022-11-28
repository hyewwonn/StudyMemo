package com.example.studymemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import yuku.ambilwarna.AmbilWarnaDialog;

public class MemoActivity extends AppCompatActivity {
    ImageButton btnBack;
    Button btnBgcolor, btntxtsize, btntxtcolor, btnSave;
    Spinner spnFolder;
    EditText edtTitle, edtContent, dlgedttxtsize;
    LinearLayout linMemo;
    int defaultColor;
    View diatxtsize;
    TextView idpw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        defaultColor = ContextCompat.getColor(MemoActivity.this, R.color.black);
        btnBack = findViewById(R.id.btnBack);
        btnBgcolor = findViewById(R.id.btnBgcolor);
        btntxtsize = findViewById(R.id.btntxtsize);
        btntxtcolor = findViewById(R.id.btntxtcolor);
        btnSave = findViewById(R.id.btnSave);
        spnFolder = findViewById(R.id.spnFolder);
        edtTitle = findViewById(R.id.edtTitle);
        edtContent = findViewById(R.id.edtContent);
        linMemo = findViewById(R.id.linMemo);
        idpw = findViewById(R.id.idpw);

        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userPW = intent.getStringExtra("usetPW");
        idpw.setText(userID+" "+userPW);

        defaultColor = ContextCompat.getColor(MemoActivity.this, R.color.white);


        btnBgcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openColorPicker();
            }
        });
        btntxtsize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diatxtsize = View.inflate(MemoActivity.this, R.layout.dialog_txtsize, null);

                AlertDialog.Builder dlg = new AlertDialog.Builder(MemoActivity.this);
                dlg.setView(diatxtsize);
                dlg.setTitle("Text Size");
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dlgedttxtsize = diatxtsize.findViewById(R.id.dlgedttxtsize);
                        edtContent.setTextSize(Integer.parseInt(dlgedttxtsize.getText().toString().trim()));
                        Toast.makeText(getApplicationContext(), "변경 완료", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "변경 취소", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });
        btntxtcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtColorPicker();
            }
        });
    }

    public void openColorPicker(){
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, defaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                //취소
            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                  defaultColor = color;
                  linMemo.setBackgroundColor(defaultColor);
            }
        });
        colorPicker.show();
    }
    public void txtColorPicker(){
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, defaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                //취소
            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                defaultColor = color;
                edtContent.setTextColor(defaultColor);
            }
        });
        colorPicker.show();
    }
}