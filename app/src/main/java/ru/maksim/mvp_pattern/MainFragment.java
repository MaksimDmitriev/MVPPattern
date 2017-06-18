package ru.maksim.mvp_pattern;

import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by maksim on 12.06.17.
 */

public class MainFragment extends Fragment implements MvpView, View.OnClickListener {

    private Presenter mPresenter;
    private TextView mModelTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setPresenter(new PresenterImpl(new SyncInteractor()));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mModelTextView = (TextView) view.findViewById(R.id.model_text_view);
        view.findViewById(R.id.request_model).setOnClickListener(this);
        return view;
    }

    @Override
    public void setPresenter(@NonNull Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onModelRetrieved(@NonNull final Model model) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            mPresenter.showModel(model);
        } else {
            mPresenter.runOnUiThread(() -> mPresenter.showModel(model));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.attach(this);
    }

    @Override
    public void onPause() {
        mPresenter.detach();
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.request_model:
                mPresenter.requestModel();
                break;
        }
    }

    @Override
    public void showModel(@NonNull Model model) {
        mModelTextView.setText(model.toString());
    }

    @Override
    public void runOnUiThread(@NonNull Runnable runnable) {
        getActivity().runOnUiThread(runnable);
    }
}
