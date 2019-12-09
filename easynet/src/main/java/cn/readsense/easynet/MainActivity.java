package cn.readsense.easynet;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import cn.readsense.threadpool.base.IThreadPool;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("StaticFieldLeak")
            @Override
            public void onClick(View v) {

                int i = 0;
                while (i < 100) {
                    IThreadPool.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Thread id: " + Thread.currentThread().getName());
                        }
                    });
                    i++;
                }

//                new AsyncTask<String, Object, String>() {
//                    @Override
//                    protected String doInBackground(String... strings) {
//                        String o = UCNHttp.get(strings[0]);
//
//                        try {
//                            JSONArray results = new JSONObject(o).getJSONArray("results");
//
//                            System.out.println("size: " + results.length() + o);
//
//                            for (int i = 0; i < results.length(); i++) {
//
//                                try {
//                                    HttpDownLoad.downLoad(
//                                            results.getJSONObject(i).getString("url")
//                                            , "/sdcard/img/");
//                                    System.out.println("download index " + i);
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                }
//
//
//                            }
//
//
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        return "0";
//                    }
//
//                    @Override
//                    protected void onPostExecute(String o) {
//                        System.out.println(o);
//                    }
//                }.execute("http://gank.io/api/data/福利/1000/1");


            }
        });


    }

}
