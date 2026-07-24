package com.example.sandboxcore.core;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class StubActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("StubActivity", "created, intent: " + getIntent());
    }
}
