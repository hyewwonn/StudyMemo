package com.example.studymemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import yuku.ambilwarna.AmbilWarnaDialog;

public class MemoActivity extends AppCompatActivity {
    ImageButton btnBack, btnAddimg;
    Button btnBgcolor, btntxtsize, btntxtcolor, btnSave;
    Spinner spnFolder;
    EditText edtTitle, edtContent, dlgedttxtsize;
    LinearLayout linMemo;
    int defaultColor;
    View diatxtsize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        defaultColor = ContextCompat.getColor(MemoActivity.this, R.color.black);
        btnBack = findViewById(R.id.btnBack);
        btnAddimg = findViewById(R.id.btnAddimg);
        btnBgcolor = findViewById(R.id.btnBgcolor);
        btntxtsize = findViewById(R.id.btntxtsize);
        btntxtcolor = findViewById(R.id.btntxtcolor);
        btnSave = findViewById(R.id.btnSave);
        spnFolder = findViewById(R.id.spnFolder);
        edtTitle = findViewById(R.id.edtTitle);
        edtContent = findViewById(R.id.edtContent);
        linMemo = findViewById(R.id.linMemo);

        defaultColor = ContextCompat.getColor(MemoActivity.this, R.color.white);


        btnBgcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openColorPicker();
            }
        });
    }
//        btntxtsize.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                diatxtsize = (View) View.inflate(MainActivity.this, R.layout.dialog_txtsize, null);
//
//                AlertDialog.Builder dlg = new AlertDialog.Builder(MemoActivity.this);
//                dlg.setView(diatxtsize);
//                dlg.setTitle("Text Size");
//                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dlgedttxtsize = (EditText) diatxtsize.findViewById(R.id.dlgedttxtsize);
//                        edtContent.setTextSize(Integer.parseInt(dlgedttxtsize.getText().toString().trim()));
//                        Toast.makeText(getApplicationContext(), "가입완료~", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(getApplicationContext(), "가입취소하였습니다", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                dlg.show();
//
////                int txtsize = Integer.parseInt(edttxtsize.getText().toString().trim());
////                edtContent.setTextSize(txtsize);
//            }
//        });
//    }
//
    public void openColorPicker(){
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, defaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                //취소
            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                  defaultColor = color;
//                  Drawable drawable = ContextCompat.getDrawable(MemoActivity.this, R.drawable.radius30);
////                  drawable.setColorFilter(ContextCompat.getColor(MemoActivity.this, defaultColor));
//                 drawable.setTint(defaultColor);
                  linMemo.setBackgroundColor(defaultColor);
                  linMemo.setBackgroundResource(R.drawable.radius30);
            }
        });
        colorPicker.show();
    }
}