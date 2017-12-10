package rememberme.io.rememberme.User.Results;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by samsung on 2017-12-10.
 */

public class TokenDatabase extends AppCompatActivity {
    SQLiteDatabase tokenDatabase;

    //database 생성
    public void openDatabase() {
        String databaseName = "tokenDatabase";
        SQLiteDatabase tokenDatabase = openOrCreateDatabase(databaseName, Context.MODE_PRIVATE, null);
        if (tokenDatabase != null) {
            //println("데이터베이스 오픈됨");
        }
    }

    // 테이블 생성하기
    public void createTable() {
        String tokenTable = "tokenTable";
        if (tokenDatabase != null) {
            String sql = "create table if not exists " + tokenTable + " (token text)";
            tokenDatabase.execSQL(sql);
        }
    }

    // token 삽입
    // insertToken(String token)를 통해 매개변수값으로 받은 token을 삽입
    public void insertToken(String token) {
        if (tokenDatabase != null) {
            String sql = "insert into tokenTable (token) values(" + token.trim() + ")";
            tokenDatabase.execSQL(sql);
        } else{
            //println("데이터베이스를 먼저 오픈하세요");
        }
    }

    // token 조회
    // 매개변수값으로 받은 token으로 조회
    public void selectToken(String token) {
        if (tokenDatabase != null) {
            String sql = "select token from tokenTable where token = " + token.trim();
            Cursor selectToken = tokenDatabase.rawQuery(sql,null); // 조회된 토큰이 Cursor 객체로 리턴됨.
        } else{
            //println("데이터베이스를 먼저 오픈하세요");
        }
    }

    //token 업데이트
    //매개변수 oldToken, String newToken 값을  통해 oldToken => newToken으로 갱신
    public void updateToken(String oldToken, String newToken) {
        if (tokenDatabase != null) {
            String sql = "update tokenTable set " + oldToken.trim()+"="+newToken.trim() + " where token = " + oldToken.trim();
            tokenDatabase.execSQL(sql);
        } else{
            //println("데이터베이스를 먼저 오픈하세요");
        }
    }

    // token 삭제
    //deleteToken(String token)를 통해 매개변수값으로 받은 token 삭제
    public void deleteToken(String token) {
        if (tokenDatabase != null) {
            String sql = "delete from tokenTable where token = " + token.trim();
            tokenDatabase.execSQL(sql);
        } else{
            //println("데이터베이스를 먼저 오픈하세요");
        }
    }
}
