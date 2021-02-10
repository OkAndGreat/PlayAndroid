package com.example.playandroid.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.playandroid.R;
import com.example.playandroid.base.BaseActivity;
import com.example.playandroid.model.API;
import com.example.playandroid.model.bean.RegisterBean;
import com.example.playandroid.utils.RetrofitManger;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private ImageView mIvRegisterClose;
    private TextInputLayout mUserRegInputLayout;
    private TextInputLayout mPasswordRegInputLayout;
    private TextInputLayout mRepasswordRegInputLayout;
    private Button mBtnRegister;
    private TextView mTvLoginGoLogin;
    private String mUserName;
    private String mPassWord;
    private String mRePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initListener();
    }

    private void initView() {
        mIvRegisterClose = (ImageView) findViewById(R.id.iv_register_close);
        mUserRegInputLayout = (TextInputLayout) findViewById(R.id.userRegInputLayout);
        mPasswordRegInputLayout = (TextInputLayout) findViewById(R.id.passwordRegInputLayout);
        mRepasswordRegInputLayout = (TextInputLayout) findViewById(R.id.repasswordRegInputLayout);
        mBtnRegister = (Button) findViewById(R.id.btn_register);
        mTvLoginGoLogin = (TextView) findViewById(R.id.tv_login_gologin);
    }

    private void initListener() {
        mIvRegisterClose.setOnClickListener(this);
        mBtnRegister.setOnClickListener(this);
        mTvLoginGoLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id==R.id.iv_register_close) {
            onBackPressed();
        }else if(id==R.id.btn_register){
            API api = RetrofitManger.getInstance().createMainRetrofit().create(API.class);
            api.postRegData(mUserRegInputLayout.getEditText().toString(),mPasswordRegInputLayout.getEditText().getText().toString(),mRepasswordRegInputLayout.getEditText().getText().toString()).enqueue(new Callback<RegisterBean>() {
                @Override
                public void onResponse(Call<RegisterBean> call, Response<RegisterBean> response) {
                    if(response.body().getErrorCode()==0){
                        //注册成功
                        Intent intent = new Intent();
                        intent.putExtra("username",mUserRegInputLayout.getEditText().getText().toString());
                        intent.putExtra("password",mPasswordRegInputLayout.getEditText().getText().toString());
                        setResult(RESULT_OK,intent);
                        finish();
                    }else{
                        String errorMsg = response.body().getErrorMsg();
                        Toast.makeText(getApplicationContext(),errorMsg,Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<RegisterBean> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),"网络可能出问题了哦~",Toast.LENGTH_LONG).show();
                }
            });
        }
        else if(id==R.id.tv_login_gologin){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }
}