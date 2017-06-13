package ru.maksim.mvp_pattern;

/**
 * Created by maksim on 12.06.17.
 */

class AsyncPresenterImpl extends BasePresenter {

    @Override
    public void requestModel() {
        mInteractor.requestModel(model -> handleRetievedModel(model));
    }
}
