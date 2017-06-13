package ru.maksim.mvp_pattern;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;


/**
 * Created by maksim on 13.06.17.
 */

public class MvpApplication extends Application {

    private static Handler sUiHandler;

    public static Handler getUiHandler() {
        return sUiHandler;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sUiHandler = new Handler(Looper.getMainLooper());
    }
}
