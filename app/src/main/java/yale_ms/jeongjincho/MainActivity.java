package yale_ms.jeongjincho;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView m_webView;
    private FingerPushHelper m_fingerPushHelper;
    private BackPressCloseHandler m_backPressCloseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // back key handler
        m_backPressCloseHandler = new BackPressCloseHandler(this);

        // webView 설정
        m_webView = (WebView)findViewById(R.id.web_view);
        setWebView();

        // finger push 등록
        m_fingerPushHelper = new FingerPushHelper();
        Context context = this.getApplicationContext();
        m_fingerPushHelper.setDeviceForPush(context);
    }

    private void setWebView()
    {
        // 웹뷰에서 자바스크립트실행가능
        m_webView.getSettings().setJavaScriptEnabled(true);
        // 구글홈페이지 지정
        m_webView.loadUrl("https://portal.korea.ac.kr/front/Intro.kpd");
        // WebViewClient 지정
        m_webView.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        m_backPressCloseHandler.onBackPressed();
    }
}

