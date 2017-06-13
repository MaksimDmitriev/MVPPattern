package ru.maksim.mvp_pattern;

import android.support.annotation.Nullable;

/**
 * Created by maksim on 13.06.17.
 */

public class SyncInteractor extends BaseInteractor {

    @Override
    public void requestModel(@Nullable OnCompleteListener onCompleteListener) {
        if (onCompleteListener != null) {
            onCompleteListener.onComplete(new Model());
        }
    }
}
