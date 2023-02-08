package view;

import java.util.Scanner;

public class ScannerService {
    static int readInt(){
        return new Scanner(System.in).nextInt();
    }

    static String readString(){
        return new Scanner(System.in).nextLine();
    }
    static long readLong(){ return new Scanner(System.in).nextLong(); }
}
