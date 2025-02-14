class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        int sum = new StringBuilder(String.valueOf(x)).chars().map(Character::getNumericValue).sum();
        if(x%sum == 0) answer = true;
        
        return answer;
    }
}