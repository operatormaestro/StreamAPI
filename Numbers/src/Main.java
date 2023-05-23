import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        ArrayList<Integer> result = new ArrayList<>();
        for (int a : intList) {
            if (a > 0 && a % 2 == 0) {
                result.add(a);
            }
        }
        Collections.sort(result);
        for (int a : result) {
            System.out.println(a);
        }
    }
}