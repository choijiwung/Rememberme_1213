package rememberme.io.rememberme.User;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import rememberme.io.rememberme.MainActivity;
import rememberme.io.rememberme.Network.APINetwork;
import rememberme.io.rememberme.Network.ApplicationController;
import rememberme.io.rememberme.R;
import rememberme.io.rememberme.User.Results.ULoginResult;
import rememberme.io.rememberme.User.Results.TokenDatabase;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivty extends AppCompatActivity {
    APINetwork network;
    Button loginButton;
    Button SignupButton;
    EditText idText, passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        network = ApplicationController.getInstance().getApiNetwork();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        idText = (EditText)findViewById(R.id.etId);
        passwordText = (EditText)findViewById(R.id.etPassword);

        idText.setText("whdqhd5402@gmail.com");
        passwordText.setText("123123");

        loginButton = (Button) findViewById(R.id.btnLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View v) {
                String email = idText.getText().toString();
                String password = passwordText.getText().toString();
                Log.i("Sign", email.concat(" / ").concat(password));

                login(email, password);
            }
        });

        SignupButton = (Button) findViewById(R.id.btnSignup);
        SignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signupIntent = new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(signupIntent);
            }
        });

    }

    private void login(String email, String password) {
        User user = new User(email, password);
        Call<ULoginResult> LoginResultCall = network.getLoginResult(user);
        LoginResultCall.enqueue(new Callback<ULoginResult>() {
            @Override
            public void onResponse(Call<ULoginResult> call, Response<ULoginResult> response) {
                if(response.isSuccessful()) {
                    ULoginResult ULoginResult = response.body();
                    Log.i("Sign", "Login Success / msg : ".concat(ULoginResult.msg).concat(", token : ".concat(ULoginResult.token)));

                    // 받은 토큰 디비에 저장 저장 - 동우
                    TokenDatabase tokenDatabase = new TokenDatabase();
                    tokenDatabase.openDatabase();
                    tokenDatabase.createTable();
                    tokenDatabase.insertToken(ULoginResult.token.toString().trim());
                    tokenDatabase.selectToken(ULoginResult.token.toString().trim());

                    Intent loginIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(loginIntent);
                    finish();
                } else {
                    Toast.makeText(LoginActivty.this, "아이디와 비밀번호를 확인해 주세요.", Toast.LENGTH_SHORT).show();
                    Log.i("Sign", "code : " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ULoginResult> call, Throwable t) {
                Log.i("Sign", t.getMessage());
            }
        });
    }

}
