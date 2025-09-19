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
        }
    }
}
