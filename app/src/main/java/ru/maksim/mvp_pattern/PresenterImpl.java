package ru.maksim.mvp_pattern;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by maksim on 13.06.17.
 */

class PresenterImpl implements Presenter {

    private final Interactor mInteractor;
    private volatile MvpView mMvpView;

    PresenterImpl(@NonNull Interactor interactor) {
        mInteractor = interactor;
    }

    @Override
    public void attach(MvpView view) {
        mMvpView = view;
        Model model = mInteractor.getPendingModel();
        if (model != null) {
            mMvpView.onModelRetrieved(model);
            mInteractor.storePendingModel(null);
        }
    }

    @Override
    public void requestModel() {
        mInteractor.requestModel(model -> handleRetrievedModel(model));
    }

    @Override
    public void detach() {
        mMvpView = null;
    }

    @Override
    public void runOnUiThread(@NonNull Runnable runnable) {
        if (mMvpView != null) {
            mMvpView.runOnUiThread(runnable);
        }
    }

    @Override
    public void showModel(@NonNull Model model) {
        if (mMvpView != null) {
            mMvpView.showModel(model);
        }
    }

    @Nullable
    @Override
    public MvpView getMvpView() {
        return mMvpView;
    }

    private void handleRetrievedModel(@NonNull Model model) {
        if (mMvpView == null) {
            mInteractor.storePendingModel(model);
        } else {
            mMvpView.onModelRetrieved(model);
        }
    }
}
