package ru.maksim.mvp_pattern;

import android.support.annotation.NonNull;

/**
 * Created by maksim on 12.06.17.
 */

class PresenterImpl implements Presenter {

    private final Interactor mInteractor;
    private volatile MvpView mMvpView;
//    private

    PresenterImpl() {
        mInteractor = new InteractorImpl();
    }

    @Override
    public void attach(MvpView view) {
        mMvpView = view;
        Model model = mInteractor.getPendingModel();
        if (model != null) {
            mMvpView.onModelRetrieved(model);
        }
    }

    @Override
    public void detach() {
        mMvpView = null;
    }

    @Override
    public void requestModel() {
        mInteractor.requestModel(new OnCompleteListener() {
            @Override
            public void onComplete(Model model) {
                if (mMvpView == null) {
                    mInteractor.storePendingModel(model);
                } else {
                    mMvpView.onModelRetrieved(model);
                }
            }
        });
    }

    @Override
    public void runOnUiThread(@NonNull Runnable runnable) {

    }

    @Override
    public void showModel(@NonNull Model model) {
        mMvpView.showModel(model);
    }
}
