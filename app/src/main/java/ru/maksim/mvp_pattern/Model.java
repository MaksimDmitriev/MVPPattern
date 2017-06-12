package ru.maksim.mvp_pattern;

/**
 * Created by maksim on 12.06.17.
 */

public class Model {

    private final int mVar;

    Model() {
        mVar = 42;
    }

    @Override
    public String toString() {
        return Integer.toString(mVar);
    }
}
