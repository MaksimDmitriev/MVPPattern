package ru.maksim.mvp_pattern;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

/**
 * Created by maksim on 12.06.17.
 */

class PresenterImpl implements Presenter {

    private final Interactor mInteractor;
    private final Handler mUiHandler;
    private volatile MvpView mMvpView;

    PresenterImpl() {
        mInteractor = new InteractorImpl();
        mUiHandler = new Handler(Looper.getMainLooper());
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
    public void requestModel() {
        mInteractor.requestModel(model -> {
            if (mMvpView == null) {
                mInteractor.storePendingModel(model);
            } else {
                mMvpView.onModelRetrieved(model);
            }
        });
    }

    @Override
    public void runOnUiThread(@NonNull Runnable runnable) {
        mUiHandler.post(runnable);
    }

    @Override
    public void showModel(@NonNull Model model) {
        mMvpView.showModel(model);
    }
}
