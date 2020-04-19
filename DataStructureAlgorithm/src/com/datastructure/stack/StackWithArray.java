package com.datastructure.stack;

public class StackWithArray {

  private int[] array = null;
  private int topOfStack = -1;

  public StackWithArray(int size) {
    array = new int[size];
    topOfStack = -1;
  }

  /**
   * Push a value into the stack
   */
  public void push(int value) throws Exception {
    if (isFull()) {
      throw new Exception("Stackoverflow...");
    }

    topOfStack++;
    array[topOfStack] = value;
  }

  /**
   * Pop value from the stack
   */
  public int pop() throws Exception {
    if (isEmpty()) {
      throw new Exception("Stack is empty..");
    }
    int value = array[topOfStack];
    topOfStack--;
    return value;
  }

  /**
   * Peek value from the stack
   */
  public int peek() throws Exception {
    if (isEmpty()) {
      throw new Exception("Stack is empty..");
    }
    int value = array[topOfStack];
    return value;
  }

  /**
   * Check if stack is empty
   */
  public boolean isEmpty() {
    return topOfStack <= -1;
  }

  /**
   * Check if stack is empty
   */
  public boolean isFull() {
    return topOfStack >= array.length - 1;
  }

  public void print() {
    if (topOfStack <= -1) {
      System.out.println("Empty Stack");
      return;
    }
    System.out.print("Stack => ");
    for (int i = 0; i <= topOfStack; i++) {
      System.out.printf("%s | ", array[i]);
    }
    System.out.println();
  }
}
