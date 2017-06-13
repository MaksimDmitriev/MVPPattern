package ru.maksim.mvp_pattern;

import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by maksim on 12.06.17.
 */

class InteractorImpl implements Interactor {

    static final long DELAY = 7000L;
    private static final String TAG = "InteractorImpl";

    private Model mPendingModel;

    @Override
    public void requestModel(OnCompleteListener onCompleteListener) {
        new ModelRetriever(onCompleteListener).start();
    }

    @Nullable
    @Override
    public Model getPendingModel() {
        return mPendingModel;
    }

    @Override
    public void storePendingModel(@Nullable Model model) {
        mPendingModel = model;
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
