/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 * source: https://stackoverflow.com/questions/3985392/generate-random-date-of-birth
 * @author Saul
 * Date: 2010-10-21
 */
public interface RandomDateOfBirth {
     public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
