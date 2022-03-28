package Threads;

import java.util.ArrayList;
import java.util.List;

public class OddEvenSeperator extends Thread {
    List<Integer> mainList;

    //odd ve even sayıları tuttugumuz listeler
    public static List<Integer> oddList = new ArrayList<>();
    public static List<Integer> evenList = new ArrayList<>();

    private static final Object LOCK = new Object();

    int num = 0;

    public OddEvenSeperator(List<Integer> mainList) {
        this.mainList = mainList;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

      // thread geldiğinde diğer threadleri bekleten ve elindeki listedeki sayıları even ve odd listlere dagitan döngü
      for (int i = 0; i < mainList.size(); i++) {
            synchronized (LOCK) {
                num = mainList.get(i);
                if (num % 2 == 0) {
                    evenList.add(num);
                } else {
                    oddList.add(num);
                }
            }
        }
    }

}
