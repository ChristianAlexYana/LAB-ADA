#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <time.h>
#include <chrono>

using namespace std;
using namespace std::chrono;

// ESTRUCTURA PARA ALMACENAR LOS DATOS
struct Jugador {
  int id;
  string nombre;
  int valor;
};

// FUNCION PARA VER LOS ORDENAMIENTOS
void printJugadores(const vector<Jugador> arr, int paso) {
    cout << "Paso " << paso << ":\n";
    for (auto &j : arr) { 
        cout << "ID: " << j.id 
             << " | Nombre: " << j.nombre 
             << " | Valor: " << j.valor << endl;
    }
    cout << "-----------------------" << endl;
}


// ORDENAMIENTO POR INSERCION
void insertionSort(vector<Jugador> arr) { 
    int paso = 0;
    printJugadores(arr, paso++);
    
    auto begin = high_resolution_clock::now();
    for (int i = 1; i < arr.size(); i++) {
        Jugador key = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j].valor < key.valor) { // mayor a menor
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
        printJugadores(arr, paso++);
    }
    auto final = high_resolution_clock::now();
    auto duracion = duration_cast<microseconds>(final - begin);

    cout << "Acabo en " << duracion.count() << " microsegundos\n" << endl;
}


// ORDENAMIENTO POR SELECCION
void selectionSort(vector<Jugador> arr) {
    int paso = 0;
    printJugadores(arr, paso++);

    auto begin = high_resolution_clock::now();
    time_t beggin = time(NULL);
    for (int i = 0; i < arr.size() - 1; i++) {
        int maxIdx = i;
        for (int j = i + 1; j < arr.size(); j++) {
            if (arr[j].valor > arr[maxIdx].valor) { // mayor a menor
                maxIdx = j;
            }
        }
        swap(arr[i], arr[maxIdx]);
        printJugadores(arr, paso++);
    }
    auto final = high_resolution_clock::now();
    auto duracion = duration_cast<microseconds>(final - begin);

    cout << "Acabo en " << duracion.count() << " microsegundos\n" << endl;
}

// FUNCION PRINCIPAL CON MANEJO DEL ARCHIVO
int main() {
  // Con la libreria fstream abrimos el archivo
  ifstream file("jugadores.txt");
  
  // Se usa vector para flexibilidad en el tamanio 
  vector<Jugador> Jugadores;

  // Sacamos la informacion por lineas y agarramos por datos
  string linea;
  while (getline(file, linea)) {
      stringstream ss(linea);
      string parte;
      Jugador j;

      // ID
      getline(ss, parte, ';');
      j.id = stoi(parte);

      // Nombre
      getline(ss, j.nombre, ';');

      // Valor
      getline(ss, parte, ';');
      j.valor = stoi(parte);

      Jugadores.push_back(j);
  }

  insertionSort(Jugadores);
  selectionSort(Jugadores);

  ofstream resultado;
  resultado.open("jugadores.csv");

  resultado << "Valor,ID,Nombre\n"; // CABECERA PARA CATEGORIAS

  for (Jugador j : Jugadores) {
    resultado << j.valor << "," << j.id << "," << j.nombre << "\n"; // SE REALIZA SALTO DE LINEA PARA USAR MAS LINEAS
  }
}
