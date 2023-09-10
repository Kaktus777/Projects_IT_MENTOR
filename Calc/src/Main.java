import java.util.Scanner;
import java.io.IOException;
class Program {

    public static String calc(String input) throws IOException {
        int n = 0;                                  //string length
        int count = 0;                              //number of symbols of mathematical operations
        int operation = 0;                          //mathematical operation
        String op = "";                             //mathematical operation
        int a = 0;                                  //operand number 1
        int b = 0;                                  //operand number 2
        int namber = 0;                             //number mathematecal operation
        int result = 0;                             //operation result
        String a2 = "";                             //string with operand 1
        String b2 = "";                             //string with operand 2
        String output = "";

        if (true == input.isEmpty()) {
            throw new IOException();
        }
        input = input.trim();
        n = input.length();
        if (n < 3) {
            throw new IOException();
        }

        // find mathematical operation symbol
        for (int i = 0; i < n; i++) {
            int k = input.codePointAt(i);
            if (count < 2) {
                switch (k) {
                    case 43:
                        operation = 43;
                        ++count;
                        namber = i;
                        break;
                    case 45:
                        operation = 45;
                        ++count;
                        namber = i;
                        break;
                    case 42:
                        operation = 42;
                        ++count;
                        namber = i;
                        break;
                    case 47:
                        operation = 47;
                        ++count;
                        namber = i;
                        break;
                }
            } else {
                throw new IOException();
            }
        }

        if (namber == 0 || namber == n - 1) {
            throw new IOException();
        }
        op = op + (char) (operation);


        // find operand 1
        a2 = input.substring(0, namber);
        a2 = a2.trim();
        if (a2.length() > 2) {
            throw new IOException();
        } else if (a2.length() == 2 && a2.codePointAt(0) == '1' && a2.codePointAt(1) == '0') {
            a = 10;
        } else if (a2.length() == 2) {
            throw new IOException();
        } else {
            char[] z = a2.toCharArray();
            if (((int) (z[0]) - 48 > 0) && ((int) (z[0]) - 48 <= 9)) {
                a = (int) (z[0]) - 48;
            } else {
                throw new IOException();
            }
        }


        // find operand 2
        b2 = input.substring(namber + 1, n);
        b2 = b2.trim();
        if (b2.length() > 2) {
            throw new IOException();
        } else if (b2.length() == 2 && b2.codePointAt(0) == '1' && b2.codePointAt(1) == '0') {
            b = 10;
        } else if (b2.length() == 2) {
            throw new IOException();
        } else {
            char[] u = b2.toCharArray();
            if (((int) (u[0]) - 48 > 0) && ((int) (u[0]) - 48 <= 9)) {
                b = (int) (u[0]) - 48;
            } else {
                throw new IOException();
            }
        }


        //calculation
        switch (operation) {
            case 43:
                result = a + b;
                break;
            case 45:
                result = a - b;
                break;
            case 42:
                result = a * b;
                break;
            case 47:
                result = a / b;
                break;
        }
        output = String.valueOf(result);
        return output;

    }

    public static void main (String [] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String inp = in.nextLine();
        try {
            System.out.println(calc(inp));
        } catch (IOException e) {
            System.out.println("throws exception");
        }
    }
}
