package com.example.sandboxcore.core;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class StubActivitySingleTask extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("StubActivitySingleTask", "created, intent: " + getIntent());
    }
}
