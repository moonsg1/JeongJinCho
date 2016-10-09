package yale_ms.jeongjincho;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.fingerpush.android.FingerPushManager;
import com.fingerpush.android.NetworkUtility;

import org.json.JSONObject;

/**
 * Created by KMS_DESKTOP on 2016-09-25.
 */

public class FingerPushHelper {
    private static final String TAG = "FINGER PUSH";
    private Context m_context;

    public FingerPushHelper() {
    }

    public void setDeviceForPush(Context context)
    {
        m_context = context;

        FingerPushManager.getInstance(context).setDevice(new NetworkUtility.ObjectListener() {
            @Override
            public void onComplete(String code, String message, JSONObject jsonObject) {
                if(code.equals("200") || code.equals("201")) {
                    // 디바이스 최초 등록시 해당 코드 리턴
                    Log.d(TAG , "onComplete ::: code:" + code + ", message:" + message);
                }
            }
            @Override
            public void onError(String code, String message) {
                if(code.equals("504")) {
                    // 디바이스가 이미 등록된 경우 해당 코드 리턴
                    Log.d(TAG , "onComplete ::: code:" + code + ", message:" + message);
                }
            }
        });
    }

    // @TODO 사용법 파악 필요
    public void checkPush(String msg_id, String msg_mode)
    {
        FingerPushManager.getInstance(m_context).checkPush(
                msg_id, // 푸시 메시지 번호 msgTag
                msg_mode, // 푸시 메시지 모드 mode
                "", // labelCod
                new NetworkUtility.ObjectListener() {
                    @Override
                    public void onComplete(String code, String message, JSONObject jsonObject) {
                        if (code.equals("200") || code.equals("201")) {
                            // 디바이스 최초 등록시 해당 코드 리턴
                            Log.d(TAG, "onComplete ::: code:" + code + ", message:" + message);
                        }
                    }
                    @Override
                    public void onError(String code, String message) {
                        if(code.equals("504")) {
                            // 디바이스가 이미 등록된 경우 해당 코드 리턴
                            Log.d(TAG , "onComplete ::: code:" + code + ", message:" + message);
                        }
                    }
                }
        );

    }
}
