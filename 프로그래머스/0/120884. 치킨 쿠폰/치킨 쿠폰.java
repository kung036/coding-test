class Solution {
    public int solution(int chicken) {
        int answer = 0; // 서비스 치킨 수
        int coupons = chicken; // 처음 받는 쿠폰 수 = 주문한 치킨 수

        while (coupons >= 10) {
            int service = coupons / 10;  // 이번에 받을 서비스 치킨 수
            answer += service;           // 서비스 치킨 누적
            coupons = service + (coupons % 10); // 새 쿠폰(서비스 치킨) + 남은 쿠폰
        }

        return answer;
    }
}
