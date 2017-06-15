package ru.maksim.mvp_pattern;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
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
    }

    @Test
    public void requestModel() throws Exception {
    }

    @Test
    public void runOnUiThread() throws Exception {
//        verify(mMvpView).runOnUiThread();
    }

    @Test
    public void showModel() throws Exception {
    }

}