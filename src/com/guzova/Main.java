package com.guzova;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        //task1(scanner);
        //task2(scanner);
        //task3(scanner);
        //task4(scanner);
        task5(scanner);
        //task6(scanner);
        //task7(scanner);
        //task8(scanner);
        //9
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
                if (!(matcher.group(1).equals("*") || matcher.group(3).equals("*"))) {//если в первой и третьей группе(одновременно) звездочки не выполняем
                    int begin = buffer.indexOf('*', matcher.start());//ищем первую звездочку с начало подходящей под регулярное выржание подстроки
                    int end = buffer.indexOf('*', begin + 1);//ищем следующую звёздочку
                    result += buffer.substring(lastend, begin);//копируем в строку result до 1 звездочки
                    result += "<em>";// дописываем ем
                    result += buffer.substring(begin + 1, end);//копируем все что между звездочек
                    result += "</em>";
                    lastend = end + 1;//след символ после последней звездочки
                }
            }
            if (lastend < buffer.length()) {
                result += buffer.substring(lastend, buffer.length());//если что-то осталось копируем все что после звездочеки
            }
            result += "\n";
            buffer = reader.nextLine();//также с новой строчкой
        }
        System.out.print(result);
    }

    static void task2(Scanner reader) throws IOException {
        System.out.println("2)Определите, что переданная строка является корректным временем вида '12:59', '23:41', '00:12', '00:00', '09:15'. ");
        String buffer = reader.nextLine();
        Pattern pattern = Pattern.compile("(([01][0-9])|(2[0-3])):([0-5][0-9])");
        while (!buffer.equals("\\n")) {
            if (buffer.matches(pattern.pattern())) {//если строка подходит под шаблон
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            buffer = reader.nextLine();
        }
    }

    static void task3(Scanner reader) throws IOException {
        System.out.println("3)Написать регулярное выражение определяющее является ли данная строчка GUID с или без скобок. Где GUID это строчка, состоящая из 8, 4, 4, 4, 12 шестнадцатеричных цифр разделенных тире.");
        String buffer = reader.nextLine();
        Pattern pattern = Pattern.compile("([\\dA-Fa-f]{8}-([\\dA-Fa-f]{4}-){3}[\\dA-Fa-f]{12})|(\\{[\\dA-Fa-f]{8}-([\\dA-Fa-f]{4}-){3}[\\dA-Fa-f]{12}\\})");
        while (!buffer.equals("\\n")) {
            if (buffer.matches(pattern.pattern())) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            buffer = reader.nextLine();
        }
    }

    static void task4(Scanner reader) throws IOException {
        System.out.println("4) Выбрать IPv4 адреса во всех возможных, представлениях: десятичном, шестнадцатеричном и восьмеричном. С точками и без.");
        String buffer = reader.nextLine();
        Pattern pattern = Pattern.compile("((((1?\\d?\\d)|(2[0-5]{2}))\\.){3}((1?\\d?\\d)|(2[0-5]{2})))|((0x[\\dA-Fa-f]{2}\\.){3}(0x[\\dA-Fa-f]{2}))|((0[0-8]{3}\\.){3}(0[0-8]{3}))|(\\d{10})|(0[0-8]{11})|(0x[\\dA-Fa-f]{8})");
        while (!buffer.equals("\\n")) {
            if (buffer.matches(pattern.pattern())) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            buffer = reader.nextLine();
        }
    }

    static void task5(Scanner reader) throws IOException {
        System.out.println("5) Написать регулярное выражение определяющее является ли данная строчка валидным URL адресом.");
        String buffer = reader.nextLine();
        Pattern pattern = Pattern.compile("((https?)://)?(([\\w\\-^_\\d]{2,}\\.)+[\\w\\-^_\\d]{2,})(:([\\d]+))?(/((\\w+/)*\\w+\\.?\\w*))?(\\?((\\w+=\\w+[&;])*\\w+=\\w+))?([#%](\\w+))?");
        while (!buffer.equals("\\n")) {
            if (buffer.matches(pattern.pattern())) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            buffer = reader.nextLine();
        }
    }

    static void task6(Scanner reader) throws IOException {
        System.out.println("6)Написать регулярное выражение определяющее является ли данная строчка датой в формате dd/mm/yyyy. Начиная с 1600 года до 9999 года");
        String buffer = reader.nextLine();
        Pattern pattern = Pattern.compile("((((3[01]|[1-2]\\d|0[1-9])/(01|03|05|07|08|10|12))|(30|[1-2]\\d|0[1-9])/(04|06|09|11)|(2[0-8]|1\\d|0[1-9])/02)/(1[6-9]|[2-9]\\d)\\d\\d)|(29/02/((1[6-9]|[2-9]\\d)(04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)|(04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)00))");
        while (!buffer.equals("\\n")) {
            if (buffer.matches(pattern.pattern())) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            buffer = reader.nextLine();
        }
    }

    static void task7(Scanner reader) throws IOException {
        System.out.println("7) Написать регулярное выражение определяющее является ли данная строка шестнадцатеричным идентификатором цвета в HTML.");
        String buffer = reader.nextLine();
        Pattern pattern = Pattern.compile("#[\\dA-Fa-f]{6}");
        while (!buffer.equals("\\n")) {
            if (buffer.matches(pattern.pattern())) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            buffer = reader.nextLine();
        }
    }

    static void task8(Scanner reader) throws IOException {
        System.out.println("8) Разбить предложение на токены. Это может быть полезно, например, для поисковой системы.");
        String buffer = reader.nextLine();
        Pattern pattern = Pattern.compile("((^|[^\"])(\"[^\"]+\")([^\"]|$))|(\\w+-\\w+)|(\\w+'\\w+)|(\\w+)");
        while (!buffer.equals("\\n")) {
            List<String> tokens = new ArrayList<>();
            Matcher matcher = pattern.matcher(buffer);
            while (matcher.find()) {
                tokens.add(matcher.group().replaceAll("\"", ""));
            }
            if (tokens.size() > 0) {
                System.out.print("[");
                for (int i = 0; i < tokens.size() - 1; ++i)
                    System.out.print(tokens.get(i) + ", ");
                System.out.println(tokens.get(tokens.size() - 1) + "]");
            }
            buffer = reader.nextLine();
        }
    }
}
