package org.example;

import java.util.Scanner;

public class GetInputClass {

    Scanner scanner = new Scanner(System.in);

    public int getAnInt(String message)
    {
        int returnInt;
        while (true)
        {
            System.out.println(message);
            String input = scanner.nextLine();
            try
            {
                returnInt = Integer.parseInt(input);
                break;
            }
            catch (Exception e)
            {
                System.out.println("Please write a number.");
            }
        }
        return returnInt;
    }

    public String getString(String message)
    {
        String returnString;
        while (true)
        {
            System.out.println(message);
            returnString = scanner.nextLine();
            if (returnString.equals(""))
            {
                System.out.println("Please actually write something.");
            }
            else
            {
                break;
            }
        }
        return returnString;
    }

    public boolean getYesNo(String message)
    {
        while (true)
        {
            System.out.println(message);
            String input = scanner.nextLine();
            if (input.equals("y"))
            {
                return true;
            }
            else if (input.equals("n"))
            {
                return false;
            }
            System.out.println("y or n, please");
        }
    }
}
