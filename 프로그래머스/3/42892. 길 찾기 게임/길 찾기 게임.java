import java.util.*;

class Solution {
    Map<Integer, List<Integer>> tree = new HashMap<>();
    class Node {
        int x, y, num;
        Node left, right;
        
        Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        // 전위 순회 : root - left - right
        // 후위 순회 : left - right - root
        
        // tree 구현 - 인접 리스트(노드, arraylist)
        // 1. y를 기준으로 정렬이 필요함(내림차순)
        // 2. y가 큰 순으로 순회하면서 x좌표를 이용해서 트리 구현
        // 전위 순회
        // 후위 순회
        int[][] answer = new int[2][];
        
        // Node 구체화하기
        Node[] tree = new Node[nodeinfo.length];
        for(int i=0; i<nodeinfo.length; i++) {
            int[] node = nodeinfo[i];
            tree[i] = new Node(node[0], node[1], i+1);
        }

        // y를 기준으로 내림차순하기
        Arrays.sort(tree, (o1, o2) -> {
            if(o1.y == o2.y) {
                return Integer.compare(o1.x, o2.x);
            }
            return Integer.compare(o2.y, o1.y);
        });
        
        // tree 구현하기
        Node root = tree[0];
        for(int i=1; i<tree.length; i++) {
            Node parent = root;
            Node cur = tree[i];
            
            while(true) {
                if(cur.x < parent.x) {
                    if(parent.left == null) {
                        parent.left = cur;
                        break;
                    }
                    parent = parent.left;
                } else {
                    if(parent.right == null) {
                        parent.right = cur;
                        break;
                    }
                    parent = parent.right;
                }
            }
        }
        
        // 전위 순회
        answer[0] = preorder(root, new ArrayList<>()).stream().mapToInt(Integer::intValue).toArray();
        
        // 후위 순회
        answer[1] = postorder(root, new ArrayList<>()).stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
    
    // 전위 순회
    public List<Integer> preorder(Node node, List<Integer> list) {
        list.add(node.num);
        if(node.left != null) preorder(node.left, list);
        if(node.right != null) preorder(node.right, list);
            
        return list;
    }

    // 후위 순회
    public List<Integer> postorder(Node node, List<Integer> list) {
        if(node.left != null) postorder(node.left, list);
        if(node.right != null) postorder(node.right, list);
        list.add(node.num);
            
        return list;        
    }
}