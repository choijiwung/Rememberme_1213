package rememberme.io.rememberme.Network;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by JW on 2017-12-10.
 */

public class Token extends AppCompatActivity {

    public String getKey() {
        SharedPreferences sharedPreferences = getSharedPreferences("token", Context.MODE_PRIVATE);
        return sharedPreferences.getString("key", null);
    }

    public void setKey(String key) {
        SharedPreferences sharedPreferences = getSharedPreferences("token", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("key", key);

    }
}
