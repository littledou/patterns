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
        Intrinsics.checkNotNullParameter(paramChain, "chain");
        Request request = paramChain.request();
        Request.Builder builder = request.newBuilder();
        String str1 = UserAction.INSTANCE.getCurrentUserId();
        String str2 = VerifyUtils.getClientId();
        String str3 = VerifyUtils.getLocalToken();
        try {
            if (Intrinsics.areEqual(request.url().host(), (new URI("https://android-api.juejin.im/graphql")).getHost())) {
                builder.addHeader("X-Legacy-Token", str3);
                builder.addHeader("X-Legacy-Uid", str1);
                builder.addHeader("X-Legacy-Device-Id", str2);
                builder.addHeader("X-Agent", SystemUtilsKt.getUA());
            } else {
                builder.addHeader("X-Juejin-Uid", str1);
                builder.addHeader("X-Juejin-Client", str2);
                builder.addHeader("X-Juejin-Token", str3);
                builder.addHeader("User-Agent", SystemUtilsKt.getUA());
                builder.addHeader("X-Juejin-Src", "android");
                builder.addHeader("X-Juejin-Suid", VerifyUtils.getLocalSuid());
                builder.addHeader("X-Token", str3);
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        RequestBody requestBody = request.body();
        if (requestBody instanceof FormBody) {
            FormBody.Builder builder1 = new FormBody.Builder();
            builder1.a("uid", str1);
            builder1.a("token", str3);
            builder1.a("device_id", str2);
            builder1.a("src", "android");
            int i = 0;
            FormBody formBody = (FormBody)requestBody;
            int j = formBody.a();
            while (i < j) {
                builder1.a(formBody.b(i), formBody.d(i));
                i++;
            }
            builder.a(request.b(), (RequestBody)builder1.a());
        } else {
            builder.a(request.b(), requestBody);
        }
        Response response = paramChain.a(builder.b());
        Intrinsics.a(response, "chain.proceed(builder.build())");
        return response;
    }
}
