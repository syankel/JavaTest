import java.util.ArrayList;
import java.util.List;

public class PartTwo {

    public static List<List<Integer>> strictlyIncreasing(int[] arr) {
        int[] arr_monim = new int[10];
        int i, InteractionIndex = 0;
        boolean isAllEmpty = false, notFinishInteraction;
        List<List<Integer>> result = new ArrayList<>();

        for (i = 0; i < arr.length; arr_monim[arr[i]]++, i++);

        while (!isAllEmpty) {
            notFinishInteraction = false;
            result.add(new ArrayList<>());
            for (i = 1; i < arr_monim.length; i++) {
                if (arr_monim[i] > 0) {
                    result.get(InteractionIndex).add(i);
                    arr_monim[i]--;
                    if (arr_monim[i] > 0) {
                        notFinishInteraction = true;
                    }
                }
            }
            if (!notFinishInteraction) {
                isAllEmpty = true;
            } else {
                InteractionIndex++;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 2, 6, 2, 9, 6, 2 };
        System.out.println(strictlyIncreasing(arr));
    }
}
