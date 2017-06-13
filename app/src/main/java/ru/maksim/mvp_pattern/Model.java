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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Model)) {
            return false;
        }
        Model other = (Model) obj;
        return mVar == other.mVar;
    }

    @Override
    public int hashCode() {
        return mVar;
    }
}
