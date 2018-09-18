package com.wuyanhua.vcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.wuyanhua.verificationcodeview.VerificationCodeView;

public class MainActivity extends AppCompatActivity {
    private VerificationCodeView verificationCodeView;
    private String vcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verificationCodeView = findViewById(R.id.verificationCodeView);
        verificationCodeView.setOnVerificationCodeCompleteListener(new VerificationCodeView.OnVerificationCodeCompleteListener() {
            @Override
            public void verificationCodeComplete(String verificationCode) {
                vcode = verificationCode;
                Toast.makeText(MainActivity.this, "验证码: "+verificationCode, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("vcode",vcode);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        verificationCodeView.setInputData(savedInstanceState.getString("vcode"));
    }
}
