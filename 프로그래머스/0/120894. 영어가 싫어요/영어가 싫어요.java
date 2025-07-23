class Solution {
    public long solution(String numbers) {
        String[] str = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length; i++) {
            numbers = numbers.replace(str[i], i+"");
        }
        
        return Long.valueOf(numbers);
    }
}