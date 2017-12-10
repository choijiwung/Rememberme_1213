package rememberme.io.rememberme.User;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

        idText = (EditText) findViewById(R.id.etId);
        passwordText = (EditText) findViewById(R.id.etPassword);

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

                Intent signupIntent = new Intent(getApplicationContext(), SignupActivity.class);
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
                if (response.isSuccessful()) {
                    ULoginResult ULoginResult = response.body();
                    Log.i("Sign", "Login Success / msg : ".concat(ULoginResult.msg).concat(", token : ".concat(ULoginResult.token)));

                    //DB에 토큰값 받기
                    openDatabase("token.db");
                    createTable();
                    //insertData(ULoginResult.token.toString().trim());
                    //selectData();


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


    // DB 관리하기 위한 메소드
    String tableName = "tokenTable";
    SQLiteDatabase db;

    public void openDatabase(String dbName) {
        db = openOrCreateDatabase(dbName, MODE_PRIVATE, null);
        if (db != null) {
            Log.d("DB", "DB오픈됨");
        }
    }


    public void createTable() {
        if (db != null) {
            String sql = "create table if not exists " + tableName + " (token text) ";
            db.execSQL(sql);
            Log.d("DB", "테이블 생성됨");
        } else {
            Log.d("DB", "DB를 먼저 오픈하세요");
        }
    }

    public void insertData(String token) {
        if (db != null) {
            String sql = "insert into " + tableName + "(token) values(" + token + ")";
            db.execSQL(sql);
            Log.d("DB", "DB에 추가함");
        } else {
            Log.d("DB", "DB 생성이 안됨");
        }
    }

    public void selectData() {
        if (db != null) {
            String sql = "select token from " + tableName; //" where token = " + token.trim();
            Cursor selectToken = db.rawQuery(sql, null); // 조회된 토큰이 Cursor 객체로 리턴됨.

            for (int i = 0; i < selectToken.getCount(); i++) {
                selectToken.moveToNext();
                String receviedToken = selectToken.getString(0);
                Log.d("DB", receviedToken);
            }
        }
    }
}


