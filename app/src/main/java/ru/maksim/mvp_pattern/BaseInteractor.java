package ru.maksim.mvp_pattern;

import android.support.annotation.Nullable;

/**
 * Created by maksim on 13.06.17.
 */

public abstract class BaseInteractor implements Interactor {

    // TODO: can this be a partially initialized instance when it's published?
    private volatile Model mPendingModel;

    @Nullable
    @Override
    public final Model getPendingModel() {
        return mPendingModel;
    }

    @Override
    public final void storePendingModel(@Nullable Model model) {
        mPendingModel = model;
    }
}
