package com.example.entity;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.*;

/**
 * Created by kevin on 15.12.17.
 */
public class FileControlTest {
   //@Test
    public void save() throws Exception {

        LocalDateTime start = LocalDateTime.now();

        System.out.println("true = " + true);
        double tmp = 0;
        Math.random();
        for (int x = 1; x<1_000_000_000 ; x++) {
            tmp= x * 2* Math.random();
        }

        LocalDateTime finish = LocalDateTime.now();
        System.out.println("tmp = " + tmp);

        System.out.println("The computer says it took " + ChronoUnit.SECONDS.between(start, finish));

    }

}