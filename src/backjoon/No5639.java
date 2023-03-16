package backjoon;

import java.io.*;

// 이진 검색 트리
public class No5639 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num;

        // 루트 생성하기
        Node bst = new Node(Integer.valueOf(br.readLine())); // 이진 탐색 트리 구현체

        // 입력이 있을때까지 반복을 통해서 이진 검색 트리 구현하기
        while((num = br.readLine()) != null) {
            bst.insert(bst, Integer.valueOf(num)); // 입력값을 트리에 추가하기
        }

        bst.postOrderPrint(bst); // 이진 탐색 트리의 후위순회 출력하기
    }

    public static class Node {
        private int value; // 노드의 값
        private Node LeftNode; // 왼쪽 노드 주소
        private Node RightNode; // 오른쪽 노드 주소

        public Node() {} // 생성자

        public Node(int value) { // value값을 지정하는 생성자
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static void insert(Node node, int num) { // 노드 추가하기(num은 추가한 value의 값)
            if(num < node.value) {
                if(node.LeftNode == null) node.LeftNode = new Node(num);
                else insert(node.LeftNode, num);
            } else {
                if(node.RightNode == null) node.RightNode = new Node(num);
                else insert(node.RightNode, num);
            }
        }

        // 이진 탐색 트리의 후위 순회 출력하기
        public static void postOrderPrint(Node node) {
            if(node.LeftNode != null) postOrderPrint(node.LeftNode);
            if(node.RightNode != null) postOrderPrint(node.RightNode);
            System.out.println(node.value);
        }
    }
}
