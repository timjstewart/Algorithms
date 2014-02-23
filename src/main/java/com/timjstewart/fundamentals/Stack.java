package com.timjstewart.fundamentals;

import com.timjstewart.utilities.StdOut;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Stack<T> {

   private T[] stack;

   private int top = -1;

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
      }
      stack[++top] = elem;
   }

   public T pop() {
      if (top < 0)
         throw new UnderflowException();

      T result = stack[top];
      stack[top--] = null;

      if (top < stack.length / 4) {
         stack = Arrays.copyOf(stack, stack.length / 2);
      }

      return result;
   }

   public static void main(String[] args) {
      Stack<Integer> intStack = new Stack<>();

      for (int n = 1; n <= 1024; n++)
         intStack.push(n);

      for (int n = 1024; n > 0; n--)
         assertEquals(n, (int) intStack.pop());

      for (int n = 1; n <= 1024; n++)
         intStack.push(n);

      for (int n = 1024; n > 0; n--)
         assertEquals(n, (int) intStack.pop());

      try {
         intStack.pop();
         fail("should have thrown Underflow exception");
      } catch (UnderflowException ex) {
      }

      StdOut.println("Done");
   }

   private static class UnderflowException extends RuntimeException {
   }
}
