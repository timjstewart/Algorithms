package com.timjstewart.fundamentals;

import static junit.framework.Assert.assertEquals;

public class DiceProbabilities {

   public static double[] twoDice() {

      final int SIDES = 6;
      final int OUTCOMES = SIDES * 2;

      final double[] probs = new double[OUTCOMES + 1];

      for (int d1 = 1; d1 <= SIDES; d1++)
         for (int d2 = 1; d2 <= SIDES; d2++) {
            probs[d1 + d2] += 1.0;
         }

     for (int n = 1; n <= OUTCOMES; n++)
        probs[n] /= 36.0;

      return probs;
   }

   public static void main(String[] args) {
      final double[] probs = twoDice();

      assertEquals(0.0 / 36, probs[0]);
      assertEquals(0.0 / 36, probs[1]);
      assertEquals(1.0 / 36, probs[2]);
      assertEquals(2.0 / 36, probs[3]);
      assertEquals(3.0 / 36, probs[4]);
      assertEquals(4.0 / 36, probs[5]);
      assertEquals(5.0 / 36, probs[6]);
      assertEquals(6.0 / 36, probs[7]);
      assertEquals(5.0 / 36, probs[8]);
      assertEquals(4.0 / 36, probs[9]);
      assertEquals(3.0 / 36, probs[10]);
      assertEquals(2.0 / 36, probs[11]);
      assertEquals(1.0 / 36, probs[12]);
   }
}
