package dev.wua1331.neteaseqqregisterhelper;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Diagnostic-only entry point.
 *
 * This module deliberately does not intercept registration, authentication,
 * network responses, phone verification, or account state.
 */
public final class ModuleEntry implements IXposedHookLoadPackage {
    private static final String TARGET_PACKAGE = "com.netease.cloudmusic";
    private static final String TAG = "[NeteaseQQRegisterHelper]";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        if (!TARGET_PACKAGE.equals(lpparam.packageName)) {
            return;
        }

        XposedBridge.log(TAG + " loaded into target process"
                + " package=" + lpparam.packageName
                + " process=" + lpparam.processName
                + " firstApplication=" + lpparam.isFirstApplication);
    }
}
