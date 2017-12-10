package ParallelSorting;

import java.util.ArrayList;
import java.util.List;

public class ListToFourList {

    List<Integer> mainList = new ArrayList<>();
    List<Integer> firstList = new ArrayList<>();
    List<Integer> secondList = new ArrayList<>();
    List<Integer> thirdList = new ArrayList<>();
    List<Integer> fourthList = new ArrayList<>();

    public List<Integer> getFirstList(List<Integer> mainList) {
        for (int i = 1; i <= mainList.size()/4;i++) {
            firstList.add(mainList.get(i-1));
        }
        return firstList;
    }
    public List<Integer> getSecondList(List<Integer> mainList) {
        for (int i = mainList.size()/4 +1; i <= mainList.size()/2;i++) {
            secondList.add(mainList.get(i-1));
        }
        return secondList;
    }
    public List<Integer> getThirdList(List<Integer> mainList) {
        for (int i = mainList.size()/2 +1; i <= mainList.size()*3/4;i++) {
            thirdList.add(mainList.get(i-1));
        }
        return thirdList;
    }
    public List<Integer> getFourthListList(List<Integer> mainList) {
        for (int i = mainList.size()*3/4 +1; i <= mainList.size();i++) {
            fourthList.add(mainList.get(i-1));
        }
        return fourthList;
    }

}
