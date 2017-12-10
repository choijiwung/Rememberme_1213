package rememberme.io.rememberme.Network;


import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import rememberme.io.rememberme.Day.Day;
import rememberme.io.rememberme.Day.Results.DCreateResult;
import rememberme.io.rememberme.Day.Results.DDeleteResult;
import rememberme.io.rememberme.Day.Results.DIndexResult;
import rememberme.io.rememberme.Day.Results.DShowResult;
import rememberme.io.rememberme.Day.Results.DUpdateResult;
import rememberme.io.rememberme.Spot.Results.SCreateResult;
import rememberme.io.rememberme.Spot.Results.SDeleteResult;
import rememberme.io.rememberme.Spot.Results.SIndexResult;
import rememberme.io.rememberme.Spot.Results.SPageResult;
import rememberme.io.rememberme.Spot.Results.SShowResult;
import rememberme.io.rememberme.Spot.Results.SUpdateResult;
import rememberme.io.rememberme.Spot.Spot;
import rememberme.io.rememberme.Trip.Results.TCreateResult;
import rememberme.io.rememberme.Trip.Results.TDeleteResult;
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
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by samsung on 2017-12-08.
 */

public interface APINetwork {
// 라우터 부분
    // User
    @POST("/users/signin")
    Call<ULoginResult> getLoginResult(@Body User user);

    @POST("/users/signup")
    Call<USignUpResult> getSignUpResult(@Body User user);

//    Trip
    @GET("/trips")
    Call<TIndexResult> getTIndexResult(@Header("token") String token);

    @GET("/trips/page/{page}")
    Call<TPageResult> getTPageResult(@Header("token") String token, @Path("page") int page);

    @POST("/trips")
    Call<TCreateResult> getTCreateResult(@Header("token") String token, @Body Trip trip);

    @GET("/trips/{tid}")
    Call<TShowResult> getTShowResult(@Header("token") String token, @Path("tid") int tid);

    @PUT("/trips/{tid}")
    Call<TUpdateResult> getTUpdateResult(@Header("token") String token, @Body Trip trip, @Path("tid") int tid);

    @DELETE("/trips/{tid}")
    Call<TDeleteResult> getTDeleteResult(@Header("token") String token, @Path("tid") int tid);

//    Day
    @GET("/trips/{tid}/days")
    Call<DIndexResult> getDIndexResult(@Header("token") String token, @Path("tid") int tid);

    @POST("/trips/{tid}/days")
    Call<DCreateResult> getDCreateResult(@Header("token") String token, @Body Day day, @Path("tid") int tid);

    @GET("/trips/days/{did}")
    Call<DShowResult> getDShowResult(@Header("token") String token, @Path("did") int did);

    @PUT("/days/{did}")
    Call<DUpdateResult> getDUpdateResult(@Header("token") String token, @Body Day day, @Path("did") int did);

    @DELETE("/days/{did}")
    Call<DDeleteResult> getDDeleteResult(@Header("token") String token, @Path("did") int did);
    
//    Spot
    @GET("/trips/{tid}/days/{did}/spots")
    Call<SIndexResult> getSIndexResult(@Header("token") String token, @Path("tid") int tid,@Path("did") int did);

    @GET("/trips/{tid}/days/{did}/spots/page/{page}")
    Call<SPageResult> getSPageResult(@Header("token") String token, @Path("tid") int tid, @Path("did") int did, @Path("page") int page);

    @POST("/trips/{tid}/days/{did}/spots")
    Call<SCreateResult> getSCreateResult(@Header("token") String token, @Body Spot spot, @Path("tid") int tid, @Path("did") int did);

    @GET("/trips/spots/{sid}")
    Call<SShowResult> getSShowResult(@Header("token") String token, @Path("sid") int sid);

    @PUT("/trips/spots/{sid}")
    Call<SUpdateResult> getSUpdateResult(@Header("token") String token, @Body Spot spot, @Path("sid") int sid);

    @DELETE("/trips/spots/{sid}")
    Call<SDeleteResult> getSDeleteResult(@Header("token") String token, @Path("sid") int sid);

//    Photo
    @Multipart
    @POST("/")
    Call<ResponseBody> postImage(@Part MultipartBody.Part image, @Part("name") RequestBody name);

}
