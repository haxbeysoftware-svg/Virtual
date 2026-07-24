package com.example.sandboxcore;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sandboxcore.core.VirtualCore;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView tv = new TextView(this);
        tv.setTextSize(16);
        tv.setPadding(32, 64, 32, 32);

        String status = VirtualCore.get().getLastStatus();
        tv.setText("SandboxCore Durumu:\n\n" + status);

        setContentView(tv);
    }
}
