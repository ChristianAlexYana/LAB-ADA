package Laboratorio2;

import java.util.Random;

public class ejercicio3 {
    public static void main(String[] args) {
        int[] tamaños = {1000, 5000, 10000};
        String[] tipos = {"insertion", "selection"};
        for (String metodo : tipos) {
            System.out.println("\n--- Método: " + metodo.toUpperCase() + " ---");
            for (int n : tamaños) {
                int[] arr = generarArreglo(n);
                long inicio = System.nanoTime();
                ordenar(arr, metodo);
                long fin = System.nanoTime();
                System.out.println("Tamaño: " + n + "  Tiempo: " + (fin - inicio) / 1_000_000.0 + " ms");
            }
        }
    }
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Intercambio
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    public static void ordenar(int[] arr, String tipo) { // "insertion" o "selection"
        if (tipo.equalsIgnoreCase("insertion")) {
            insertionSort(arr);
        } 
        else if (tipo.equalsIgnoreCase("selection")) {
            selectionSort(arr);
        } 
        else {
            System.out.println("Tipo de ordenamiento no reconocido.");
        }
    }
    public static int[] generarArreglo(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100000); // números entre 0 y 99,999
        }
        return arr;
    }


}
