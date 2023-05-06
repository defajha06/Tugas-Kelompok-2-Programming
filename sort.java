import java.util.Random;
import java.util.Scanner;

public class sort {
    private static char pilihan;
    private static Scanner input = new Scanner(System.in);
    private static int [] randomAngka = new int[5];

    public static void main(String[] args){
        while (true){
            mainMenu();
        }
    }

    private static void mainMenu(){
        System.out.println("\nSelamat Datang di Program Simulasi\nMenu");
        System.out.println("1. Random Data");
        System.out.println("2. Simulasi Bubble Sort - Ascending");
        System.out.println("3. Simulasi Selection Sort - Ascending");
        System.out.println("4. Simulasi Bubble Sort - Descending");
        System.out.println("5. Simulasi Selection Sort - Descending");
        System.out.println("6. Keluar");
        System.out.print("Masukkan Pilihan Anda : ");
        pilihan = input.next().charAt(0);

        switch (pilihan){
            case '1':
                randomBil();
                break;
            case '2':
                bubbleSortAsc(randomAngka, 5);
                break;
            case '3':
                selectionSortAsc(randomAngka, 5);
                break;
            case '4':
                bubbleSortDesc(randomAngka, 5);
                break;
            case '5':
                selectionSortDesc(randomAngka, 5);
                break;
            case '6':
                System.exit(0);
                break;
            default:
                System.out.print("Masukkan pilihan antara 1 - 6");
                break;
        }

    }

    private static void randomBil(){
        Random bilrand = new Random();
        System.out.print("Batas Bawah: ");
        int batasBawah = input.nextInt();
        System.out.print("Batas Atas: ");
        int batasAtas = input.nextInt();

        if(batasBawah >= batasAtas)
            System.out.print("Batas Atas harus lebih besar dari batas bawah");
        else {
            int range = batasAtas - batasBawah;
            for(int i = 0; i < 5; i++){
                randomAngka[i] = bilrand.nextInt(range) + batasBawah;
                System.out.print(randomAngka[i] + " ");
            }
        }
    }

    private static void bubbleSortAsc(int [] data, int jmlData){
        // tampilkan data sebelum sorting
        System.out.print("\nData sebelum di sorting: ");
        for(int i = 0 ; i < jmlData; i++){
            System.out.print(data[i] + " ");
        }

        // proses Bubble sort
        System.out.println("\nProses Bubble Sort Ascending");
        for(int i = 0; i < 4; i++){
            System.out.println();
            System.out.print("Pass " + (i + 1) + " :\n");
            for(int j = 0; j < jmlData; j++)
                System.out.print(data[j] + " ");

            System.out.println();
            for(int j = 0; j < jmlData - 1; j++){
                if(data[j] > data[j + 1]){
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
                if(j < jmlData - (i + 1)){
                    for(int k = 0; k < jmlData; k++)
                        System.out.print(data[k] + " ");
                }
                System.out.println();
            }
            System.out.println("Result of Pass " + (i + 1) + " :");
            for(int j = 0; j < jmlData; j++)
                System.out.print(data[j] + " ");
            System.out.println();
        }
    }

    private static void selectionSortAsc(int [] data, int jmlData){
        // tampilkan data sebelum di sorting
        System.out.print("\nData sebelum disorting: ");
        for(int i = 0; i < jmlData; i++)
            System.out.print(data[i] + " ");

        // proses selection sort
        System.out.print("\nProses Selection Sort Ascending");
        for(int i = 0; i < jmlData - 1; i++){
            System.out.print("\nPass " + (i + 1) + " : ");
            for(int j = 0; j < jmlData; j++)
                System.out.print(data[j] + " ");

            boolean tukar = false;
            int index = 0;
            int min = data[i];
            for(int j = i + 1; j < jmlData; j++){
                if(min > data[j]){
                    tukar = true;
                    index = j;
                    min = data[j];
                }
            }

            if(tukar == true){
                int temp = data[i];
                data[i] = data[index];
                data[index] = temp;
            }
            System.out.println("\nResult of Pass " + (i + 1) + " :");
            for(int j = 0; j < jmlData; j++)
                System.out.print(data[j] + " ");
        }
    }

    private static void bubbleSortDesc(int [] data, int jmlData){
        // tampilkan data sebelum sorting
        System.out.print("\nData sebelum di sorting: ");
        for(int i = 0 ; i < jmlData; i++){
            System.out.print(data[i] + " ");
        }

        // proses Bubble sort
        System.out.println("\nProses Bubble Sort Descending");
        for(int i = 0; i < 4; i++){
            System.out.println();
            System.out.print("Pass " + (i + 1) + " :\n");
            for(int j = 0; j < jmlData; j++)
                System.out.print(data[j] + " ");

            System.out.println();
            for(int j = 0; j < jmlData - 1; j++){
                if(data[j] < data[j + 1]){
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }

                if(j < jmlData - (i + 1)){
                    for(int k = 0; k < jmlData; k++)
                        System.out.print(data[k] + " ");
                }
                System.out.println();
            }
            System.out.println("Result of Pass " + (i + 1) + " :");
            for(int j = 0; j < jmlData; j++)
                System.out.print(data[j] + " ");
            System.out.println();
        }
    }

    private static void selectionSortDesc(int [] data, int jmlData){
        // tampilkan data sebelum di sorting
        System.out.print("\nData sebelum disorting: ");
        for(int i = 0; i < jmlData; i++)
            System.out.print(data[i] + " ");

        // proses selection sort
        System.out.print("\nProses Selection Sort Descending");
        for(int i = 0; i < jmlData - 1; i++){
            System.out.print("\nPass " + (i + 1) + " : ");
            for(int j = 0; j < jmlData; j++)
                System.out.print(data[j] + " ");

            boolean tukar = false;
            int index = 0;
            int min = data[i];
            for(int j = i + 1; j < jmlData; j++){
                if(min < data[j]){
                    tukar = true;
                    index = j;
                    min = data[j];
                }
            }

            if(tukar == true){
                int temp = data[i];
                data[i] = data[index];
                data[index] = temp;
            }
            System.out.println("\nResult of Pass " + (i + 1) + " :");
            for(int j = 0; j < jmlData; j++)
                System.out.print(data[j] + " ");
        }
    }
}