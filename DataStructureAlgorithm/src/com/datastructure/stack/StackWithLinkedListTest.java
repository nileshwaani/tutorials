package com.datastructure.stack;

public class StackWithLinkedListTest {
  public static void main(String[] args) {
    testPeek(1);
  }

  public static void testPush() {
    StackWithLinkedList stack = new StackWithLinkedList();

    System.out.println("Pushing 10");
    stack.push(10);
    stack.print();

    System.out.println("Pushing 20");
    stack.push(20);
    stack.print();

    System.out.println("Pushing 30");
    stack.push(30);
    stack.print();

    System.out.println("Pushing 40");
    stack.push(40);
    stack.print();

  }

  public static void testPop(int stackSize) {
    StackWithLinkedList stack = createFilledStack(stackSize);
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
    StackWithLinkedList stack = createFilledStack(stackSize);
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

  private static StackWithLinkedList createFilledStack(int stackSize) {
    StackWithLinkedList stack = new StackWithLinkedList();
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
