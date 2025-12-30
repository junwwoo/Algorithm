package programmers;

public class pg172928 {
    public static void main(String[] args) {
    }

    public int[] solution(String[] park, String[] routes) {
        int x = 0, y = 0;

        int W = park[0].length() - 1;
        int H = park.length - 1;

        for (int i = 0; i < park.length; i++) {
            int idx = park[i].indexOf('S');
            if (idx != -1) {
                y = i;
                x = idx;
                break;
            }
        }

        for (int i = 0; i < routes.length; i++) {
            String[] tempRoute = routes[i].split(" ");
            char op = tempRoute[0].charAt(0);
            int n = Integer.parseInt(tempRoute[1]);

            int tx = x, ty = y;

            if (op == 'E')
                tx = x + n;
            else if (op == 'W')
                tx = x - n;
            else if (op == 'S')
                ty = y + n;
            else if (op == 'N')
                ty = y - n;

            if (tx < 0 || tx > W || ty < 0 || ty > H)
                continue;

            boolean pass = false;

            if (tx >= x) {
                if (park[y].substring(x, tx + 1).indexOf('X') != -1)
                    pass = true;
            } else if (tx < x) {
                if (park[y].substring(tx, x + 1).indexOf('X') != -1)
                    pass = true;
            }

            if (ty >= y) {
                for (int sec = y; sec <= ty; sec++) {
                    if (park[sec].charAt(x) == 'X')
                        pass = true;
                }
            } else if (ty < y) {
                for (int sec = ty; sec <= y; sec++) {
                    if (park[sec].charAt(x) == 'X')
                        pass = true;
                }
            }

            if (pass == true)
                continue;

            x = tx;
            y = ty;
        }
        int[] result = new int[2];
        result[0] = y;
        result[1] = x;

        return result;
    }
}
