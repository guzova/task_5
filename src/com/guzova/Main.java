package com.guzova;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        task1(scanner);
        task2(scanner);
        task3(scanner);
        task6(scanner);
    }

    static void task1(Scanner reader) throws IOException {
        System.out.println("1) Преобразовать текст, обрамленный в звездочки, в курсив. Не трогать текст в двойных звездочках (жирный).");
        String buffer = reader.nextLine();
        String result = "";
        Pattern pattern = Pattern.compile("(.?)(\\*[^*]+\\*)(.?)");
        while (!buffer.equals("\\n")) {
            Matcher matcher = pattern.matcher(buffer);
            int lastend = 0;
            while (matcher.find()) {
                if (!(matcher.group(1).equals("*") || matcher.group(3).equals("*"))) {
                    int begin = buffer.indexOf('*', matcher.start());
                    int end = buffer.indexOf('*', begin + 1);
                    result += buffer.substring(lastend, begin);
                    result += "<em>";
                    result += buffer.substring(begin + 1, end);
                    result += "</em>";
                    lastend = end + 1;
                }
            }
            if (lastend < buffer.length()) {
                result += buffer.substring(lastend, buffer.length());
            }
            result += "\n";
            buffer = reader.nextLine();
        }
        System.out.print(result);
    }

    static void task2(Scanner reader) throws IOException {
        System.out.println("2)Определите, что переданная строка является корректным временем вида '12:59', '23:41', '00:12', '00:00', '09:15'. ");
        String buffer = reader.nextLine();
        Pattern pattern = Pattern.compile("(([01][0-9])|(2[0-3])):([0-5][0-9])");
        while (!buffer.equals("\\n")) {
            if (buffer.matches(pattern.pattern())) {
                System.out.println("Da");
            } else {
                System.out.println("Nope");
            }
            buffer = reader.nextLine();
        }
    }

    static void task3(Scanner reader) throws IOException {
        System.out.println("3)Написать регулярное выражение определяющее является ли данная строчка GUID с или без скобок. Где GUID это строчка, состоящая из 8, 4, 4, 4, 12 шестнадцатеричных цифр разделенных тире.");
        String buffer = reader.nextLine();
        Pattern pattern = Pattern.compile("(([\\dA-Fa-f]{4}){2}-(([\\dA-Fa-f]{4})-){3}([\\dA-Fa-f]{4}){3})|(\\{(([\\dA-Fa-f]{4}){2}-(([\\dA-Fa-f]{4})-){3}([\\dA-Fa-f]{4}){3})\\})");
        while (!buffer.equals("\\n")) {
            if (buffer.matches(pattern.pattern())) {
                System.out.println("Da");
            } else {
                System.out.println("Nope");
            }
            buffer = reader.nextLine();
        }
    }

    static void task6(Scanner reader) throws IOException {
        System.out.println("6)Написать регулярное выражение определяющее является ли данная строчка датой в формате dd/mm/yyyy. Начиная с 1600 года до 9999 года");
        String buffer = reader.nextLine();
        Pattern pattern = Pattern.compile("((3[01])|([1-2]\\d)|(0[1-9]))/((1[0-2])|(0[1-9]))/((1[6-9]\\d\\d)|([2-9]\\d\\d\\d))");
        while (!buffer.equals("\\n")) {
            if (buffer.matches(pattern.pattern())) {
                System.out.println("Da");
            } else {
                System.out.println("Nope");
            }
            buffer = reader.nextLine();
        }
    }
}
