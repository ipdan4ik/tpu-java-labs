package ru.tpu.regexp;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void calculate(String expression) {
        String regex = "^(.+)+([\\+\\-\\*\\/])+(.+)$";

        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group(2);

            double first = Double.parseDouble(matcher.group(1));
            double second = Double.parseDouble(matcher.group(3));

            System.out.print(first + " " + operation + " " + second + " = ");

            double result;
            switch (operation) {
                case "-":
                    result = first - second;
                    System.out.println(result);
                    break;
                case "*":
                    result = first * second;
                    System.out.println(result);
                    break;
                case "/":
                    if (second != 0) {
                        result = first / second;
                        System.out.println(result);
                    } else {
                        System.out.println("zero division");
                    }
                    break;
                default:
                    result = first + second;
                    System.out.println(result);
                    break;
            };
        } else {
            System.out.println(expression + ": invalid expression");
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line = reader.readLine();
        while (line != null) {
            calculate(line);
            line = reader.readLine();
        }
    }
}
