package exceptionhandling.multiplecatchblocks;

import java.io.*;
import java.util.*;

public class array_Operations {
    public static void main(String[] args) {
        // int arr[]=null;
        int arr[] = {1, 2, 3, 4, 5};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Index Number to retrieve : ");
        int index = sc.nextInt();

        try {
            System.out.println("Value at index " + index + " : " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Index : index out of range ");
            ;
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized");
            ;
        }

    }
}
