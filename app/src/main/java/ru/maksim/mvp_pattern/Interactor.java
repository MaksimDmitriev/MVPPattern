package ru.maksim.mvp_pattern;

import android.support.annotation.Nullable;

/**
 * Created by maksim on 12.06.17.
 */

public interface Interactor {

    void requestModel(OnCompleteListener onCompleteListener);

    @Nullable
    Model getPendingModel();

    void storePendingModel(@Nullable Model model);
}
