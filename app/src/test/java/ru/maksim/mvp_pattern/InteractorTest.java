package ru.maksim.mvp_pattern;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InteractorTest {

    private Interactor mInteractor;

    @Before
    public void setUp() {
        mInteractor = new InteractorImpl();
    }

    @Test
    public void requestModel() throws Exception {
        OnCompleteListener onCompleteListener = mock(OnCompleteListener.class);
        mInteractor.requestModel(onCompleteListener);
        verify(onCompleteListener, timeout(InteractorImpl.DELAY + 2000L)).onComplete(new Model());
    }

    @Test
    public void getPendingModel() throws Exception {
        Model model = new Model();
        mInteractor.storePendingModel(model);
        assertEquals(model, mInteractor.getPendingModel());
    }

}