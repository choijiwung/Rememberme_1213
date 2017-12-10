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

import rememberme.io.rememberme.Network.APINetwork;
import rememberme.io.rememberme.R;
import rememberme.io.rememberme.User.Results.SignUpResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    APINetwork network;
    EditText etName,etEmail,etPassword,etPasswordConfirm;
    Button signCompleteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_signup);
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPasswordConfirm = (EditText)findViewById(R.id.etPasswordConfirm);

        signCompleteButton = (Button) findViewById(R.id.btnSignup);



        signCompleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String passwordConfirm = etPasswordConfirm.getText().toString();

                Log.i("Sign", name.concat(" / ").concat(email).concat(" / ").concat(password).concat(" / ").concat(passwordConfirm));

                signup(name,email,password,passwordConfirm);

            }
        });

    }

    private void signup(String name, String email, String password, String passwordConfirm) {
        User user = new User(name,email,password,passwordConfirm);
        Call<SignUpResult> SignupResultCall = network.getSignUpResult(user);
        SignupResultCall.enqueue(new Callback<SignUpResult>() {
            @Override
            public void onResponse(Call<SignUpResult> call, Response<SignUpResult> response) {
                if (response.isSuccessful()) {
                    SignUpResult signupResult = response.body();
                    Log.i("Sign", "Login Success / msg:".concat(signupResult.msg));

                    Intent signComplete = new Intent(getApplicationContext(), LoginActivty.class);
                    startActivity(signComplete);
                } else {
                    Toast.makeText(SignupActivity.this, "아이디와 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();
                    Log.i("Sign", "code :" + response.code());
                }
            }

            @Override
            public void onFailure(Call<SignUpResult> call, Throwable t) {
                Log.i("Sign", t.getMessage());
            }
        });



    }
}
