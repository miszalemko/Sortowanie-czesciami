package ParallelSorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListCreating {
    private List<Integer> mainList = new ArrayList<>();
    private Random random = new Random();
    private final int N = 100;

    public List<Integer> getMainList() {
        for (int i = 0;i < N;i++) {
            mainList.add(random.nextInt());
        }
        return mainList;
    }
}
