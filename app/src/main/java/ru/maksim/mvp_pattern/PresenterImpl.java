package ru.maksim.mvp_pattern;

import android.support.annotation.NonNull;

/**
 * Created by maksim on 13.06.17.
 */

class PresenterImpl implements Presenter {

    final Interactor mInteractor;
    volatile MvpView mMvpView;

    PresenterImpl() {
        mInteractor = new SyncInteractor();
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
        MvpApplication.getUiHandler().post(runnable);
    }

    @Override
    public void showModel(@NonNull Model model) {
        if (mMvpView != null) {
            mMvpView.showModel(model);
        }
    }

    private void handleRetrievedModel(@NonNull Model model) {
        if (mMvpView == null) {
            mInteractor.storePendingModel(model);
        } else {
            mMvpView.onModelRetrieved(model);
        }
    }
}
