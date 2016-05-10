package com.app.yoga.yogaapplication.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.app.yoga.yogaapplication.utils.PrefUtils;
import com.app.yoga.yogaapplication.R;
import com.app.yoga.yogaapplication.objects.User;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;


public class LoginMainActivity extends AppCompatActivity implements View.OnClickListener {

    private CallbackManager callbackManager;
    private LoginButton loginButton;
    private ImageButton imgFacebookLogin;
    private ProgressDialog progressDialog;
    User user;
    private ImageButton imgEmailBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        if(PrefUtils.getCurrentUser(LoginMainActivity.this) != null){
            Intent homeIntent = new Intent(LoginMainActivity.this, MainActivity.class);
            startActivity(homeIntent);
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        callbackManager= CallbackManager.Factory.create();

        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("public_profile", "email", "user_friends");

        imgFacebookLogin = (ImageButton) findViewById(R.id.image_facebook_btn);
        imgFacebookLogin.setOnClickListener(this);

        imgEmailBtn = (ImageButton) findViewById(R.id.image_email_btn);
        imgEmailBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.image_facebook_btn:
                progressDialog = new ProgressDialog(LoginMainActivity.this);
                progressDialog.setMessage("Loading...");
                progressDialog.show();

                loginButton.performClick();
                loginButton.setPressed(true);
                loginButton.invalidate();

                loginButton.registerCallback(callbackManager,mCallback);

                break;
            case R.id.image_email_btn:
                Intent intent = new Intent(LoginMainActivity.this, LoginSecondActivity.class);
                startActivity(intent);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }

    private FacebookCallback<LoginResult> mCallback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            progressDialog.dismiss();

            GraphRequest request = GraphRequest.newMeRequest(
                    loginResult.getAccessToken(),
                    new GraphRequest.GraphJSONObjectCallback(){

                        @Override
                        public void onCompleted(
                                JSONObject object,
                                GraphResponse response) {

                            Log.e("response: ", response + "");
                            try{
                                user = new User();
                                user.setFacebookID(object.getString("id").toString());
                                user.setEmail(object.getString("email").toString());
                                user.setName(object.getString("name").toString());
                                user.setGender(object.getString("gender").toString());
                                PrefUtils.setCurrentUser(user, LoginMainActivity.this);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            Toast.makeText(LoginMainActivity.this,"welcome "+ user.getName(),Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LoginMainActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
            );


            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,email,gender, birthday");
            request.setParameters(parameters);
            request.executeAsync();
        }

        @Override
        public void onCancel() {
            progressDialog.dismiss();
        }

        @Override
        public void onError(FacebookException error) {
            progressDialog.dismiss();
        }
    };
}
