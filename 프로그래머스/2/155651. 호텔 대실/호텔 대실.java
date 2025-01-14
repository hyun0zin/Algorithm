import java.util.*;
class Solution {
    public static class Time {
        int startTime;
        int endTime;
        
        public Time(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        List<Time> bookList = new LinkedList<>();
        for(int i=0; i<book_time.length; i++){
            String[] time = book_time[i];
            String st = time[0];
            String et = time[1];
            int st_hh = Integer.parseInt(st.split(":")[0]);
            int st_mm = Integer.parseInt(st.split(":")[1]);
            int et_hh = Integer.parseInt(et.split(":")[0]);
            int et_mm = Integer.parseInt(et.split(":")[1]);
            
            bookList.add(new Time(st_hh * 60 + st_mm, et_hh * 60 + et_mm ));  
        }
        
        //시작 시간 기준 정렬
        bookList.sort((o1, o2) -> o1.startTime - o2.startTime);
        
        // 우선순위 큐에 넣기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(Time time : bookList){
            // 객실 재사용
            if(!pq.isEmpty() && pq.peek() + 10 <= time.startTime ){
                pq.poll();
            }
            
            // 새로운 예약 추가
            pq.add(time.endTime);
        }
         
        answer = pq.size();

        return answer;
    }
}