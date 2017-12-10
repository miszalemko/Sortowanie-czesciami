package ParallelSorting;

import java.util.ArrayList;
import java.util.List;

public class MainSorting {
    private List<Integer> mainList = new ArrayList<>();

    public List<Integer> getMainSortList(List<Integer> firstList,List<Integer> secondList,
                                         List<Integer> thirdList,List<Integer> fourthList,List<Integer> mainList) {
        if(firstList.get(0) < secondList.get(0) && firstList.get(0) < thirdList.get(0) && firstList.get(0) < fourthList.get(0)){
            mainList.add(firstList.get(0));
            firstList.remove(0);
        }else if(secondList.get(0) < firstList.get(0) && secondList.get(0) < thirdList.get(0) && secondList.get(0) < fourthList.get(0)) {
            mainList.add(secondList.get(0));
            secondList.remove(0);
        } else if(thirdList.get(0) < firstList.get(0) && thirdList.get(0) < secondList.get(0) && thirdList.get(0) < fourthList.get(0)) {
            mainList.add(thirdList.get(0));
            thirdList.remove(0);
        } else {
            mainList.add(fourthList.get(0));
            fourthList.remove(0);
        }
        return mainList;
    }
}



