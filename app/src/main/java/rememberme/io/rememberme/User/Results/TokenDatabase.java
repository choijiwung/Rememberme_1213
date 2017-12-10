package rememberme.io.rememberme.User.Results;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


/**
 * Created by samsung on 2017-12-10.
 */

public class TokenDatabase extends AppCompatActivity{

    String tableName = "tokenTable";

    SQLiteDatabase db;

    //database 생성
//    public void openDatabase(String dbName) {
//        db = openOrCreateDatabase(dbName,CODEnull);
//            //db = openOrCreateDatabase(dbName,  null);
//            Log.d("DB","데이터베이스 생성됨");
//    }

    // 테이블 생성하기
    public void createTable() {
        if (db != null) {
            String sql = "create table if not exists " + tableName + " (token text)";
            db.execSQL(sql);
        }
    }

    // token 삽입
    // insertToken(String token)를 통해 매개변수값으로 받은 token을 삽입
    public void insertToken(String token) {
            String sql = "insert into " +  tableName + " (token) values(" + token.trim() + ")";
            db.execSQL(sql);

    }

    // token 조회
    // 매개변수값으로 받은 token으로 조회
    public void selectToken(String token) {
        if (db != null) {
            String sql = "select token from "  + tableName + " where token = " + token.trim();
            Cursor selectToken = db.rawQuery(sql, null); // 조회된 토큰이 Cursor 객체로 리턴됨.

            for (int i = 0; i < selectToken.getCount(); i++) {
                selectToken.moveToNext();
                String receviedToken = selectToken.getString(0);
                Toast.makeText(getApplicationContext(), receviedToken, Toast.LENGTH_LONG).show();
            }
        }
    }


    //token 업데이트
    //매개변수 oldToken, String newToken 값을  통해 oldToken => newToken으로 갱신
    public void updateToken(String oldToken, String newToken) {
        if (db != null) {
            String sql = "update tokenTable set " + oldToken.trim()+"="+newToken.trim() + " where token = " + oldToken.trim();
            db.execSQL(sql);
        } else{
            //println("데이터베이스를 먼저 오픈하세요");
        }
    }

    // token 삭제
    //deleteToken(String token)를 통해 매개변수값으로 받은 token 삭제
    public void deleteToken(String token) {
        if (db != null) {
            String sql = "delete from tokenTable where token = " + token.trim();
            db.execSQL(sql);
        } else{
            //println("데이터베이스를 먼저 오픈하세요");
        }
    }
}
