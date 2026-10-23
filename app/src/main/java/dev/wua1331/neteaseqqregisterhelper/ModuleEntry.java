package dev.wua1331.neteaseqqregisterhelper;

import android.util.Log;

import io.github.libxposed.api.XposedModule;
import io.github.libxposed.api.XposedModuleInterface;

/**
 * Modern libxposed entry point for Vector.
 *
 * Diagnostic-only: this module does not intercept authentication, registration,
 * network traffic, phone verification, or account state.
 */
public final class ModuleEntry extends XposedModule {
    private static final String TARGET_PACKAGE = "com.netease.cloudmusic";
    private static final String TAG = "NeteaseQQRegisterHelper";

    // Each module entry is instantiated in the process where it is loaded.
    private String loadedProcessName = "unknown";

    @Override
    public void onModuleLoaded(XposedModuleInterface.ModuleLoadedParam param) {
        loadedProcessName = param.getProcessName();

        log(Log.INFO, TAG, "Module initialized"
                + "; process=" + loadedProcessName
                + "; framework=" + getFrameworkName()
                + "; version=" + getFrameworkVersion()
                + "; api=" + getApiVersion());
    }

    @Override
    public void onPackageLoaded(XposedModuleInterface.PackageLoadedParam param) {
        if (!TARGET_PACKAGE.equals(param.getPackageName())) {
            return;
        }

        log(Log.INFO, TAG, "Target package loaded"
                + "; package=" + param.getPackageName()
                + "; process=" + loadedProcessName
                + "; firstPackage=" + param.isFirstPackage());
    }
}
