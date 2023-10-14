package org.srdaniel.sign;

import java.util.Scanner;

/**
 * @Author DevDaaniel
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Choose your option! 1 for SignIn or 2 for SignUp");
        int option = scan.nextInt();

        switch (option) {
            case 1:
                SignIn.main(args);
                break;
            case 2:
                SignUp.main(args);
                break;
            default:
                while (true) {
                    System.out.println("Insert a valid option!");
                    option = scan.nextInt();
                    if (option == 1) {
                        SignIn.main(args);
                        break;
                    } else if (option == 2) {
                        SignUp.main(args);
                        break;
                    }
                }
            break;
        }
    }
}