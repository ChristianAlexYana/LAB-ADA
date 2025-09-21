package Laboratorio2;

public class SelectionFloat {
    public static void main (String args[]){
        float arr []= {5.12f ,2.15f ,5.14f ,2.11f ,6} ;
        // primer bucle recorre el arreglo de inicio a penultimo

        int comparaciones = 0;
        int intercambios = 0;

        for(int i = 0; i < arr.length; i++){
            int min = i; // se asume que el elemento actual es el mínimo
            for(int j = i+1; j < arr.length; j++){
                comparaciones++;
                if (arr[j] < arr[min] ){  // si se encuentra un valor menor, se actualiza el índice del minimo 
                    min = j;
                }
            }

            if (min != i) {
                float vacio = arr[min];  // se guarda el valor del minimo temporalmente
                arr[min]= arr[i];  // se asigna el valor actual en la posicion del minimo
                arr[i] = vacio;  // se asigna el valor minimo en la posicion actual
                intercambios++;
            }

        }

        // arreglo ordenado de forma ascendente
        System.out.println("Arreglo ordenado de forma ascendente");
        for(float dato : arr){
            System.out.println( dato +" ");
        }

        System.out.println("\nComparaciones: " + comparaciones);
        System.out.println("Intercambios: " + intercambios);
    }
}
