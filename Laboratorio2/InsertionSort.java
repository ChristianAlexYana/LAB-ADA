package Laboratorio2;

public class InsertionSort {
    public static void main(String[] args) {
        String nombresAleatorio[] = {"chritian", "ana", "maria", "zulema", "juan", "pedro", "alberto", "carlos", "beto"};
        String nombresOrdenado[] = { "ana", "alberto", "beto", "carlos", "chritian", "juan", "maria", "pedro", "zulema" };
        String nombresInverso[] = { "zulema", "pedro", "maria", "juan", "chritian", "carlos", "beto", "alberto", "ana" };
        long inicio1= System.nanoTime();
        ordenar(nombresAleatorio);
        long fin1 = System.nanoTime();
        long inicio2= System.nanoTime();
        ordenar(nombresOrdenado);
        long fin2 = System.nanoTime();
        long inicio3= System.nanoTime();
        ordenar(nombresInverso);
        long fin3 = System.nanoTime();
        System.out.println("Arreglo ordenado aleatorio: ");
        imprimir(nombresAleatorio);
        System.out.println("Tiempo de ejecucion para arreglo aleatorio: " + (fin1 - inicio1) + " nanosegundos");
        System.out.println("Arreglo ordenado: ");
        imprimir(nombresOrdenado);
        System.out.println("Tiempo de ejecucion para arreglo ordenado: " + (fin2 - inicio2) + " nanosegundos");
        System.out.println("Arreglo ordenado inverso: ");
        imprimir(nombresInverso);
        System.out.println("Tiempo de ejecucion para arreglo inverso: " + (fin3 - inicio3) + " nanosegundos");

    }
    public static void ordenar(String[] arreglo){
        for(int i = 0; i < arreglo.length - 1; i++){
            for(int j = i + 1; j < arreglo.length; j++){
                if(arreglo[i].compareTo(arreglo[j]) > 0){ 
                    String aux = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = aux;
                }
            }
        }
    }
    public static void imprimir(String[] arreglo){
        for(int i = 0; i < arreglo.length; i++){
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }

}
