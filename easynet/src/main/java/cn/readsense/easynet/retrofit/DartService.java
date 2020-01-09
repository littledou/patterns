package cn.readsense.easynet.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DartService {

    @GET("users/{user}")
    Call<ResponseBody> getMsg(@Path("user") String user);


}
