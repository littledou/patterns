package im.juejin.android.base.network;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.internal.platform.Platform;

public class HttpLoggingInterceptor implements Interceptor {
    public enum Level {
        BASIC, BODY, HEADERS, NONE
    }

    public interface Logger {
        public static final Logger DEFAULT = new LoggeerImpl();

        void log(String arg1);

        final class LoggeerImpl implements Logger {

            @Override
            public void log(String arg1) {
                Platform.get().log(4, arg1, null);
            }
        }
    }

    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile Level level;
    private final Logger logger;


    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    public HttpLoggingInterceptor(Logger logger) {
        super();
        this.level = Level.NONE;
        this.logger = logger;
    }

    private boolean bodyHasUnknownEncoding(Headers headers) {
        String v2 = headers.get("Content-Encoding");
        return v2 != null && (!v2.equalsIgnoreCase("identity")) && (!v2.equalsIgnoreCase("gzip"));
    }

    public Level getLevel() {
        return this.level;
    }

    public HttpLoggingInterceptor setLevel(Level arg2) {
        if (arg2 != null) {
            this.level = arg2;
            return this;
        }
        throw new NullPointerException("level == null. Use Level.NONE instead.");
    }

    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        //TODO impl HttpLoggingInterceptor intercept
        return null;
    }


}
