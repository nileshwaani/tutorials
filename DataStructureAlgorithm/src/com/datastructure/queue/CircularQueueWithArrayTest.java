package com.datastructure.queue;

public class CircularQueueWithArrayTest {
  public static void main(String[] args) {
    testDequeue3();
  }

  public static void testEnqueue1() {
    CircularQueueWithArray queue = createEmptyQueue();
    queue.print();
    try {
      System.out.println("Enqueueing 10");
      queue.enqueue(10);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();
    try {
      System.out.println("Enqueueing 20");
      queue.enqueue(20);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();
    try {
      System.out.println("Enqueueing 30");
      queue.enqueue(30);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();
    try {
      System.out.println("Enqueueing 40");
      queue.enqueue(40);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();
    try {
      System.out.println("Enqueueing 50");
      queue.enqueue(50);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();
  }

  public static void testEnqueue2() {
    CircularQueueWithArray queue = createMiddleFilledQueue1();
    queue.print();

    try {
      System.out.println("Enqueueing 40");
      queue.enqueue(40);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();
    try {
      System.out.println("Enqueueing 50");
      queue.enqueue(50);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();
    try {
      System.out.println("Enqueueing 60");
      queue.enqueue(60);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();
  }

  public static void testEnqueue3() {
    CircularQueueWithArray queue = createMiddleFilledQueue2();
    queue.print();

    try {
      System.out.println("Enqueueing 40");
      queue.enqueue(40);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();
    try {
      System.out.println("Enqueueing 50");
      queue.enqueue(50);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();
    try {
      System.out.println("Enqueueing 60");
      queue.enqueue(60);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();
  }

  public static void testDequeue1() {
    CircularQueueWithArray queue = createEmptyQueue();
    queue.print();

    try {
      System.out.println("Dequeuing....");
      int dequeue = queue.dequeue();
      System.out.println(dequeue);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void testDequeue2() {
    CircularQueueWithArray queue = createMiddleFilledQueue1();
    queue.print();

    try {
      System.out.println("Dequeuing....");
      int dequeue = queue.dequeue();
      System.out.println(dequeue);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      System.out.println("Dequeuing....");
      int dequeue = queue.dequeue();
      System.out.println(dequeue);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      System.out.println("Dequeuing....");
      int dequeue = queue.dequeue();
      System.out.println(dequeue);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void testDequeue3() {
    CircularQueueWithArray queue = createMiddleFilledQueue1();
    queue.print();

    try {
      System.out.println("Enqueueing 40");
      queue.enqueue(40);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();

    try {
      System.out.println("Enqueueing 50");
      queue.enqueue(50);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();

    try {
      System.out.println("Dequeuing...");
      int dequeue = queue.dequeue();
      System.out.println(dequeue);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();

    try {
      System.out.println("Dequeuing...");
      int dequeue = queue.dequeue();
      System.out.println(dequeue);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();

    try {
      System.out.println("Enqueueing 60");
      queue.enqueue(60);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();
    try {
      System.out.println("Dequeuing...");
      int dequeue = queue.dequeue();
      System.out.println(dequeue);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    queue.print();
  }

  private static CircularQueueWithArray createEmptyQueue() {
    CircularQueueWithArray queue = new CircularQueueWithArray(4);
    return queue;
  }

  // | | 20 | 30 |
  private static CircularQueueWithArray createMiddleFilledQueue1() {
    CircularQueueWithArray queue = new CircularQueueWithArray(4);

    try {
      queue.enqueue(10);
      queue.enqueue(20);
      queue.enqueue(30);

      queue.dequeue();
    }
    catch (Exception e) {
    }
    return queue;
  }

  // | | 20 | |
  private static CircularQueueWithArray createMiddleFilledQueue2() {
    CircularQueueWithArray queue = new CircularQueueWithArray(4);

    try {
      queue.enqueue(10);
      queue.enqueue(20);

      queue.dequeue();
    }
    catch (Exception e) {
    }
    return queue;
  }

}
