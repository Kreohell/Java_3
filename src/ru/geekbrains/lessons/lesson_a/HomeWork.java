package ru.geekbrains.lessons.lesson_a;


import java.util.ArrayList;
import java.util.Arrays;


public class HomeWork {

    static String[] arrays = {"asd", "asdad", "qwe", "qweas"};
    static Integer[] arr = {1, 2, 3, 4};


    public static <T> void changeElements(T[] array, int firstIndex, int secondIndex){
        try {
            T buff;
            buff = array[firstIndex];
            array[firstIndex] = array[secondIndex];
            array[secondIndex] = buff;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Incorrect arguments.");
        }
    }

    public static <T> ArrayList<T> changeArrToArrlist(T[] array){
        ArrayList<T> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(array));
        return arrayList;
    }

    public static void main(String[] args) {
        changeElements(arrays,0,2);
        System.out.println(Arrays.toString(arrays));
        changeElements(arr,0,2);
        System.out.println(Arrays.toString(arr));
        System.out.println(changeArrToArrlist(arr));
        Box<Apple> appleBox = new Box<Apple>(new Apple());
        appleBox.addObject(new Apple());
        appleBox.addObject(new Apple());
        appleBox.addObject(new Apple());
        appleBox.addObject(new Apple());
        appleBox.addObject(new Apple());
        appleBox.displayBox();
        System.out.println(appleBox.getWeight());
        Box<Orange> orangeBox = new Box<Orange>(new Orange());
        orangeBox.addObject(new Orange());
        orangeBox.addObject(new Orange());
        orangeBox.addObject(new Orange());
        orangeBox.addObject(new Orange());
        orangeBox.displayBox();
        System.out.println(orangeBox.getWeight());
        System.out.println(appleBox.compare(orangeBox));
        Box<Apple> newAppleBox = new Box<Apple>(new Apple());
        newAppleBox.displayBox();
        appleBox.copyBox(newAppleBox);
        appleBox.displayBox();
        newAppleBox.displayBox();
    }
}
