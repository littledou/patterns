package cn.readsense.easynet.okhttp;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Sample {

    public static void main(String[] args) {

    }

    static void get() {
        OkHttpClient client = new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();

        Request request = new Request.Builder().url("").build();

        try {
            final Call call = client.newCall(request);
            Response response = call.execute();
            call.enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {

                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void post() {
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(MediaType.get("application/json; charset=utf-8"), "");

        Request request = new Request.Builder().url("").post(body).build();

        try {
            final Call call = client.newCall(request);
            final Response response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
