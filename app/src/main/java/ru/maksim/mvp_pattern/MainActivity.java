package ru.maksim.mvp_pattern;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MvpView, View.OnClickListener {

    private static final String TAG = "MainActivity";
    private Presenter mPresenter = new PresenterImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.request_model).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.attach(this);
    }

    @Override
    protected void onStop() {
        mPresenter.detach();
        super.onStop();
    }

    @Override
    public void showModel(@NonNull Model model) {
        Log.d(TAG, "model = " + model);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.request_model:
                mPresenter.requestModel();
                break;
        }
    }
}
