package org.example;

import java.util.Arrays;
import java.util.Random;
import org.example.Computer.OperatingSystem;

/**
 * Hello world!
 */
public class App {

  public static void main(String[] args) {

    Computer computer = new Computer(16, 4, "Acer", OperatingSystem.WINDOWS);
    computer.turnOn();
    System.out.println(computer);

    Computer computer1 = Computer.builder()
        .ram(16)
        .cores(4)
        .name("Lenovo")
        .operatingSystem(OperatingSystem.LINUX)
        .build();

    System.out.println(computer1);

    int[] arr = new int[10];

    Random intRandomizer = new Random();

    int sum = 0;

    for (int i = 0; i < arr.length; i++) {
      arr[i] = intRandomizer.nextInt(2);

      sum = sum + arr[i];

    }

    int result = 0;

    if (arr.length > 0) {
      result = sum / arr.length;
    }

    System.out.println(Arrays.toString(arr));
    System.out.println(result);

    System.out.println(Arrays.toString(deleteElement(arr, 1)));
  }

  public static int[] deleteElement(int[] arr, int number) {
    int count = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == number) {
        count++;
      }
    }

    int[] result = new int[arr.length - count];

    for (int i = 0, j = 0; i < arr.length; i++) {
      if (arr[i] != number) {
        result[j] = arr[i];
        j++;
      }
    }

    return result;
  }

}

