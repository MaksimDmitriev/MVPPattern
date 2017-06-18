package ru.maksim.mvp_pattern;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;

/**
 * Created by maksim on 15.06.17.
 */

@RunWith(RobolectricTestRunner.class)
public class MvpViewTest {

    @Mock
    private Presenter mPresenter;
    private MvpView mMvpView;

    @Before
    public void setUp() {
        mMvpView = new MainFragment();
        mMvpView.setPresenter(mPresenter);
    }

    @Test
    public void onModelRetrieved() throws Exception {
    }

    @Test
    public void showModel() throws Exception {
    }

    @Test
    public void runOnUiThread() throws Exception {
    }

}