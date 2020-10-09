package com.palindrome;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        String charEntree, palindrome = "";
        Scanner in = new Scanner(System.in);

        // Demander a l'utilisateur d'entrer sa chaine de charactere
        System.out.println("Enter a string to check if it is a palindrome: ");
        palindrome = trouverPLP(in.nextLine());
        System.out.printf("Longueur maximale de palindrome PLP = %d\n", palindrome.length());
        System.out.printf("Palindrome PLP trouvé = '%s'", palindrome);
    }
    
    public static String trouverPLP(String s)
    {
        if (s.isEmpty()) return null;
        
        String plp = "";
        
        boolean[][] dpArray = new boolean[s.length()][s.length()];
        
        // Étape #1 : chaque caractère individuelle est un palindrome
        for (int i = 0; i < s.length(); i++)
        {
            dpArray[i][i] = true;
            
            // Garder le dernier caractère en mémoire
            plp = s.substring(i, i+1);
        }
        
        // Étape #2 : regarder les chaines de 2+ caractères dans la String
        for (int subLength = 2; subLength <= s.length(); subLength++)
        {
            // i = le début de la chaine
            for (int i = 0; i < s.length() - subLength + 1; i++)
            {
                // j = Fin de la chaine
                int j = i + subLength - 1;
                
                // Pour les chaines de 2 caractère
                if (subLength == 2)
                {
                    dpArray[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
                    if(dpArray[i][i + 1])
                    {
                        plp = s.substring(i,i+2);
                    }
                }
                // Pour les longueurs > 2
                else
                {
                    // On vérifie dans notre tableau, en enlevant le premier et dernier caractère, si la chaine est un palindrome
                    // puis on vérifie le premier et dernier caractère s'ils sont identiques.
                    dpArray[i][j] = dpArray[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                    if(dpArray[i][j] && plp.length() < subLength)
                    {
                        plp = s.substring(i, j + 1);
                    }
                }
            }
        }
        
        return plp;
    }
}

// Strings to tests
// abcdbcmmcba