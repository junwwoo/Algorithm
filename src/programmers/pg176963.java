package programmers;

import java.util.Arrays;
import java.util.HashMap;

public class pg176963 {
    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {
                {"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"}};
        int[] result = solution(name, yearning, photo);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map = new HashMap<>();
        int[] answer = new int[photo.length];
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (int j = 0; j < photo[i].length; j++) {
                sum = sum + map.getOrDefault(photo[i][j], 0);
            }
            answer[i] = sum;
        }
        return answer;
    }
}
