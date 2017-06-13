package ru.maksim.mvp_pattern;

import android.support.annotation.NonNull;

/**
 * Created by maksim on 13.06.17.
 */

abstract class BasePresenter implements Presenter {

    final Interactor mInteractor;
    volatile MvpView mMvpView;

    BasePresenter() {
        mInteractor = new InteractorImpl();
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
    public void detach() {
        mMvpView = null;
    }

    @Override
    public void runOnUiThread(@NonNull Runnable runnable) {
        MvpApplication.getUiHandler().post(runnable);
    }

    @Override
    public void showModel(@NonNull Model model) {
        if (mMvpView != null) {
            mMvpView.showModel(model);
        }
    }

    final void handleRetievedModel(@NonNull Model model) {
        if (mMvpView == null) {
            mInteractor.storePendingModel(model);
        } else {
            mMvpView.onModelRetrieved(model);
        }
    }
}
