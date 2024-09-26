class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        
        boolean negative = (dividend < 0) ^ (divisor < 0);
        
        
        long dividendL = Math.abs((long)dividend);
        long divisorL = Math.abs((long)divisor);

        int result = 0;

        
        while (dividendL >= divisorL) {
            long tempDivisor = divisorL;
            int multiple = 1;
            
            
            while (dividendL >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }
            
            
            dividendL -= tempDivisor;
            result += multiple;
        }

        
        return negative ? -result : result;
    }
}