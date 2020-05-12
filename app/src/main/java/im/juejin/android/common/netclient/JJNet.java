package im.juejin.android.common.netclient;

import android.os.Environment;
import android.util.ArrayMap;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;

import im.juejin.android.common.ApplicationProvider;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class JJNet {


    public static JJNet INSTANCE = new JJNet();
    private static final String METHOD_CONNECT = "CONNECT";
    private static final String METHOD_DELETE = "DELETE";
    private static final String METHOD_GET = "GET";
    private static final String METHOD_HEAD = "HEAD";
    private static final String METHOD_OPTIONS = "OPTIONS";
    private static final String METHOD_POST = "POST";
    private static final String METHOD_PUT = "PUT";
    private static final String METHOD_TRACE = "TRACE";
    private OkHttpClient client;

    private JJNet() {
        super();
        this.client = new okhttp3.OkHttpClient.Builder().build();
    }

    public static JJNetBuilder delete(String arg2) {
        return new JJNetBuilder(arg2, METHOD_DELETE);
    }

    public static JJNetDownloadBuilder download(String arg1) {
        return new JJNetDownloadBuilder(arg1);
    }

    public static JJNetBuilder get(String arg2) {
        return new JJNetBuilder(arg2, METHOD_GET);
    }

    public OkHttpClient getClient() {
        return this.client;
    }

    public static JJNetBuilder post(String arg2) {
        return new JJNetBuilder(arg2, METHOD_POST);
    }

    public static JJNetBuilder put(String arg2) {
        return new JJNetBuilder(arg2, METHOD_PUT);
    }

    public void setClient(OkHttpClient client) {
        this.client = client;
    }

    public static JJNetBuilder upload(String arg2, String arg3, File arg4) {
        return new JJNetBuilder(arg2, METHOD_POST).addFile(arg3, arg4);
    }

    public static class JJNetDownloadBuilder {
        private String filePath;
        private final String url;

        JJNetDownloadBuilder(@Nullable String arg3) {
            super();
            this.url = arg3;
            this.filePath = ApplicationProvider.getApplication().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + System.currentTimeMillis();
        }

        public File executeDownload() throws Exception {
            File v1_2;
            Response response = JJNet.INSTANCE.getClient().newCall(new JJNetBuilder(this.url, "GET").getRequest()).execute();
            InputStream v1 = response.body().byteStream();
            try {
                v1_2 = this.inputStream2File(v1, this.filePath);
            } catch (Throwable v1_1) {
                response.body().close();
                throw v1_1;
            }

            response.body().close();
            return v1_2;
        }

        private File inputStream2File(InputStream arg5, String arg6) throws Exception {
            File v0 = new File(arg6);
            FileOutputStream v6 = new FileOutputStream(v0);
            byte[] v1 = new byte[0x800];
            while (true) {
                int v2 = arg5.read(v1);
                if (v2 == -1) {
                    break;
                }
                v6.write(v1, 0, v2);
            }
            v6.flush();
            arg5.close();
            v6.close();
            return v0;
        }

        public JJNetDownloadBuilder setFilePath(String arg1) {
            this.filePath = arg1;
            return this;
        }

    }

    public static class JJNetBuilder {
        private RequestBody _customBody;
        private Map _headers;
        private Map _multiParams;
        private Map _params;
        private String method;
        private String url;

        protected JJNetBuilder(@Nullable String arg2, @Nullable String arg3) {
            super();
            this._headers = new ArrayMap();
            this._params = new ArrayMap();
            this._multiParams = new ArrayMap();
            this.url = arg2;
            this.method = arg3;
        }

        static Request access$000(JJNetBuilder arg0) {
            return arg0.getRequest();
        }

        public JJNetBuilder addFile(String arg2, File arg3) {
            this._multiParams.put(arg2, arg3);
            return this;
        }

        public JJNetBuilder addHeader(String arg2, String arg3) {
            this._headers.put(arg2, arg3);
            return this;
        }

        public JJNetBuilder addHeaders(Map arg5) {
            if (arg5 == null) {
                return this;
            }

            Iterator v0 = arg5.keySet().iterator();
            while (v0.hasNext()) {
                Object v1 = v0.next();
                this._headers.put(v1, arg5.get(v1));
            }

            return this;
        }

        public JJNetBuilder addParam(String arg2, String arg3) {
            this._params.put(arg2, arg3);
            return this;
        }

        public JJNetBuilder addParams(Map arg5) {
            Iterator v0 = arg5.keySet().iterator();
            while (v0.hasNext()) {
                Object v1 = v0.next();
                this._params.put(v1, arg5.get(v1));
            }

            return this;
        }

        public String execute() throws Exception {
            return JJNet.INSTANCE.getClient().newCall(this.getRequest()).execute().body().string();
        }

        public Response executeResp() throws Exception {
            return JJNet.INSTANCE.getClient().newCall(this.getRequest()).execute();
        }

        private Request getRequest() {
            FormBody v1_4;
            Object v3;
            Iterator v2_1;
            Request.Builder v1_2;
            okhttp3.Request.Builder builder = new okhttp3.Request.Builder().url(this.url);

            return builder.build();
        }

        private boolean isCustomRequestBody() {
            return this._customBody != null;
        }

        private boolean isMultiPartRequest() {
            return this._multiParams.size() > 0;
        }

        public JJNetBuilder postByteArray(byte[] arg2) {
            this._customBody = RequestBody.create(MediaType.parse("application/octet-stream;tt-data=a"), arg2);
            return this;
        }

        public JJNetBuilder postJson(String arg2) {
            this._customBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), arg2);
            return this;
        }
    }

}
