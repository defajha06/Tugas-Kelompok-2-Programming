import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeretAngka {
    public static void main(String[] args) {
        // Initiate scanner
        Scanner input = new Scanner(System.in);

        /* Input Nama */
        String userName = "";
        boolean expectInput = true;
        while (expectInput) {
            System.out.print("Masukkan Nama Anda [1..25]: ");
            userName = input.nextLine();
            if (userName.length() == 0) {
                System.out.println("Harap masukkan nama Anda.\n");
            } else if (userName.length() > 25) {
                System.out.println("Nama maksimal 25 karakter.\n");
            } else if(!userName.matches("[a-zA-Z]+")) {
                System.out.println("Nama hanya boleh huruf.\n");
            } else {
                expectInput = false;
            }
        }

        // Input NIM
        String nim = "";
        expectInput = true;
        while (expectInput) {
            System.out.print("Masukkan NIM Anda: ");
            nim = input.nextLine();
            if (nim.length() != 10) {
                System.out.println("Harap masukkan NIM 10 karakter.\n");
            } else if (!nim.matches("[0-9]+")) {
                System.out.println("NIM hanya boleh angka.\n");
            } else {
                expectInput = false;
            }
        }

        // Registrasi Sukses
        System.out.println();
        System.out.println("@".repeat(100));
        System.out.println("\nRegistrasi sukses...");
        System.out.printf("Selamat datang %s [NIM: %s].. ^^v%n", userName, nim);


        System.out.println("Mari belajar macam-macam deret bilangan..\n");
        System.out.println("@".repeat(100));
        System.out.println("");

        /* Calculation */
        while (true) {
            // Input number
            System.out.println("@".repeat(100));
            int numberInput = 0;
            expectInput = true;
            while (expectInput) {
                System.out.print("\nMasukkan Sembarang Angka [5..20]: ");
                try {
                    numberInput = Integer.parseInt(String.valueOf(input.nextLine()));
                    if ((numberInput < 5) || (numberInput > 20)) {
                        System.out.println("Harap masukkan angka antara 5 s.d. 20.");
                    } else {
                        expectInput = false;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Harap masukkan angka antara 5 s.d. 20.");
                }
            }
            System.out.println();
            System.out.println("@".repeat(100));

            System.out.println("\nDeret Bilangan");
            System.out.println("################");

            // Buat deret
            List<Integer> deretGenap = new ArrayList<>();
            List<Integer> deretGanjil = new ArrayList<>();
            List<Integer> deretFibonacci = new ArrayList<>();
            for (int i = 0; i < numberInput; i++) {
                deretGenap.add((i+1)*2);
                if (i == 0) {
                    deretGanjil.add(1);
                    deretFibonacci.add(1);
                } else {
                    deretGanjil.add(deretGanjil.get(i-1) + 2);
                    if (i == 1) {
                        deretFibonacci.add(1);
                    } else {
                        deretFibonacci.add(deretFibonacci.get(i-2) + deretFibonacci.get(i-1));
                    }
                }
            }

            // Deret genap
            System.out.printf("%d Bilangan Genap:%n", numberInput);
            int totalGenap = 0;
            for (int genap: deretGenap) {
                System.out.printf("%d ", genap);
                totalGenap += genap;
            }
            System.out.printf("%nHasil Penjumlahan = %d%n%n", totalGenap);

            // Deret ganjil
            System.out.printf("%d Bilangan Ganjil:%n", numberInput);
            int totalGanjil = 0;
            for (int number: deretGanjil) {
                System.out.printf("%d ", number);
                totalGanjil += number;
            }
            System.out.printf("%nHasil Penjumlahan = %d%n%n", totalGanjil);

            // Deret fibonacci
            System.out.printf("%d Bilangan Fibonacci:%n", numberInput);
            int totalFibonacci = 0;
            for (int number: deretFibonacci) {
                System.out.printf("%d ", number);
                totalFibonacci += number;
            }
            System.out.printf("%nHasil Penjumlahan = %d%n%n", totalFibonacci);

            /* Ask for exit */
            System.out.print("Anda ingin mengulang [y/t]: ");
            boolean confirming = true;
            while(confirming) {
                String conformation = input.nextLine();
                if (conformation.equalsIgnoreCase("T")) {
                    System.out.print("Terima kasih.");
                    System.exit(0);
                } else if (conformation.equalsIgnoreCase("Y")) {
                    confirming = false;
                } else {
                    System.out.print("Harap jawab [y/t]: ");
                }
            }
        }
    }
}