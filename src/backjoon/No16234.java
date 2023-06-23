package backjoon;

import java.util.*;

public class No16234 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 땅의 크기 NxN
        int L = sc.nextInt(); // 인접국의 인원수 차이가 L 이상
        int R = sc.nextInt(); // 인접국의 인원수 차이가 R 이하

        int count = 0; // 연합국가
        int[][] persons = new int[N][N]; // 인구수
        int[][] unitedCheck = new int[N][N]; // 연합 여부
        Map<Integer, int[]> unitedPerson; // 연합국 끼리의 횟수(연합 번호, 연합국 개수, 인구수합)
        boolean[][] visited = new boolean[N][N]; // 방문여부
        int result = 0; // 인구 이동 날짜
        int[] dx = new int[] {0, 0, 1, -1};
        int[] dy = new int[] {1, -1, 0, 0};

        Queue<Integer> queue = new LinkedList<>();

        // 인구수 배열 생성
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                persons[i][j] = sc.nextInt();
            }
        }

        // 무한 반복
        while(true) {
            unitedPerson = new HashMap<>();
//            visited = new boolean[N][N];
            for(int i=0; i<unitedCheck.length; i++) {
                Arrays.fill(visited[i], false);
                Arrays.fill(unitedCheck[i], -1);
            }
            queue.offer(0);
            queue.offer(0);
            count = 0;

            // 연합하는 국가 지정
            while(!queue.isEmpty()) {
                int x = queue.poll();
                int y = queue.poll();
                visited[y][x] = true;

                for(int i=0; i<dx.length; i++) {
                    int move_x = x+dx[i];
                    int move_y = y+dy[i];

                    if(0<=move_x && 0<=move_y && move_x<N && move_y<N) {
                        if(!visited[move_y][move_x]) {
                            queue.offer(move_x);
                            queue.offer(move_y);

                            // 인원수 차이 L 이상, R 이하
                            int diff_person = Math.abs(persons[move_y][move_x] - persons[y][x]);
                            System.out.printf("current : %d %d, move : %d %d, diff : %d\n", y, x, move_y, move_x, diff_person);
                            if(L<=diff_person && diff_person<=R) {
                                if(unitedCheck[move_y][move_x] == -1 && unitedCheck[y][x] == -1) { // 첫 연합국인 경우
                                    unitedCheck[move_y][move_x] = count;
                                    unitedCheck[y][x] = count;
                                    unitedPerson.put(count, new int[]{2, persons[move_y][move_x]+persons[y][x]});
                                    System.out.println("!! " + count + " " + Arrays.toString(unitedPerson.get(count)));
                                    count++;
                                } else if(unitedCheck[move_y][move_x] == -1 || unitedCheck[y][x] == -1){ // 새로운 연합국이 추가된 경우
                                    int new_count = Math.max(unitedCheck[move_y][move_x], unitedCheck[y][x]);
                                    int add = unitedCheck[move_y][move_x] == -1 ? persons[y][x] : persons[move_y][move_x];
                                    unitedCheck[move_y][move_x] = new_count;
                                    unitedCheck[y][x] = new_count;
                                    unitedPerson.replace(new_count, new int[]{unitedPerson.get(new_count)[0]+1, unitedPerson.get(new_count)[1] + add});
                                    System.out.println("!! " + new_count + " " + Arrays.toString(unitedPerson.get(new_count)));
                                }
                            }
                        }
                    }
                }
            }

            // 분기문
            if(count == 0) break;
            result++;

            // 연합국에 따른 인구수 조정
            int[] changePerson = new int[N];
            for(int i=0; i<unitedPerson.size(); i++) {
                changePerson[i] = unitedPerson.get(i)[1]/unitedPerson.get(i)[0];
                System.out.println("!! " + changePerson[i]);
            }
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(unitedCheck[i][j] != -1) {
                        int index = unitedCheck[i][j];
                        persons[i][j] = changePerson[index];
                    }
                    System.out.print(persons[i][j] + " ");
                }
                System.out.println();
            }
        }

        System.out.println(result);
    }
}
