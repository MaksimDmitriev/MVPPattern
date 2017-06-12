package ru.maksim.mvp_pattern;

import android.support.annotation.NonNull;

/**
 * Created by maksim on 12.06.17.
 */

public interface Presenter {

    void attach(MvpView view);

    void detach();

    void requestModel();

    void runOnUiThread(@NonNull Runnable runnable);

    void showModel(@NonNull Model model);
}
