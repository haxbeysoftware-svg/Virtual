package com.example.sandboxcore.core;

import android.app.Instrumentation;
import android.content.Context;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.example.sandboxcore.hook.VAInstrumentation;

public class VirtualCore {

    private static final String TAG = "VirtualCore";
    private static final VirtualCore sInstance = new VirtualCore();

    private Context mContext;
    private Instrumentation mOriginalInstrumentation;
    private VAInstrumentation mHookInstrumentation;

    public static VirtualCore get() {
        return sInstance;
    }

    public void startup(Context context) {
        mContext = context.getApplicationContext();
        try {
            hookInstrumentation();
            Log.i(TAG, "VirtualCore initialized successfully");
        } catch (Exception e) {
            Log.e(TAG, "Failed to hook instrumentation", e);
        }
    }

    public Context getContext() {
        return mContext;
    }

    private void hookInstrumentation() throws Exception {
        Class<?> activityThreadClass = Class.forName("android.app.ActivityThread");

        Method currentActivityThreadMethod =
                activityThreadClass.getDeclaredMethod("currentActivityThread");
        currentActivityThreadMethod.setAccessible(true);
        Object activityThread = currentActivityThreadMethod.invoke(null);

        Field instrumentationField = activityThreadClass.getDeclaredField("mInstrumentation");
        instrumentationField.setAccessible(true);

        mOriginalInstrumentation = (Instrumentation) instrumentationField.get(activityThread);
        mHookInstrumentation = new VAInstrumentation(mOriginalInstrumentation);

        instrumentationField.set(activityThread, mHookInstrumentation);
    }
}
