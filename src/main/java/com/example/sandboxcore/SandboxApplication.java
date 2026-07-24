package com.example.sandboxcore.core;

import android.app.Application;
import android.content.Context;

public class SandboxApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        VirtualCore.get().startup(base);
    }
}
