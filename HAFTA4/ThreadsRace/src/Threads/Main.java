package Threads;

import java.util.ArrayList;
import java.util.List;

import static Threads.OddEvenSeperator.evenList;
import static Threads.OddEvenSeperator.oddList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //10000'e kadar olan sayılardan olusan liste
        List<Integer> baseList = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            baseList.add(i);
        }

        //baseList'in 2500 elemanlık 4 alt listesi
        List<Integer> firstList = baseList.subList(0, 2500);
        List<Integer> secondList = baseList.subList(2500, 5000);
        List<Integer> thirdList = baseList.subList(5000, 7500);
        List<Integer> fourthList = baseList.subList(7500, 10000);

        OddEvenSeperator oddEvenSeperator1 = new OddEvenSeperator(firstList);
        OddEvenSeperator oddEvenSeperator2 = new OddEvenSeperator(secondList);
        OddEvenSeperator oddEvenSeperator3 = new OddEvenSeperator(thirdList);
        OddEvenSeperator oddEvenSeperator4 = new OddEvenSeperator(fourthList);

        //4 listedeki odd ve even sayıları bulacak threadler
        Thread first = new Thread(oddEvenSeperator1);
        Thread second = new Thread(oddEvenSeperator2);
        Thread third = new Thread(oddEvenSeperator3);
        Thread fourth = new Thread(oddEvenSeperator4);

        first.start();
        second.start();
        third.start();
        fourth.start();

        first.join();
        second.join();
        third.join();
        fourth.join();

        System.out.println("Odd Numbers:");
        System.out.println(oddList);
        System.out.println("odd list size: "+ oddList.size());
        System.out.println("-----------------------------------------");
        System.out.println("Even Numbers:");
        System.out.println(evenList);
        System.out.println("even list size: "+ evenList.size());

    }
}
