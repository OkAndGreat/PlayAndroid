package com.example.playandroid.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.playandroid.R;
import com.example.playandroid.base.BaseActivity;
import com.example.playandroid.model.API;
import com.example.playandroid.model.bean.LoginBean;
import com.example.playandroid.utils.LogUtil;
import com.example.playandroid.utils.RetrofitManger;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "LoginActivity";
    private TextInputLayout mUserLoginInputLayout;
    private TextInputLayout mPasswordLoginInputLayout;
    private Button mBtnLogin;
    private TextView mTvLoginGoRegister;
    private ImageView mIvLoginClose;
    private EditText mEtLoginUsername;
    private EditText mEtLoginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initListener();
    }

    private void initListener() {
        mIvLoginClose.setOnClickListener(this);
        mTvLoginGoRegister.setOnClickListener(this);
        mBtnLogin.setOnClickListener(this);

    }

    private void initView() {
        mUserLoginInputLayout = (TextInputLayout) findViewById(R.id.userLoginInputLayout);
        mPasswordLoginInputLayout = (TextInputLayout) findViewById(R.id.passwordLoginInputLayout);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mTvLoginGoRegister = (TextView) findViewById(R.id.tv_login_goRegister);
        mIvLoginClose = (ImageView) findViewById(R.id.iv_login_close);
        mEtLoginUsername = (EditText) findViewById(R.id.et_login_username);
        mEtLoginPassword = (EditText) findViewById(R.id.et_login_password);

    }

    /**
     * 根据stackOverflow上大佬所说,这里要用if else不能用switch(写这个项目写到一半才发现,前面都用switch了这里开始用if else):
     * In a regular Android project, constants in the resource R class are declared like this: public static final int main=0x7f030004;
     * <p>
     * However, as of ADT 14, in a library project, they will be declared like this: public static int main=0x7f030004;
     * <p>
     * In other words, the constants are not final in a library project. The reason for this is simple: When multiple library projects are combined, the actual values of the fields (which must be unique) could collide. Before ADT 14, all fields were final, so as a result, all libraries had to have all their resources and associated Java code recompiled along with the main project whenever they were used. This was bad for performance, since it made builds very slow. It also prevented distributing library projects that didn't include the source code, limiting the usage scope of library projects.
     * <p>
     * The reason the fields are no longer final is that it means that the library jars can be compiled once and reused directly in other projects. As well as allowing distributing binary version of library projects (coming in r15), this makes for much faster builds.
     *
     * @param v 被点击的控件
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.iv_login_close) {
            finish();
        } else if (id == R.id.tv_login_goRegister) {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivityForResult(intent, 1);
        } else if (id == R.id.btn_login) {
            Call<LoginBean> loginBeanCall = RetrofitManger.getInstance().createMainRetrofit().create(API.class).postLoginData(mUserLoginInputLayout.getEditText().getText().toString(), mPasswordLoginInputLayout.getEditText().getText().toString());
            loginBeanCall.enqueue(new Callback<LoginBean>() {
                @Override
                public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                    Integer errorCode = response.body().getErrorCode();
                    if (errorCode == 0) {
                        MainActivity.setLogin(true);
                        Intent intent = new Intent();
                        intent.putExtra("id",response.body().getData().getId());
                        intent.putExtra("username",response.body().getData().getUsername());
                        setResult(RESULT_OK, intent);
                        Toast.makeText(LoginActivity.this,"登陆成功!",Toast.LENGTH_LONG).show();
                        finish();
                    } else {
                        String errorMsg = response.body().getErrorMsg();
                        Toast.makeText(getApplicationContext(), errorMsg, Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginBean> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "网络可能出问题了哦~", Toast.LENGTH_LONG).show();
                }
            });

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String username = data.getStringExtra("username");
                    String password = data.getStringExtra("password");
                    mEtLoginUsername.setText(username);
                    mEtLoginPassword.setText(password);
                    LogUtil.d(TAG, "username--->" + username + "password-->" + password);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + requestCode);
        }
    }
}