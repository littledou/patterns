package cn.readsense.threadpool.base;

import android.os.AsyncTask;

public class AsyncTaskTest {


    public static void test() {

        MyTask myTask = new MyTask();
        myTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }


    static class MyTask extends AsyncTask<Object, Object, Object> {

        public MyTask() {
            super();
            System.out.println("Constructor " + Thread.currentThread().getName());
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            System.out.println("onPreExecute " + Thread.currentThread().getName());
        }


        @Override
        protected Object doInBackground(Object[] objects) {
            System.out.println("doInBackground " + Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }


        @Override
        protected void onProgressUpdate(Object... values) {
            super.onProgressUpdate(values);
            System.out.println("onProgressUpdate " + Thread.currentThread().getName());
        }


        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            System.out.println("onPostExecute " + Thread.currentThread().getName());
        }


        @Override
        protected void onCancelled() {
            super.onCancelled();
            System.out.println("onCancelled " + Thread.currentThread().getName());
        }
    }


}
