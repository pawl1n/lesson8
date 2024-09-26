package org.example;

import java.util.Arrays;
import java.util.Random;
import org.example.Computer.OperatingSystem;

/**
 * Hello world!
 */
public class App {

  public static void main(String[] args) {

    Computer computer = new Computer(16, 4, "Acer", OperatingSystem.Windows);
    System.out.println(computer);

    Computer computer1 = Computer.builder()
        .ram(16)
        .cores(4)
        .name("Lenovo")
        .operatingSystem(OperatingSystem.Linux)
        .number()
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

    // matrix task
    int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
    };
    System.out.println(Arrays.deepToString(matrix));
    System.out.println(Arrays.deepToString(transpose(matrix)));
    System.out.println(Arrays.deepToString(rotate(matrix)));
  }

  public static int[][] transpose(int[][] matrix) {
    int[][] newMatrix = new int[matrix[0].length][];

    for (int i = 0; i < newMatrix.length; i++) {
      newMatrix[i] = new int[matrix.length];
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        newMatrix[j][i] = matrix[i][j];
      }
    }

    return newMatrix;
  }

  public static int[][] rotate(int[][] matrix) {
    int[][] newMatrix = new int[matrix[0].length][];

    for (int i = 0; i < newMatrix.length; i++) {
      newMatrix[i] = new int[matrix.length];
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        newMatrix[j][matrix.length - 1 - i] = matrix[i][j];
      }
    }

    return newMatrix;
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

