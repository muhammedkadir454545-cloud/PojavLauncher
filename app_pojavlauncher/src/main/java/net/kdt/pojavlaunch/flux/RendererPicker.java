package net.kdt.pojavlaunch.flux;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

public class RendererPicker {
    public static String pick(Context c) {
        boolean vulkan11 = c.getPackageManager()
            .hasSystemFeature(PackageManager.FEATURE_VULKAN_HARDWARE_VERSION, 0x401000);
        boolean qualcomm = Build.HARDWARE.toLowerCase().contains("qcom");
        if (vulkan11 && qualcomm) return "vulkan_zink";
        return "opengles2";
    }
}
