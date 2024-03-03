package aydin.main.automobile;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static int result;
    static int fNumber, sNumber;

    public static void main(String[] args) throws Exception {
        System.out.println(calc(in.nextLine()));
    }

    public static String calc(String input) throws Exception {
        String[] str = input.split(" ");
        if (str.length != 3) throw new Exception();
        fNumber = romanToArabian(str[0]);
        sNumber = romanToArabian(str[2]);
        if (fNumber != -1 && sNumber != -1) {
            result = calculate(fNumber, sNumber, str[1]);
            return convertArabianToRoman(result);
        }
        try {
            fNumber = Integer.parseInt(str[0]);
            sNumber = Integer.parseInt(str[2]);
            if (sNumber < 1 || sNumber > 10 || fNumber < 1 || fNumber > 10) throw new Exception();
        } catch (Exception e) {
            throw new Exception();
        }
        result = calculate(fNumber, sNumber, str[1]);
        return Integer.toString(result);
    }

    private static int romanToArabian(String s) {
        return switch (s) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> -1;
        };
    }

    private static int calculate(int first, int second, String operation) throws Exception {
        result = switch (operation) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            default -> throw new Exception();
        };
        return result;
    }

    private static String convertArabianToRoman(int numRoman) throws Exception {
        if (numRoman < 1) throw new Exception();
        String[] roman = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
                "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII",
                "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI",
                "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV",
                "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII",
                "LXXVIII", "LXXIX", "LXXX"};
        return roman[numRoman];
    }
}