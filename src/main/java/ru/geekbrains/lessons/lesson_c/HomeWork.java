package ru.geekbrains.lessons.lesson_c;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class HomeWork {

    private static File file;

    private static void create(String name) throws IOException {
        file = new File(makeDir(name));
        file.createNewFile();
    }

    private static String makeDir(String name){
        return "C:/Java/Java_Three/src/main/java/ru/geekbrains/lessons/lesson_c/" + name;
    }

    private static StringBuilder text(String text, int words_amount){
        StringBuilder stringText = new StringBuilder();
        for (int i = 0; i < words_amount; i++) {
            stringText.append(text).append("\n");
        }
        return stringText;
    }

    private static void addText(String name, String text, int words_amount)throws FileNotFoundException {
        PrintStream file = new PrintStream(new FileOutputStream(makeDir(name), true));
        file.println(text(text, words_amount));
        file.close();
    }

    private static byte[] readByte(String name) throws IOException { //задание 1
        byte[] arr = new byte[(int) file.length()];
        try (FileInputStream in = new FileInputStream(makeDir(name))) {
            while(in.read(arr) > 0){
                return arr;
            }
        }
        return arr;
    }

    private static void sequence(String fileName, String... names) throws IOException { //задание 2
        try (PrintStream file = new PrintStream(makeDir(fileName))) {
            ArrayList<InputStream> arrayList = new ArrayList<>();
            for (String name : names) {
                arrayList.add(new FileInputStream(makeDir(name)));
            }
            try (SequenceInputStream in = new SequenceInputStream(Collections.enumeration(arrayList))) {
                int x;
                while ((x = in.read()) != -1) {
                    file.print((char) x);
                }
            }
        }
    }

    private static int bookSheets(int sheet_size){
       return (int) (file.length() / sheet_size);
    }

    private static void bookReader(String name, int sheet_size) throws IOException { //задание 3
        System.out.printf("Страниц в книге: %s\n", bookSheets(sheet_size));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер страницы: ");
        byte[] arr = new byte[sheet_size];
        int number = scanner.nextInt();
        try (RandomAccessFile raf = new RandomAccessFile(makeDir(name), "r")){
            raf.seek(number * bookSheets(sheet_size));
            raf.read(arr);
            System.out.println(new String(arr));
        }
    }

    public static void main(String[] args) throws IOException {
        create("test_1.txt");
        addText("test_1.txt", "text", 50);
        System.out.println(file.length());
        System.out.println(Arrays.toString(readByte("test_1.txt")));
        create("test_2.txt");
        addText("test_2.txt", "super", 50);
        create("test_3.txt");
        addText("test_3.txt", "char", 50);
        create("test_4.txt");
        addText("test_4.txt", "with", 50);
        create("test_5.txt");
        addText("test_5.txt", "magic", 50);
        sequence("test_6.txt", "test_1.txt", "test_2.txt", "test_3.txt", "test_4.txt", "test_5.txt");
        create("book_1.txt");
        System.out.println(file.length());
        bookReader("book_1.txt", 1800);
    }
}
