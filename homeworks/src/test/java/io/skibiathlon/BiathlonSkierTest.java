package io.skibiathlon;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BiathlonSkierTest {

    BiathlonSkier biathlonSkier = new BiathlonSkier(11,
            "Umar Jorgson",
            "SK",
            LocalTime.of(0, 30, 27), new ArrayList<>(Arrays.asList("xxxox", "xxxxx", "xxoxo")));

    @Test
    public void calculateNumberOfZero() {
        biathlonSkier.calculateNumberOfZero();
        assertEquals(3,biathlonSkier.getNumberOfZero());
    }

    @Test
    public void calculateStandingTime() {
        biathlonSkier.setNumberOfZero(3);
        biathlonSkier.calculateStandingTime();
        assertEquals(LocalTime.of(0,30,57),biathlonSkier.getStandingTime());
    }
}