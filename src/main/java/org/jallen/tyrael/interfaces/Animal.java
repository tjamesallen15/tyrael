package org.jallen.tyrael.interfaces;

public interface Animal {
  public void eat();
  default public void sleep() {
    System.out.println("Animal is sleeping");
  } 
}
