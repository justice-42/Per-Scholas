package org.davila.javabasics;

import java.util.Scanner;//gives permission to use Scanner aka makes it possible

public class WelcomeToJava {
    public static void main(String[] args) {
        /*
        multi-line comment
        class in Java should be upper camel
        main method is te entry point into an app
        static - belongs directly to its class
        void - does not return a value
         */

        // one-line comment

        /*
        variable - a memory address and it holds something
        various types of variables:
        String (characters), Integer (numbers), Double/Float (decimals), Long (longer whole numbers)
        MUST declare (define) variables aka give it a value
         */

        System.out.println("Yerrrr");

        String studentName = ("Justice");
        int studentAge = 18;
        long studentSocial;
        studentSocial = 1234567;

        //Boolean - true or false
        boolean numberBoo = true;

        //Scanner - allows us to get values from the console
        //System.in - get from console
        //System.out - goes to console

        Scanner sc = new Scanner(System.in);//must import scanner (at top)

        //Calculator creation - must get numbers from console
        //Ask user for a number
        System.out.println("Please enter a number");
        //Scanner will then get/grab that number from the console where it was input
        int number1 = sc.nextInt();//nextInt is a method that takes ints

        //Ask for another number
        System.out.println("Please enter another number");
        //again, Scanner will get/grab the next number entered from the console
        int number2 = sc.nextInt();
        System.out.println("Here are your number choices added together!");
        System.out.println(number1 + number2);

        int addition = number1 + number2;
        int subtraction = number1 - number2;
        int multiplication = number1 * number2;
        int division = number1 / number2;
        double modulus = number1 % number2;
        System.out.println("Addition: " + addition);
        System.out.println("Subtraction: " + subtraction);
        System.out.println("Multiplication: " + multiplication);
        System.out.println("Division: " + division);
        System.out.println("Modulus: " + modulus);

        int a = 3;
        int b = 4;

        // Logical OR
        System.out.println(a>b || b<a);

        //Logical AND
        System.out.println(a>b && b<a);

        //Assignment OPERATORS
        int x = 0;
        x = x+5;
        x = x-5;
        System.out.println(x);
        //Shorter version
        x = x + 5;
        x = x - 5;
        a = 3;
        b = 4;
        int c = 2;
        c = a++;
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);
        /*
        Casting is when we assign a value of one type to another type
        Explicit casting is when we assign a value of a larger data ty[e within a smaller range
        double - float - long - int - short - byte
         */
        int z;
        double y = 9.99;
        //we can cast y as an int
        x = (int)y;//takes the double and casts it as an INT
        //y = 9; INT is only whole numbers



    }
}
