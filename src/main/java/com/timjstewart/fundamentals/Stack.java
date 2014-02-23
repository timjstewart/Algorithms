package com.timjstewart.fundamentals;

import com.timjstewart.utilities.StdOut;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Stack<T> {

   private T[] stack;

   private int top = -1;

   private int timesGrown = 0;
   private int timesShrunk = 0;

   private static final int DEFAULT_CAPACITY = 16;

   public Stack(final int capacity) {
      stack = (T[]) new Object[capacity];
   }

   public Stack() {
      this(DEFAULT_CAPACITY);
   }

   public void push(T elem) {
      if (top >= stack.length - 1) {
         stack = Arrays.copyOf(stack, stack.length * 2);
         timesGrown++;
      }
      stack[++top] = elem;
   }

   public T pop() {
      if (top < 0)
         throw new UnderflowException();

      T result = stack[top];
      stack[top--] = null;

      if (top > 0 && top < stack.length / 4) {
         stack = Arrays.copyOf(stack, stack.length / 2);
         timesShrunk++;
      }

      return result;
   }

   public void printStatistics() {
      StdOut.printf("Grew %d times\nShrunk %d times\n", timesGrown, timesShrunk);
   }

   public static void main(String[] args) {
      Stack<Integer> intStack = new Stack<>(4);

      final int SMALL = 1024;

      for (int n = 1; n <= SMALL; n++)
         intStack.push(n);

      for (int n = SMALL; n > 0; n--)
         assertEquals(n, (int) intStack.pop());

      final int BIG = 1_000_000;

      for (int n = 1; n <= BIG; n++)
         intStack.push(n);

      for (int n = BIG; n > 0; n--)
         assertEquals(n, (int) intStack.pop());

      try {
         intStack.pop();
         fail("should have thrown Underflow exception");
      } catch (UnderflowException ex) {
      }

      intStack.printStatistics();

      StdOut.println("Done");
   }

   private static class UnderflowException extends RuntimeException {
   }
}
