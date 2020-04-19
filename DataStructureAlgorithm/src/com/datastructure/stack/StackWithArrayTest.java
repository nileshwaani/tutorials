package com.datastructure.stack;

public class StackWithArrayTest {
  public static void main(String[] args) {
    testPeek(3);
  }

  public static void testPush(int stackSize) {
    StackWithArray stack = new StackWithArray(stackSize);

    try {
      System.out.println("Pushing 10");
      stack.push(10);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    stack.print();

    try {
      System.out.println("Pushing 20");
      stack.push(20);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    stack.print();

    try {
      System.out.println("Pushing 30");
      stack.push(30);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    stack.print();

  }

  public static void testPop(int stackSize) {
    StackWithArray stack = createFilledStack(stackSize);
    stack.print();

    try {
      System.out.println("Popping...");
      int value = stack.pop();
      System.out.println("Value : " + value);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    stack.print();

    try {
      System.out.println("Popping...");
      int value = stack.pop();
      System.out.println("Value : " + value);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    stack.print();

    try {
      System.out.println("Popping...");
      int value = stack.pop();
      System.out.println("Value : " + value);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    stack.print();

    try {
      System.out.println("Popping...");
      int value = stack.pop();
      System.out.println("Value : " + value);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    stack.print();
  }

  public static void testPeek(int stackSize) {
    StackWithArray stack = createFilledStack(stackSize);
    stack.print();

    try {
      System.out.println("Peeking...");
      int value = stack.peek();
      System.out.println("Value : " + value);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    stack.print();

    try {
      System.out.println("Peeking...");
      int value = stack.peek();
      System.out.println("Value : " + value);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    stack.print();

    try {
      System.out.println("Peeking...");
      int value = stack.peek();
      System.out.println("Value : " + value);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    stack.print();

  }

  private static StackWithArray createFilledStack(int stackSize) {
    StackWithArray stack = new StackWithArray(stackSize);
    for (int i = 1; i <= stackSize; i++) {
      try {
        stack.push(i * 10);
      }
      catch (Exception e) {
      }
    }
    return stack;
  }
}
