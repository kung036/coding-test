import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        // 우선순위 큐 구하기
        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if(o1[col-1] == o2[col-1]) return Integer.compare(o2[0], o1[0]);
            return Integer.compare(o1[col-1], o2[col-1]);
        });
        
        for(int[] d : data) {
            q.add(d);
        }
        
        // S_i 구하기
        int idx = 1;
        int[] answer = new int[row_end - row_begin + 1];
        while(true) {
            int[] current = q.poll();
            if(row_begin <= idx) { // row_begin과 row_end 사이
                for(int i=0; i<current.length; i++) {
                    answer[idx - row_begin] += current[i] % idx;
                }
            }
            
            if(row_end == idx) break;
            idx++;
        }

        // 2진수값 구하기
        Arrays.sort(answer);
        String[] binary = new String[answer.length];
        int maxLength = Integer.toString(answer[answer.length-1], 2).length();
        for(int i=answer.length-1; 0<=i; i--) {
            String b = Integer.toString(answer[i], 2);
            if(b.length() < maxLength) b = "0".repeat(maxLength-b.length()) + b;
            binary[i] = b;
        }
        // System.out.println(Arrays.toString(binary));
        
        // XOR 하기
        String result = "";
        for(int i=0; i<maxLength; i++) {
            int b = Integer.valueOf(binary[0].charAt(i) + "");
            for(int j=1; j<binary.length; j++) {
                b ^= Integer.valueOf(binary[j].charAt(i) + "");
            }
            result = result + b;
            // System.out.println(result);
        }
        
        return Integer.valueOf(result, 2);
    }
}