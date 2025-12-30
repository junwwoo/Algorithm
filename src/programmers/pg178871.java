package programmers;

import java.util.HashMap;

public class pg178871 {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<players.length; i++){
            map.put(players[i], i);
        }

        for(int i=0; i<callings.length; i++){
            int player1 = map.get(callings[i]);
            int player2 = player1-1;
            map.put(players[player1], player1-1);
            map.put(players[player2], player2+1);

            String temp = players[player1];
            players[player1] = players[player2];
            players[player2] = temp;
        }
        return players;
    }
}
