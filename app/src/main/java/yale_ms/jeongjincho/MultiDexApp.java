package yale_ms.jeongjincho;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

/**
 * Created by KMS_DESKTOP on 2016-10-09.
 */

public class MultiDexApp extends MultiDexApplication {
    @Override
    public void onCreate(){
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base){
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
