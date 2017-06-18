package ru.maksim.mvp_pattern;

import android.support.annotation.NonNull;

/**
 * Created by maksim on 12.06.17.
 */

public interface MvpView {

    void setPresenter(@NonNull Presenter presenter);

    void onModelRetrieved(@NonNull Model model);

    void showModel(@NonNull Model model);

    void runOnUiThread(@NonNull Runnable runnable);
}
