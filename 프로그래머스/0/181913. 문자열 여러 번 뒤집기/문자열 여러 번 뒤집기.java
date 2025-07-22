class Solution {
    public String solution(String my_string, int[][] queries) {
        // 문자열을 문자 배열로 변환
        char[] arr = my_string.toCharArray();

        // 각 쿼리마다 [s, e] 구간을 뒤집기
        for (int[] query : queries) {
            int s = query[0];
            int e = query[1];
            while (s < e) {
                char tmp = arr[s];
                arr[s] = arr[e];
                arr[e] = tmp;
                s++;
                e--;
            }
        }
        // 문자 배열을 다시 문자열로 변환
        return new String(arr);
    }
}
