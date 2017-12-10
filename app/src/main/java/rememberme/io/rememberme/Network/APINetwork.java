package rememberme.io.rememberme.Network;


import rememberme.io.rememberme.User.Results.LoginResult;
import rememberme.io.rememberme.User.Results.SignUpResult;
import rememberme.io.rememberme.User.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by samsung on 2017-12-08.
 */

public interface APINetwork {
// 라우터 부분
    @POST("/users/signin")
    Call<LoginResult> getLoginResult(@Body User user);

    @POST("/users/signup")
    Call<SignUpResult> getSignUpResult(@Body User user);

}
