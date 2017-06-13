package ru.maksim.mvp_pattern;

import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by maksim on 12.06.17.
 */

class AsyncInteractor extends BaseInteractor {

    static final long DELAY = 7000L;
    private static final String TAG = "AsyncInteractor";

    @Override
    public void requestModel(@Nullable OnCompleteListener onCompleteListener) {
        new ModelRetriever(onCompleteListener).start();
    }

    private static class ModelRetriever extends Thread {

        private final OnCompleteListener mOnCompleteListener;

        ModelRetriever(OnCompleteListener onCompleteListener) {
            super("ModelRetriever");
            mOnCompleteListener = onCompleteListener;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                Log.e(TAG, "", e);
            }
            if (mOnCompleteListener != null) {
                mOnCompleteListener.onComplete(new Model());
            }
        }
    }
}
