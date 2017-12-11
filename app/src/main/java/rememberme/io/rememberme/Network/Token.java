package rememberme.io.rememberme.Network;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by JW on 2017-12-10.
 */

public class Token {
    Context context;
    public Token(Context context){
        this.context = context;
    }

    public String getKey() {
        SharedPreferences sharedPreferences = ((Activity)context).getSharedPreferences("token", Context.MODE_PRIVATE);
        return sharedPreferences.getString("key", null);
    }

    public void setKey(String key) {
        SharedPreferences sharedPreferences = ((Activity)context).getSharedPreferences("token", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("key", key);
        editor.commit();


    }
}
