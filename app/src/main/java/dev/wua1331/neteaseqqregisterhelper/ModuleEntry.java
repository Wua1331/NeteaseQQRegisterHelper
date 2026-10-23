package dev.wua1331.neteaseqqregisterhelper;

import android.util.Log;

import io.github.libxposed.api.XposedModule;
import io.github.libxposed.api.XposedInterface;

/**
 * Modern libxposed entry point for Vector.
 *
 * Diagnostic-only: this module does not intercept authentication, registration,
 * network traffic, phone verification, or account state.
 */
public final class ModuleEntry extends XposedModule {
    private static final String TARGET_PACKAGE = "com.netease.cloudmusic";
    private static final String TAG = "NeteaseQQRegisterHelper";

    @Override
    public void onModuleLoaded() {
        log(TAG + ": module initialized by " + getFrameworkName()
                + " version=" + getFrameworkVersion());
    }

    @Override
    public void onPackageLoaded(XposedInterface.PackageLoadedParam param) {
        if (!TARGET_PACKAGE.equals(param.getPackageName())) {
            return;
        }
        log(TAG + ": target package loaded: " + param.getPackageName()
                + ", process=" + param.getProcessName());
    }

    private static void log(String message) {
        try {
            Log.i(TAG, message);
        } catch (Throwable ignored) {
            // Avoid crashing the target process if logging is unavailable.
        }
    }
}
