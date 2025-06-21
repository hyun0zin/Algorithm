import java.util.*;

class Solution {
    static class Node {
        int index;
        Node prev, next;
        
        Node(int index){
            this.index = index;
        } 
    }
    
    public String solution(int n, int k, String[] cmd) { 
        // 1. 연결 리스트 구현
        Node[] nodes = new Node[n];
        
        boolean[] isDeleted = new boolean[n];
        
        for(int i=0; i<n; i++){
            nodes[i] = new Node(i);
        }
        
        // 2. prev 노드, next 노드 연결하기
        for(int i=1; i<n; i++){
           nodes[i].prev = nodes[i-1];
           nodes[i-1].next = nodes[i];
        }
        
        // 3. 현재 노드 확인
        Node currNode = nodes[k];
        
        // 삭제할 노드 쌓을 스택 구현
        Stack<Node> deletedRow = new Stack<>();
        
        // 4. 명령어 진행
        for(String c : cmd){
            String[] parts = c.split(" ");
            String command = parts[0];
            
            
            switch(command){
                case "U" :
                    int X = Integer.parseInt(parts[1]);
                    // 이렇게 index만 이동 시킬 경우, 중간 행이 삭제되면 연결된 노드가 끊어질 수 있다.
                    // currNode = nodes[k-X];
                    
                    // U을 2번 할 경우, 2번 노드를 반복해서 이전 노드를 바꿔서 연결해준다. 
                    while(X-- > 0){
                        currNode = currNode.prev;
                    }
                    break;
                case "D" : 
                    int Y = Integer.parseInt(parts[1]);
                    // currNode = nodes[k+Y];
                    
                    while(Y-- > 0){
                        currNode = currNode.next;
                    }
                    break;
                case "C" : 
                    // 1) 현재 행 삭제 => 삭제 스택에 넣기
                    deletedRow.push(currNode);
                    isDeleted[currNode.index] = true;
                    
                    // 2) 앞 뒤 노드 연결하기
                    if(currNode.prev != null){
                        currNode.prev.next = currNode.next;
                    }
                    if(currNode.next != null){
                        currNode.next.prev = currNode.prev;
                    }
                    
                    // 3) 현재 노드 설정하기
                    currNode = (currNode.next != null) ? currNode.next : currNode.prev; 
                    break;
                case "Z" : 
                    // 1) 가장 최근 삭제된 항목부터 복구
                    Node restoreNode = deletedRow.pop();
                    isDeleted[restoreNode.index] = false;
                    
                    // 2) 다시 앞 뒤 노드 연결하기
                    if(restoreNode.prev != null){
                        restoreNode.prev.next = restoreNode;
                    }
                    if(restoreNode.next != null){
                        restoreNode.next.prev = restoreNode;
                    }
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++){
            if(isDeleted[i]){
                sb.append('X');
            }else{
                sb.append('O');
            }
        }
        
        
        return sb.toString();
    }
}