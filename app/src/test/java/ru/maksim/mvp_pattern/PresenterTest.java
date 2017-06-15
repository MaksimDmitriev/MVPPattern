package ru.maksim.mvp_pattern;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by maksim on 15.06.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class PresenterTest {

    @Mock
    private Interactor mInteractor;
    @Mock
    private MvpView mMvpView;

    private Presenter mPresenter;

    @Before
    public void setUp() {
        initMocks(this);
        mPresenter = new PresenterImpl(mInteractor);
    }

    @Test
    public void attach() throws Exception {
        mPresenter.attach(mMvpView);
        assertEquals(mMvpView, mPresenter.getMvpView());
    }

    @Test
    public void attachAndRetrievePendingModel() throws Exception {
        Model model = new Model();
        when(mInteractor.getPendingModel()).thenReturn(model);

        mPresenter.attach(mMvpView);
        verify(mInteractor).getPendingModel();
        verify(mMvpView).onModelRetrieved(model);
        verify(mInteractor).storePendingModel(null);
    }

    @Test
    public void detach() throws Exception {
        mPresenter.attach(mMvpView);
        mPresenter.detach();
        assertNull(mPresenter.getMvpView());
    }

    @Test
    public void requestModel() throws Exception {
        mPresenter.requestModel();
        verify(mInteractor).requestModel(any(OnCompleteListener.class));
    }

    @Test
    public void runOnUiThread() throws Exception {
        mPresenter.attach(mMvpView);
        Runnable runnable = () -> {
        };
        mPresenter.runOnUiThread(runnable);
        verify(mMvpView).runOnUiThread(runnable);
    }

    @Test
    public void showModel() throws Exception {
        mPresenter.attach(mMvpView);
        Model model = new Model();
        mPresenter.showModel(model);
        verify(mMvpView).showModel(model);
    }

    @Test
    public void showModelNotCalledWhenViewNull() throws Exception {
        Model model = new Model();
        mPresenter.showModel(model);
        verify(mMvpView, never()).showModel(model);
    }

    @Test
    public void getMvpView() {
        mPresenter.attach(mMvpView);
        assertEquals(mMvpView, mPresenter.getMvpView());
    }
}