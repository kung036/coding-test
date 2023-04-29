package backjoon;//package backjoon;

import java.util.*;
import java.util.stream.Collectors;

public class No22861 {
    // 폴더를 입력받으면, 폴더의 쿼리 반환
    static String findKey(String key, Map<String, Set<String>> map) {
        // key가 포함된 쿼리가 있는 것만 필터링
        List<String> keys = map.keySet().stream().filter(s -> s.contains(key)).collect(Collectors.toList());

        // 상위 폴더가 없는 경우
        if(keys.isEmpty()) return "";

        // 상위 폴더가 있는 경우
        String[] keyArray = keys.get(0).split("/");
        String query = keyArray[0];
        if(!keyArray[0].equals(key)) {
            for(int i=1; i<keyArray.length; i++) {
                query = query + "/" +keyArray[i];
                if(keyArray[i].equals(key)) break;
            }
        }

        return query;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Set<String>> folders = new HashMap<>();
        Map<String, Set<String>> files = new HashMap<>();

        // 폴더와 파일의 개수 합
        int count = sc.nextInt() + sc.nextInt();
        for(int i=0; i<count; i++) {
            String P = sc.next(); // 상위 폴더 이름
            String F = sc.next(); // 폴더 또는 파일 이름
            int C = sc.nextInt(); // 1 = 폴더, 0 = 파일

            // 폴더인 경우
            if(C == 1) {
                // 상위 폴더가 존재하지 않는 경우
                if(folders.get(P) == null) folders.put(P, new HashSet<>());

                folders.put(F, new HashSet<>());
                folders.get(P).add(F);
            } else { // 파일인 경우
                // 폴더가 존재하지 않는 경우
                if(files.get(P) == null) files.put(P, new HashSet<>());

                files.get(P).add(F);
            }
        }

//        System.out.println(folders.entrySet());
//        System.out.println(files.entrySet());

        // 파일 이동
        count = sc.nextInt();
        for(int i=0; i<count; i++) {
            // 폴더A와 폴더B의 폴더 경로의 최종 경로명
            String[] As = sc.next().split("/");
            String[] Bs = sc.next().split("/");
            String A = As[As.length-1];
            String B = Bs[Bs.length-1];
            String highB = Bs[Bs.length-2];

            // 폴더A 내에 있는 폴더들을 폴더B로 옮기기
            Set<String> folderA = folders.get(A);
            Set<String> folderB = folders.get(B);
            if(folderA != null) folderB.addAll(folderA);
            folders.remove(A);
            folders.get(highB).remove(A);

            // 폴더A 내에 있는 파일들을 폴더B로 옮기기
            Set<String> fileA = files.get(A);
            Set<String> fileB = files.get(B);
//            System.out.println("!! " + fileA);
//            System.out.println("!! " + fileB);
            if(!fileA.isEmpty()) fileB.addAll(fileA);
//            System.out.println("!! " + fileB);
            files.remove(A);
        }

//        System.out.println(folders.entrySet());
//        System.out.println(files.entrySet());

        // 폴더 내 파일 종류와 개수 출력하기
        count = sc.nextInt();
        for(int i=0; i<count; i++) {
            Set<String> fileType = new HashSet<>(); // 파일의 종류
            List<String> fileCount = new ArrayList<>(); // 파일의 개수

            // 탐색할 폴더명
            String[] findFolder = sc.next().split("/");
            String findFolderName = findFolder[findFolder.length - 1];

            // 탐색할 폴더 안에 있는 폴더명 검색
            List<String> findFolders = folders.get(findFolderName).stream().collect(Collectors.toList());

            // 탐색한 폴더명으로 하위 폴더 모두 검색
            Queue<String> queue = new LinkedList<>();
            queue.add(findFolderName);
            Queue<String> check = new LinkedList<>();
            check.add(findFolderName);
            while(!check.isEmpty()) {
                String tmp = check.poll();
//                System.out.println("!! chekc : " + tmp);
                if(folders.get(tmp) != null) {
                    List<String> tmpSet = folders.get(tmp).stream().collect(Collectors.toList());
                    for(int j=0; j<tmpSet.size(); j++) {
                        queue.add(tmpSet.get(j));
                        check.add(tmpSet.get(j));
                    }
                }
            }

//            System.out.println("!! 개수 : " + findFolders);
//            System.out.println("!! " + files.keySet());
//            if(files.get(findFolderName) != null) {
//                fileType.addAll(files.get(findFolderName));
//                fileCount.addAll(files.get(findFolderName));
//            }
            while(!queue.isEmpty()) {
                String tmp = queue.poll();
                Set<String> tmpFolder = files.get(tmp);
                if(tmpFolder != null) {
                    fileType.addAll(tmpFolder);
                    fileCount.addAll(tmpFolder);
                }
            }
//            for(int j=0; j<findFolders.size(); j++) {
//                String tmp = findFolders.get(j);
//                Set<String> tmpFolder = files.get(tmp);
//                System.out.println(findFolders.get(j));
//                System.out.println(tmpFolder);
//                System.out.println(files.containsKey(findFolders.get(j)));
//                fileType.addAll(tmpFolder);
//                fileCount.addAll(tmpFolder);
//            }

            System.out.println(fileType.size() + " " + fileCount.size());
        }
    }
}
