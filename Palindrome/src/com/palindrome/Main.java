package com.palindrome;

import java.util.Scanner;

public class Main {

    // Fonction qui cherche le PLP dans une chaine de char entree
    static int trouverPLP(String chaineEntree) {
        int something = 1;
        return something;
    }

    public static void main(String[] args) {
        String charEntree, palindrome = "";
        Scanner in = new Scanner(System.in);

        // Demander a l'utilisateur d'entrer sa chaine de charactere
        System.out.println("Enter a string to check if it is a palindrome: ");
        charEntree = in.nextLine();
        int palindromeLength = charEntree.length();
        for ( int i = palindromeLength - 1; i >= 0; i--)
            palindrome = palindrome + charEntree.charAt(i);
        // Regarder la longeur de la chaine entree
        if ( charEntree.equals(palindrome)) {
            System.out.println("Longueur maximale de palindrome PLP = " + palindromeLength);
//            System.out.print("Palindrome PLP trouvé = " + palindrome);
            System.out.print("Palindrome PLP trouvé = " + trouverPLP(palindrome));
        }
        else {
            System.out.println("La chaine " + charEntree + "ne correspond pas à un palindrome.");
        }
    }
}

// Strings to tests
// abcdbcmmcba