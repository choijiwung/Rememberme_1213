package rememberme.io.rememberme.Network;


import rememberme.io.rememberme.Day.Results.DIndexResult;
import rememberme.io.rememberme.Trip.Results.TCreateResult;
import rememberme.io.rememberme.Trip.Results.TIndexResult;
import rememberme.io.rememberme.Trip.Results.TPageResult;
import rememberme.io.rememberme.Trip.Results.TShowResult;
import rememberme.io.rememberme.Trip.Results.TUpdateResult;
import rememberme.io.rememberme.Trip.Trip;
import rememberme.io.rememberme.User.Results.ULoginResult;
import rememberme.io.rememberme.User.Results.USignUpResult;
import rememberme.io.rememberme.User.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by samsung on 2017-12-08.
 */

public interface APINetwork {
// 라우터 부분
    @POST("/users/signin")
    Call<ULoginResult> getLoginResult(@Body User user);

    @POST("/users/signup")
    Call<USignUpResult> getSignUpResult(@Body User user);

//    Trip
    @GET("/trips")
    Call<TIndexResult> getTIndexResult(@Body Trip trip, @HEAD Token token);

    @GET("/trips/page/:page")
    Call<TPageResult> getTPageResult(@Body Trip trip);

    @GET("/trips/:id")
    Call<TShowResult> getTShowResult(@Body Trip trip);

    @POST("/trips")
    Call<TCreateResult> getTCreateResult(@Body Trip trip);

    @PUT("/trips/:id")
    Call<TUpdateResult> getTUpdateResult(@Body Trip trip);

    @DELETE("/trips/:id")
    Call<TDeleteResult> getTDeleteResult(@Body Trip trip)

//    Day
    @GET("/trips/:tid/days")
    Call<DIndexResult> getDIndexResult(@Body Trip trip, @HEAD Token token);

//    Spot
//    Photo

}
