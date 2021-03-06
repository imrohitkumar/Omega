package com.google.android.apps.nexuslauncher.smartspace;

public class SmartspaceDataContainer {
    public SmartspaceCard dO;
    public SmartspaceCard dP;

    public SmartspaceDataContainer() {
        dO = null;
        dP = null;
    }

    public boolean isWeatherAvailable() {
        return dO != null;
    }

    public boolean isDataAvailable() {
        return dP != null;
    }

    public long cT() {
        final long currentTimeMillis = System.currentTimeMillis();
        if (isDataAvailable() && isWeatherAvailable()) {
            return Math.min(dP.cF(), dO.cF()) - currentTimeMillis;
        }
        if (isDataAvailable()) {
            return dP.cF() - currentTimeMillis;
        }
        if (isWeatherAvailable()) {
            return dO.cF() - currentTimeMillis;
        }
        return 0L;
    }

    public boolean clearAll() {
        final boolean b = true;
        boolean b2 = false;
        if (isWeatherAvailable() && dO.cM()) {
            dO = null;
            b2 = b;
        }
        if (isDataAvailable() && dP.cM()) {
            dP = null;
            b2 = b;
        }
        return b2;
    }

    public String toString() {
        return "{" + dP + "," + dO + "}";
    }
}
