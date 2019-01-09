package com.example.tranvanha.dangonngutrongandroid;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText edtten,edtmatkhau,edttaikhoan;
    Button btnxacnhan;
    TextView tvthongtin;
    ImageView imanh,imvietnam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();

        imanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ganngonngu("en");

            }
        });
        imvietnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ganngonngu("vi-rVN");

            }
        });


        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten=edtten.getText().toString();
                String taikhoan=edttaikhoan.getText().toString();
                String matkhau=edtmatkhau.getText().toString();

                tvthongtin.setText(
                        getResources().getString(R.string.Hello)+""+ten +"\n"

                        +getResources().getString(R.string.accountout)+" " +taikhoan+"\n"
                        +getResources().getString(R.string.pass)+" "+matkhau+"\n"

                );
            }
        });
    }

    private void Anhxa() {
        edtmatkhau=(EditText)findViewById(R.id.edt_pass);
        edttaikhoan=(EditText)findViewById(R.id.edt_account);
        edtten=(EditText)findViewById(R.id.edt_name);

        btnxacnhan=(Button)findViewById(R.id.btn_cofirm);
        tvthongtin=(TextView)findViewById(R.id.tv_thongtin);

        imanh=(ImageView)findViewById(R.id.im_anh);
        imvietnam=(ImageView)findViewById(R.id.im_vietnam);

    }
    public void ganngonngu(String language){
        Locale locale = new Locale(language);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
        Intent i = new Intent(MainActivity.this,MainActivity.class);
        startActivity(i);

    }
}
