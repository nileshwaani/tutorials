package com.java7;

public class TryWithResource {

  public static void main(String[] args) throws Exception {

    try (AutoCloseableResource firstResource = new AutoCloseableResource("FIRST"); AutoCloseableResource secondResource = new AutoCloseableResource("SECOND")) {
      firstResource.doSomething();
      secondResource.doSomething();
    }

  }

  private static class AutoCloseableResource implements AutoCloseable {

    private String resourceName;

    public AutoCloseableResource(String resourceName) {
      System.out.println(resourceName + " is created.");
      this.resourceName = resourceName;
    }

    public void doSomething() {
      System.out.println(resourceName + " is doing something.");
    }

    @Override
    public void close() throws Exception {
      System.out.println(resourceName + " is closed.");
    }

  }
}
