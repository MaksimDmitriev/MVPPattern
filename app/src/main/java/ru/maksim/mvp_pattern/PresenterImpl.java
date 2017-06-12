package ru.maksim.mvp_pattern;

/**
 * Created by maksim on 12.06.17.
 */

class PresenterImpl implements Presenter {

    private final Interactor mInteractor;
    private volatile MvpView mMvpView;

    PresenterImpl() {
        mInteractor = new InteractorImpl();
    }

    @Override
    public void attach(MvpView view) {
        mMvpView = view;
        Model model = mInteractor.getPendingModel();
        if (model != null) {
            mMvpView.showModel(model);
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
                    mMvpView.showModel(model);
                }
            }
        });
    }
}
