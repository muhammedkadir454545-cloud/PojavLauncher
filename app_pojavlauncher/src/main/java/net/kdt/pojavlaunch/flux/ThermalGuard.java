package net.kdt.pojavlaunch.flux;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;

public class ThermalGuard {
    public interface Callback { void onFpsCap(int fps); }

    public static void start(Context c, Callback cb) {
        if (Build.VERSION.SDK_INT < 29) return;
        PowerManager pm = (PowerManager) c.getSystemService(Context.POWER_SERVICE);
        pm.addThermalStatusListener(status -> {
            if (status >= PowerManager.THERMAL_STATUS_SEVERE) cb.onFpsCap(30);
            else if (status >= PowerManager.THERMAL_STATUS_MODERATE) cb.onFpsCap(45);
            else cb.onFpsCap(60);
        });
    }
}
