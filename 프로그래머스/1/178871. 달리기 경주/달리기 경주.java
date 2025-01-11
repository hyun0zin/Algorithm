import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // 선수 이름을 인덱스에 매핑하는 HashMap
        HashMap<String, Integer> playerIndex = new HashMap<>();
        
        // players 배열을 순회하여 선수 이름과 인덱스를 매핑
        for (int i = 0; i < players.length; i++) {
            playerIndex.put(players[i], i);
        }
        
        // callings 배열을 순회하여 순위를 변경
        for (String name : callings) {
            int idx = playerIndex.get(name); // 호출된 선수의 인덱스
            
            // 호출된 선수와 그 앞의 선수의 인덱스 교환
            if (idx > 0) {
                String prevPlayer = players[idx - 1];
                
                // 선수들 배열에서 자리 바꾸기
                players[idx] = prevPlayer;
                players[idx - 1] = name;
                
                // HashMap에서 인덱스 업데이트
                playerIndex.put(name, idx - 1);
                playerIndex.put(prevPlayer, idx);
            }
        }
        
        return players;
    }
}
