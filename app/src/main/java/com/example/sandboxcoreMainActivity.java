package com.example.sandboxcore;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView tv = new TextView(this);
        tv.setText("SandboxCore çalışıyor. Logcat'e bakın.");
        tv.setTextSize(18);
        tv.setPadding(32, 64, 32, 32);
        setContentView(tv);

        Log.i(TAG, "MainActivity started");
    }
}
