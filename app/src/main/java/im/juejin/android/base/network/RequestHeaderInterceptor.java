package im.juejin.android.base.network;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import im.juejin.android.base.action.UserAction;
import im.juejin.android.base.utils.SystemUtilsKt;
import im.juejin.android.base.utils.VerifyUtils;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RequestHeaderInterceptor implements Interceptor {

    public Response intercept(Interceptor.Chain paramChain) throws IOException {
        Intrinsics.checkNotNull(paramChain, "chain");
        Request request = paramChain.request();
        Request.Builder builder = request.newBuilder();
        String currentUserId = UserAction.INSTANCE.getCurrentUserId();
        String clientId = VerifyUtils.getClientId();
        String localToken = VerifyUtils.getLocalToken();
        String android_tag = "android";
        try {
            if (Intrinsics.areEqual(request.url().host(), new URI("https://android-api.juejin.im/graphql").getHost())) {
                builder.addHeader("X-Legacy-Token", localToken);
                builder.addHeader("X-Legacy-Uid", currentUserId);
                builder.addHeader("X-Legacy-Device-Id", clientId);
                builder.addHeader("X-Agent", SystemUtilsKt.getUA());
            } else {
                builder.addHeader("X-Juejin-Uid", currentUserId);
                builder.addHeader("X-Juejin-Client", clientId);
                builder.addHeader("X-Juejin-Token", localToken);
                builder.addHeader("User-Agent", SystemUtilsKt.getUA());
                builder.addHeader("X-Juejin-Src", android_tag);
                builder.addHeader("X-Juejin-Suid", VerifyUtils.getLocalSuid());
                builder.addHeader("X-Token", localToken);
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        RequestBody requestBody = request.body();
        if ((requestBody instanceof FormBody)) {
            FormBody.Builder formbodyBuilder = new FormBody.Builder();
            formbodyBuilder.add("uid", currentUserId);
            formbodyBuilder.add("token", localToken);
            formbodyBuilder.add("device_id", clientId);
            formbodyBuilder.add("src", android_tag);
            int v2_1 = 0;
            int v3_1 = ((FormBody) requestBody).size();
            while (v2_1 < v3_1) {
                formbodyBuilder.add(((FormBody) requestBody).name(v2_1), ((FormBody) requestBody).value(v2_1));
                ++v2_1;
            }

            builder.method(request.method(), formbodyBuilder.build());
        } else {
            builder.method(request.method(), requestBody);
        }

        Response response = paramChain.proceed(builder.build());
        Intrinsics.checkFieldIsNotNull(response, "chain.proceed(builder.build())");
        return response;
    }
}
