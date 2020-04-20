package com.datastructure.queue;

public class LinearQueueWithArrayTest {
  public static void main(String[] args) {
    testPeek(2);
  }

  public static void testEnqueue(int queueSize) {
    LinearQueueWithArray queue = new LinearQueueWithArray(queueSize);

    try {
      System.out.println("Enqueuing 10");
      queue.enqueue(10);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();

    try {
      System.out.println("Enqueuing 20");
      queue.enqueue(20);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();

    try {
      System.out.println("Enqueuing 30");
      queue.enqueue(30);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();
  }

  public static void testDequeue(int queueSize) {
    LinearQueueWithArray queue = createFilledQueue(queueSize);
    queue.print();

    try {
      System.out.println("Dequeuing...");
      int value = queue.dequeue();
      System.out.println("Value : " + value);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();

    try {
      System.out.println("Dequeuing...");
      int value = queue.dequeue();
      System.out.println("Value : " + value);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();

    try {
      System.out.println("Dequeuing...");
      int value = queue.dequeue();
      System.out.println("Value : " + value);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();

    try {
      System.out.println("Dequeuing...");
      int value = queue.dequeue();
      System.out.println("Value : " + value);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();
  }

  public static void testPeek(int queueSize) {
    LinearQueueWithArray queue = createFilledQueue(queueSize);
    queue.print();

    try {
      System.out.println("Peeking...");
      int value = queue.peek();
      System.out.println("Value : " + value);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();

    try {
      System.out.println("Peeking...");
      int value = queue.peek();
      System.out.println("Value : " + value);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();

    try {
      System.out.println("Peeking...");
      int value = queue.peek();
      System.out.println("Value : " + value);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();

  }
  
  private static LinearQueueWithArray createFilledQueue(int queueSize) {
    LinearQueueWithArray queue = new LinearQueueWithArray(queueSize);
    for (int i = 1; i <= queueSize; i++) {
      try {
        queue.enqueue(i * 10);
      }
      catch (Exception e) {
      }
    }
    return queue;
  }

}
