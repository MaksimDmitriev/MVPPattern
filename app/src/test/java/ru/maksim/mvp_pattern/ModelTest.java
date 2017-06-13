package ru.maksim.mvp_pattern;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by maksim on 13.06.17.
 */
public class ModelTest {

    @Test
    public void assertSymmetric() {
        Model model1 = new Model();
        Model model2 = new Model();
        assertEquals(model1, model2);
        assertEquals(model2, model1);
    }

    @Test
    public void assertReflexive() {
        Model model1 = new Model();
        assertEquals(model1, model1);
    }

    @Test
    public void assertTransitive() {
        Model model1 = new Model();
        Model model2 = new Model();
        Model model3 = new Model();
        assertEquals(model1, model2);
        assertEquals(model2, model3);
        assertEquals(model1, model3);
    }

}