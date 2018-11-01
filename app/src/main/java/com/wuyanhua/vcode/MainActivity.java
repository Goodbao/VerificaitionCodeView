package com.wuyanhua.vcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wuyanhua.verificationcodeview.VerificationCodeView;

public class MainActivity extends AppCompatActivity {
    private VerificationCodeView verificationCodeView;
    private VerificationCodeView verificationCodeView2;
    private TextView tvConfirm;
    private String vcode;
    private String vcode2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvConfirm = findViewById(R.id.tvConfirm);
        tvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificationCodeView.setInputData("");
            }
        });

        verificationCodeView = findViewById(R.id.verificationCodeView);
        verificationCodeView.setOnVerificationCodeCompleteListener(new VerificationCodeView.OnVerificationCodeCompleteListener() {
            @Override
            public void verificationCodeComplete(String verificationCode) {
                vcode = verificationCode;
                Toast.makeText(MainActivity.this, "验证码: "+verificationCode, Toast.LENGTH_SHORT).show();
                tvConfirm.setBackgroundResource(R.color.orange);
            }

            @Override
            public void verificationCodeIncomplete(String verificationCode) {
                tvConfirm.setBackgroundResource(R.color.grey);
            }
        });

        verificationCodeView2 = findViewById(R.id.verificationCodeView2);
        verificationCodeView2.setOnVerificationCodeCompleteListener(new VerificationCodeView.OnVerificationCodeCompleteListener() {
            @Override
            public void verificationCodeComplete(String verificationCode) {
                vcode2 = verificationCode;
                Toast.makeText(MainActivity.this, "验证码2: "+verificationCode, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void verificationCodeIncomplete(String verificationCode) {
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("vcode",vcode);
        outState.putString("vcode2",vcode2);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        verificationCodeView.setInputData(savedInstanceState.getString("vcode"));
        verificationCodeView.setInputData(savedInstanceState.getString("vcode2"));
    }
}
