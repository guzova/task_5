package com.guzova;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        task1(bufferedReader);
        task2(bufferedReader);
        task3(bufferedReader);
        task6(bufferedReader);
    }

    static void task1(BufferedReader reader) throws IOException {
        System.out.println("1) Преобразовать текст, обрамленный в звездочки, в курсив. Не трогать текст в двойных звездочках (жирный).");
        String buffer = reader.readLine();
        String result = "";
        Pattern pattern = Pattern.compile("(.?)(\\*[^*]+\\*)(.?)");
        while (!buffer.equals("\\n")) {
            Matcher matcher = pattern.matcher(buffer);
            int lastend = 0;
            while (matcher.find()) {
                if (!(matcher.group(1).equals("*") && matcher.group(3).equals("*"))) {
                    int begin = buffer.indexOf('*', matcher.start());
                    int end = buffer.indexOf('*', begin + 1);
                    result += buffer.substring(lastend, begin);
                    result += "<em>";
                    result += buffer.substring(begin + 1, end);
                    result += "</em>";
                    lastend = end + 1;
                }
            }
            if (lastend < buffer.length())
                result += buffer.substring(lastend, buffer.length());
            buffer = reader.readLine();
        }
        System.out.println(result);
    }

    static void task2(BufferedReader reader) throws IOException {
        System.out.println("2)Определите, что переданная строка является корректным временем вида '12:59', '23:41', '00:12', '00:00', '09:15'. ");
        String buffer = reader.readLine();
        Pattern pattern = Pattern.compile("(([01][0-9])|(2[0-3])):([0-5][0-9])");
        while (!buffer.equals("\\n")) {
            if (buffer.matches(pattern.pattern())) {
                System.out.println("Da");
            } else {
                System.out.println("Nope");
            }
            buffer = reader.readLine();
        }
    }

    static void task3(BufferedReader reader) throws IOException {
        System.out.println("3)Написать регулярное выражение определяющее является ли данная строчка GUID с или без скобок. Где GUID это строчка, состоящая из 8, 4, 4, 4, 12 шестнадцатеричных цифр разделенных тире.");
        String buffer = reader.readLine();
        Pattern pattern = Pattern.compile("(([\\dA-Fa-f]{4}){2}-(([\\dA-Fa-f]{4})-){3}([\\dA-Fa-f]{4}){3})|(\\{(([\\dA-Fa-f]{4}){2}-(([\\dA-Fa-f]{4})-){3}([\\dA-Fa-f]{4}){3})\\})");
        while (!buffer.equals("\\n")) {
            if (buffer.matches(pattern.pattern())) {
                System.out.println("Da");
            } else {
                System.out.println("Nope");
            }
            buffer = reader.readLine();
        }
    }

    static void task6(BufferedReader reader) throws IOException {
        System.out.println("6)Написать регулярное выражение определяющее является ли данная строчка датой в формате dd/mm/yyyy. Начиная с 1600 года до 9999 года");
        String buffer = reader.readLine();
        Pattern pattern = Pattern.compile("((3[01])|([1-2]\\d)|(0[1-9]))/((1[0-2])|(0[1-9]))/((1[6-9]\\d\\d)|([2-9]\\d\\d\\d))");
        while (!buffer.equals("\\n")) {
            if (buffer.matches(pattern.pattern())) {
                System.out.println("Da");
            } else {
                System.out.println("Nope");
            }
            buffer = reader.readLine();
        }
    }
}
