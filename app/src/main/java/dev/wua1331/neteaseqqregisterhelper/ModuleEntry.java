package dev.wua1331.neteaseqqregisterhelper;

import android.app.Activity;
import android.util.Log;

import java.lang.reflect.Method;

import io.github.libxposed.api.XposedInterface;
import io.github.libxposed.api.XposedModule;
import io.github.libxposed.api.XposedModuleInterface;

/**
 * Modern libxposed entry point for Vector.
 *
 * Diagnostic-only: logs module/package loading and Activity class names.
 * It never changes authentication, registration, network traffic, phone
 * verification, or account state.
 */
public final class ModuleEntry extends XposedModule {
    private static final String TARGET_PACKAGE = "com.netease.cloudmusic";
    private static final String TAG = "NeteaseQQRegisterHelper";

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

    @Override
    public void onPackageReady(XposedModuleInterface.PackageReadyParam param) {
        if (!TARGET_PACKAGE.equals(param.getPackageName())) {
            return;
        }

        // Log Activity class names only; never inspect views, text, intents,
        // credentials, phone numbers, verification codes, or network payloads.
        try {
            Method onResume = Activity.class.getDeclaredMethod("onResume");
            hook(onResume)
                    .setId("neteaseqqregisterhelper_activity_resume")
                    .setExceptionMode(XposedInterface.ExceptionMode.PROTECTIVE)
                    .intercept(chain -> {
                        Object receiver = chain.getThisObject();
                        Object result = chain.proceed();

                        if (receiver instanceof Activity) {
                            Activity activity = (Activity) receiver;
                            if (TARGET_PACKAGE.equals(activity.getPackageName())) {
                                log(Log.INFO, TAG, "Activity resumed; class="
                                        + activity.getClass().getName());
                            }
                        }

                        return result;
                    });

            log(Log.INFO, TAG, "Activity resume diagnostic hook installed"
                    + "; process=" + loadedProcessName);
        } catch (Throwable error) {
            // A failed diagnostic hook must not interrupt the host app.
            log(Log.WARN, TAG,
                    "Activity resume tracing unavailable; package diagnostics remain active",
                    error);
        }
    }
}
