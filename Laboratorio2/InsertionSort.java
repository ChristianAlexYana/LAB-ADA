package Laboratorio2;

public class InsertionSort {
    public static void main(String[] args) {
        String nombres[] = {"chritian", "ana", "maria", "zulema", "juan", "pedro", "alberto", "carlos", "beto"};
        long inicio= System.nanoTime();
        int pasos=0;
        for(int i = 0; i < nombres.length - 1; i++){
            for(int j = i + 1; j < nombres.length; j++){
                if(nombres[i].compareTo(nombres[j]) > 0){ 
                    String aux = nombres[i];
                    nombres[i] = nombres[j];
                    nombres[j] = aux;
                    pasos++;
                }
            }
        }
        long fin = System.nanoTime();
        for(int i = 0; i < nombres.length; i++){
            System.out.print(nombres[i] + " ");
        }
        System.out.println("\nTiempo de ejecucion: " + (fin - inicio) + " nanosegundos");
        System.out.println("Pasos: " + pasos);
    }
}
