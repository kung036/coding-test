package backjoon;//package backjoon;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//
//public class No22861 {
//    static class Folder {
//        String name = "";
//        Set<String> files = new HashSet<>();
//        List<Folder> folders = new ArrayList<>();
//    }
//
//    // main 내 폴더 찾기
//    static Folder findFolder(List<Folder> main, String name) {
//        Folder folder = new Folder();
//
//        for (int i = 0; i < main.size(); i++) {
//            Folder folder1 = main.get(i);
//            if (folder1.name.equals(name)) { // 현재 폴더가 찾는 폴더인 경우
//                folder = main.get(i);
//                break;
//            } else if (!folder1.folders.isEmpty()) { // 현재 폴더 내에 폴더가 더 있는 경우
//                Folder folder2 = findFolder(folder1.folders, name);
//                if (!folder2.name.equals("")) {
//                    folder = folder2;
//                    break;
//                }
//            }
//        }
//
//        return folder;
//    }
//
//    // 현재 폴더 내의 파일의 종류와 개수 구하기
//    static int[] countFolder(Folder folder, List<Folder> folders, int[] count) {
//        // main일 경우
//        if (folder.name != "") {
//            // 파일의 종류 세기
//            count[0] += folder.files.stream().collect(Collectors.toSet()).size();
//            // 파일의 개수 세기
//            count[1] += folder.files.size();
//        }
//
//        for (int i = 0; i < folders.size(); i++) {
//            // 폴더 내부 폴더
//            count = countFolder(folders.get(i), folders.get(i).folders, count);
//        }
//
//        return count;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        List<Folder> main = new ArrayList<>(); // main 폴더
//
//        // 폴더와 파일의 개수 합
//        int count = sc.nextInt() + sc.nextInt();
//        // 현재 main 폴더 내부 구조 구현
//        for (int i = 0; i < count; i++) {
//            String P = sc.next(); // 상위 폴더 이름
//            String F = sc.next(); // 폴더 또는 파일 이름
//            int C = sc.nextInt(); // 1 = 폴더, 0 = 파일
//
//            if (P.equals("main")) { // main 하위 폴더
//                // 폴더 생성
//                Folder folder = new Folder();
//                folder.name = F;
//                // 폴더를 main에 추가
//                main.add(folder);
//            } else if (C == 1) { // 폴더 내부에 있는 폴더
//                // 상위 폴더 찾기
//                Folder folder = findFolder(main, P);
//                // 폴더 생성
//                Folder newFolder = new Folder();
//                newFolder.name = F;
//                // 폴더 내에 새 폴더 추가
//                folder.folders.add(newFolder);
//            } else { // 폴더 내부에 있는 파일
//                // 상위 폴더 찾기
//                Folder folder = findFolder(main, P);
//                // 폴더 내에 새 파일 추가
//                folder.files.add(F);
//            }
//        }
//
//        // 이동횟수
//        count = sc.nextInt();
//        // 폴더 하위 내용 이동하기
//        for (int i = 0; i < count; i++) {
//            // A -> B로 이동하기
//            String[] A = sc.next().split("/");
//            String[] B = sc.next().split("/");
//
//            // folderA와 folderB 찾기
//            List<Folder> highA = main;
//            Folder folderA = findFolder(main, A[1]);
//            for (int j = 2; j < A.length; j++) {
//                highA = folderA.folders;
//                folderA = findFolder(folderA.folders, A[j]);
//            }
//            Folder folderB = findFolder(main, B[1]);
//            for (int j = 2; j < B.length; j++) {
//                folderB = findFolder(folderB.folders, B[j]);
//            }
//
//            // 폴더 내용 이동시키기
//            for (int j = 0; j < folderA.folders.size(); j++) { // 폴더 이동
//                folderB.folders.add(folderA.folders.get(j));
//            }
//            Folder finalFolderB = folderB;
//            folderA.files.stream().forEach(file -> finalFolderB.files.add(file)); // 파일 이동
//            // 폴더 삭제시키기
//            highA.remove(folderA);
//        }
//
//        // 쿼리 출력하기
//        count = sc.nextInt();
//        for (int i = 0; i < count; i++) {
//            String[] folderName = sc.next().split("/");
//            int[] result = new int[]{0, 0};
//
//            // main인 경우
//            if (folderName.length == 1) result = countFolder(new Folder(), main, result);
//            else { // main 이외의 경우
//                Folder folder = findFolder(main, folderName[folderName.length - 1]);
//                result = countFolder(folder, folder.folders, result);
//            }
//
//            // 결과 출력
//            System.out.println(result[0] + " " + result[1]);
//        }
//    }
//}

import java.io.*;
import java.lang.*;
import java.util.*;

public class No22861 {

    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            String s = br.readLine();
            int index = s.indexOf(".");
            String str = s.substring(index+1);
            map.put(str, map.getOrDefault(str, 0)+1);
        }

        Set<String> strings = map.keySet();

        List<String> list = new ArrayList<>(strings);

        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i)+" "+map.get(list.get(i)));
        }
    }
}