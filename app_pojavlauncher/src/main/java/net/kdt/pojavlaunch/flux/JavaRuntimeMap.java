package net.kdt.pojavlaunch.flux;

import org.json.JSONObject;

public class JavaRuntimeMap {
    public static int major(JSONObject versionJson) {
        JSONObject jv = versionJson.optJSONObject("javaVersion");
        return jv != null ? jv.optInt("majorVersion", 8) : 8;
    }
}
