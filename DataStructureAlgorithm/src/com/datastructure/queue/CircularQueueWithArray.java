package com.datastructure.queue;

public class CircularQueueWithArray {

  private int[] array = null;
  private int topOfQueue = -1;
  private int beginningOfQueue = -1;

  public CircularQueueWithArray(int queuSize) {
    array = new int[queuSize];
    topOfQueue = -1;
    beginningOfQueue = -1;
  }

  /**
   * Enqueue an element in the queue
   */
  public void enqueue(int value) throws Exception {
    if (isFull()) {
      throw new Exception("Queue is full!");
    }

    if(beginningOfQueue == -1) {
      beginningOfQueue = topOfQueue = 0;
      array[topOfQueue] = value;
      return;
    }
    
    if(topOfQueue == array.length - 1) {
      topOfQueue = 0;
      array[topOfQueue] = value;
      return;
    }
    
    topOfQueue++;
    array[topOfQueue] = value;
  }

  /**
   * Dequeue an element from the queue
   */
  public int dequeue() throws Exception {
    if (isEmpty()) {
      throw new Exception("Queue is empty!");
    }

    int value = array[beginningOfQueue];

    if(beginningOfQueue == topOfQueue) {
      beginningOfQueue = topOfQueue = -1;
      return value;
    }
    
    if(beginningOfQueue == array.length - 1) {
      beginningOfQueue = 0;
      return value;
    }
    
    beginningOfQueue++;
    return value;
  }

  /**
   * Peek an element from the queue
   */
  public int peek() throws Exception {
    if (isEmpty()) {
      throw new Exception("Queue is empty!");
    }

    return array[beginningOfQueue];
  }

  /**
   * Check if the queue is full
   */
  public boolean isFull() {
    return topOfQueue - beginningOfQueue == array.length - 1 || topOfQueue == beginningOfQueue - 1;
  }

  /**
   * Check if the queue is empty
   */
  public boolean isEmpty() {
    return topOfQueue == -1;
  }

  public void print() {
    if (topOfQueue <= -1) {
      System.out.println("Empty Queue");
      return;
    }

    System.out.print("Queue => ");
    if(topOfQueue < beginningOfQueue) {
      for (int i = 0; i <= topOfQueue; i++) {
        System.out.printf(" %s ", array[i]);
        if(i == topOfQueue) System.out.printf("T");
        System.out.printf(" | ");
      }
      for (int i = beginningOfQueue; i <= array.length - 1; i++) {
        if(i == beginningOfQueue) System.out.printf("B");
        System.out.printf(" %s | ", array[i]);
      }
    }
    else {
      for (int i = beginningOfQueue; i <= topOfQueue; i++) {
        if(i == beginningOfQueue) System.out.printf("B");
        System.out.printf(" %s ", array[i]);
        if(i == topOfQueue) System.out.printf("T");
        System.out.printf(" | ");
      }
    }
    System.out.println();

  }
}
