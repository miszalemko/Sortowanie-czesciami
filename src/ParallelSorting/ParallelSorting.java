package ParallelSorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

//        Zbiór wejściowy dzielimy na 4 części.
//        Każdą część sortujemy w oddzielnym wątku
//        Scalamy uzyskane wyniki: wybieramy pierwszy element z dowolnej części,
//        porównujemy z pozostałymi pierwszymi elementami w pozostałych częściach,
//        po znalezieniu najmniejszego/największego usuwamy go ze zbioru częściowego
//        i przepisujemy do zbioru wynikowego.
public class ParallelSorting {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ListToFourList listToFourList = new ListToFourList();
        ListCreating listCreating = new ListCreating();
        MainSorting mainSorting = new MainSorting();

        List<Integer> mainList;
        List<Integer> firstList;
        List<Integer> secondList;
        List<Integer> thirdList;
        List<Integer> fourthList;
        List<Integer> firstListAfterSorting = new ArrayList<>();
        List<Integer> secondListAfterSorting = new ArrayList<>();
        List<Integer> thirdListAfterSorting = new ArrayList<>();
        List<Integer> fourthListAfterSorting = new ArrayList<>();
        List<Integer> mainhListAfterSorting = new ArrayList<>();

        mainList = listCreating.getMainList();
        firstList = listToFourList.getFirstList(mainList);
        secondList = listToFourList.getSecondList(mainList);
        thirdList = listToFourList.getThirdList(mainList);
        fourthList = listToFourList.getFourthListList(mainList);
        System.out.println(firstList.size() + " " + secondList.size() + " " + thirdList.size() + " " + fourthList.size());


        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Future<List<Integer>> wynik1 = executorService.submit(new Callable<List<Integer>>() {
            @Override
            public List<Integer> call() throws Exception {
                Thread.sleep(1000);
                Collections.sort(firstList);
                return firstList;
            }
        });
        Future<List<Integer>> wynik2 = executorService.submit(() -> {
            Thread.sleep(1000);
            Collections.sort(secondList);
            return secondList;
        });
        Future<List<Integer>> wynik3 = executorService.submit(() -> {
            Thread.sleep(1000);
            Collections.sort(thirdList);
            return thirdList;
        });
        Future<List<Integer>> wynik4 = executorService.submit(() -> {
            Thread.sleep(1000);
            Collections.sort(fourthList);
            return fourthList;
        });
        for(int i = 0; i < wynik1.get().size();i++) {
            firstListAfterSorting.add(wynik1.get().get(i));
        }
        for(int i = 0; i < wynik2.get().size();i++) {
            secondListAfterSorting.add(wynik2.get().get(i));
        }
        for(int i = 0; i < wynik3.get().size();i++) {
            thirdListAfterSorting.add(wynik3.get().get(i));
        }
        for(int i = 0; i < wynik4.get().size();i++) {
            fourthListAfterSorting.add(wynik4.get().get(i));
        }
        executorService.shutdown();
        while(!firstListAfterSorting.isEmpty() && !secondListAfterSorting.isEmpty()
                && !thirdListAfterSorting.isEmpty() && !fourthListAfterSorting.isEmpty() ) {
            mainhListAfterSorting = mainSorting.getMainSortList(firstListAfterSorting,secondListAfterSorting,
                    thirdListAfterSorting,fourthListAfterSorting,mainhListAfterSorting);
        }

        for(int i = 0;i < mainhListAfterSorting.size();i++) {
            System.out.println(mainhListAfterSorting.get(i));
        }

    }

}
