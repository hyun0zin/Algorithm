import java.util.*;

class Solution {
    
    static class Task {
        String name;
        int startTime; // 시작 시각 (분 단위)
        int playTime;  // 소요 시간 (분 단위)
        
        Task(String name, int startTime, int playTime) {
            this.name = name;
            this.startTime = startTime;
            this.playTime = playTime;
        }
    }
    
    public String[] solution(String[][] plans) {
        // Task 리스트로 변환
        List<Task> tasks = new ArrayList<>();
        for (String[] plan : plans) {
            String name = plan[0];
            String time = plan[1];
            int playTime = Integer.parseInt(plan[2]);
            
            int hh = Integer.parseInt(time.split(":")[0]);
            int mm = Integer.parseInt(time.split(":")[1]);
            int startTime = 60 * hh + mm;
            
            tasks.add(new Task(name, startTime, playTime));
        }
        
        // 시작 시각 기준으로 정렬
        tasks.sort(Comparator.comparingInt(t -> t.startTime));
        
        Stack<Task> stack = new Stack<>(); // 멈춘 과제를 저장할 스택
        List<String> result = new ArrayList<>(); // 완료된 과제 이름 저장
        
        int currentTime = 0; // 현재 시간
        for (int i = 0; i < tasks.size(); i++) {
            Task currentTask = tasks.get(i);
            
            // 현재 시간에 맞게 이전 과제를 완료하거나 멈춤 처리
            while (!stack.isEmpty() && currentTime < currentTask.startTime) {
                Task pausedTask = stack.pop();
                int remainingTime = pausedTask.playTime - (currentTask.startTime - currentTime);
                if (remainingTime <= 0) {
                    result.add(pausedTask.name); // 과제 완료
                    currentTime += pausedTask.playTime;
                } else {
                    // 남은 시간이 있으면 다시 스택에 저장
                    pausedTask.playTime = remainingTime;
                    stack.push(pausedTask);
                    currentTime = currentTask.startTime;
                    break;
                }
            }
            
            // 새로운 과제 시작
            currentTime = currentTask.startTime;
            if (i < tasks.size() - 1 && currentTime + currentTask.playTime > tasks.get(i + 1).startTime) {
                // 다음 과제 시작 시간보다 오래 걸리면 멈춤 처리
                currentTask.playTime -= (tasks.get(i + 1).startTime - currentTime);
                stack.push(currentTask);
                currentTime = tasks.get(i + 1).startTime;
            } else {
                // 과제 완료
                result.add(currentTask.name);
                currentTime += currentTask.playTime;
            }
        }
        
        // 멈춘 과제 처리
        while (!stack.isEmpty()) {
            result.add(stack.pop().name);
        }
        
        // 결과를 배열로 변환
        return result.toArray(new String[0]);
    }
}
