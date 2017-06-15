package ru.maksim.mvp_pattern;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by maksim on 15.06.17.
 */
public class SyncInteractorTest {

    @Test
    public void requestModel() throws Exception {
        Interactor interactor = new SyncInteractor();
        OnCompleteListener onCompleteListener = mock(OnCompleteListener.class);
        interactor.requestModel(onCompleteListener);
        verify(onCompleteListener).onComplete(new Model());
    }

}