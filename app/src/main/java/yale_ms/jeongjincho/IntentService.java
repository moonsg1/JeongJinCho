package yale_ms.jeongjincho;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.fingerpush.android.FingerNotification;
import com.fingerpush.android.FingerPushListener;

/**
 * Created by KMS_DESKTOP on 2016-09-25.
 */

public class IntentService extends FingerPushListener {
    private static final String TAG = "IntentService";

    @Override
    public void onMessage(Context context, Bundle data) {

        for (String key : data.keySet()) {
            String value = data.get(key).toString();
            Log.d(TAG, "onMessage ::: key:" + key + ", value:" + value);
        }

        try {
            setNotification(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setNotification(final Bundle data) {

        Intent intent = new Intent(IntentService.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        PendingIntent pi = PendingIntent.getActivity(IntentService.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        FingerNotification noti = new FingerNotification(IntentService.this);
        noti.setColor(Color.RED);
        noti.setNofiticaionIdentifier((int) System.currentTimeMillis());
        noti.showNotification(data, pi);
    }

}
