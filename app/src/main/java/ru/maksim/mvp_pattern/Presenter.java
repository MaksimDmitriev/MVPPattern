package ru.maksim.mvp_pattern;

/**
 * Created by maksim on 12.06.17.
 */

public interface Presenter {

    void attach(MvpView view);

    void detach();

    void requestModel();
}
