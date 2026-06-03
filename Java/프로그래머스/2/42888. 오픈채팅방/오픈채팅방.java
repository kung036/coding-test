import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nicknameMap = new HashMap<>();
        int count = 0;

        for (String line : record) {
            String[] arr = line.split(" ");
            String command = arr[0];
            String uid = arr[1];

            if (command.equals("Enter")) {
                nicknameMap.put(uid, arr[2]);
                count++;
            } else if (command.equals("Leave")) {
                count++;
            } else if (command.equals("Change")) {
                nicknameMap.put(uid, arr[2]);
            }
        }

        String[] answer = new String[count];
        int idx = 0;

        for (String line : record) {
            String[] arr = line.split(" ");
            String command = arr[0];
            String uid = arr[1];

            if (command.equals("Enter")) {
                answer[idx++] = nicknameMap.get(uid) + "님이 들어왔습니다.";
            } else if (command.equals("Leave")) {
                answer[idx++] = nicknameMap.get(uid) + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}