class SelectionSort {
    void sort(int arr[])
    {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // Encontrar minimo del array, a partir de i + 1 para evitar agarrar siempre el mismo minimo, ignorando los valores que estan atras de i.
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) // Compara el valor en la posicion i con el que esta en la posicion j y si es menor, guarda el index del menor en min_idx
                    min_idx = j;
            }

            // Intercambia el nuevo minimo encontrado con el valor que estaba en la posicion i
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // main function
    public static void main(String args[])
    {
        SelectionSort elSorting = new SelectionSort();
        int arr[] = { 64, 25, 12, 22, 11 };

        elSorting.sort(arr);
        System.out.println("Arreglo ordenado con selection sort:");
        elSorting.printArray(arr);
    }
}


