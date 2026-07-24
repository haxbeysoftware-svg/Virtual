package com.example.sandboxcore.hook;

import android.app.Activity;
import android.app.Instrumentation;
import android.os.Bundle;
import android.util.Log;

public class VAInstrumentation extends Instrumentation {

    private static final String TAG = "VAInstrumentation";
    private final Instrumentation mBase;

    public VAInstrumentation(Instrumentation base) {
        mBase = base;
    }

    @Override
    public void callActivityOnCreate(Activity activity, Bundle icicle) {
        Log.i(TAG, "callActivityOnCreate intercepted: " + activity.getClass().getName());
        super.callActivityOnCreate(activity, icicle);
    }
}
