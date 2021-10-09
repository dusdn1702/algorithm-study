public class 부족한_금액_계산 {
    class Solution {
        public long solution(int price, int money, int count) {
            long total = 0;
            for(int i = 1; i<= count; i++) {
                total += i*price;
            }
            if(total <= money) {
                return 0;
            }
            return total - money;
        }
    }
}
