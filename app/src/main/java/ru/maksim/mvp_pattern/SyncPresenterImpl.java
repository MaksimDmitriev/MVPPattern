package ru.maksim.mvp_pattern;

/**
 * Created by maksim on 13.06.17.
 */

public class SyncPresenterImpl extends BasePresenter {

    @Override
    public void requestModel() {
        handleRetievedModel(new Model());
    }
}
