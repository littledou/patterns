package cn.readsense.servicetest

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        var mCalcAidl: CalcManage? = null
        fun llog(str: String) {
            println("activity: $str")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, CacluService::class.java)
//        intent.component = ComponentName("cn.readsense.servicetest", "cn.readsense.servicetest.ManualCalculatorService")

        var conn = object : ServiceConnection {
            override fun onServiceDisconnected(name: ComponentName?) {
                llog("onServiceDisconnected")
                mCalcAidl = null
            }

            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                llog("servicetest running")
                mCalcAidl = CalcManage.Stub.asInterface(service)
            }
        }

        Thread(Runnable {
            bindService(intent, conn, Context.BIND_AUTO_CREATE)

            Thread.sleep(1000)
            llog("2+6 = ${mCalcAidl?.plus(2, 6)}")
            llog("6-2 = ${mCalcAidl?.min(6, 2)}")
            Thread.sleep(1000)
            unbindService(conn)
            Thread.sleep(1000)
            llog("2+6 = ${mCalcAidl?.plus(2, 6)}")
            llog("6-2 = ${mCalcAidl?.min(6, 2)}")


        }).start()


    }

    /***
     * Android L (lollipop, API 21) introduced a new problem when trying to invoke implicit intent,
     * "java.lang.IllegalArgumentException: Service Intent must be explicit"
     *
     * If you are using an implicit intent, and know only 1 target would answer this intent,
     * This method will help you turn the implicit intent into the explicit form.
     *
     * Inspired from SO answer: http://stackoverflow.com/a/26318757/1446466
     * Intent intent = new Intent();
     *   intent.setAction("com.xiasuhuei321.forjianshu.calc");
     *
     *   // 在5.0以上隐式启动绑定service会抛异常
     *   final Intent i = new Intent(createExplicitFromImplicitIntent(this,intent));
     *   bindService(i, mServiceConn, Context.BIND_AUTO_CREATE);
     *
     * @param context
     * @param implicitIntent - The original implicit intent
     * @return Explicit Intent created from the implicit original intent
     */
//    public static Intent createExplicitFromImplicitIntent(Context context, Intent implicitIntent) {
//        // Retrieve all services that can match the given intent
//        PackageManager pm = context.getPackageManager();
//        List<ResolveInfo> resolveInfo = pm.queryIntentServices(implicitIntent, 0);
//
//        // Make sure only one match was found
//        if (resolveInfo == null || resolveInfo.size() != 1) {
//            return null;
//        }
//
//        // Get component info and create ComponentName
//        ResolveInfo serviceInfo = resolveInfo.get(0);
//        String packageName = serviceInfo.serviceInfo.packageName;
//        String className = serviceInfo.serviceInfo.name;
//        ComponentName component = new ComponentName(packageName, className);
//
//        // Create a new intent. Use the old one for extras and such reuse
//        Intent explicitIntent = new Intent(implicitIntent);
//
//        // Set the component to be explicit
//        explicitIntent.setComponent(component);
//
//        return explicitIntent;
//    }


}
