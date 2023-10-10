class Solution {
    public double myPow(double x, int n) {
        // Convert n to long to handle overflow for minimum integer value
        long nn = n;

        // If the exponent is negative, convert it to positive
        if (nn < 0) {
            nn = nn * -1;
        }

        // Initialize the result to 1
        double ans = 1;

        // Iterate through the bits of nn
        while (nn > 0) {
            // If the current bit is 1, multiply ans by x
            if (nn % 2 == 1) {
                ans = ans * x;
                // Reduce nn by 1 (corresponds to the current bit)
                nn = nn - 1;
            } else {
                // If the current bit is 0, square x and divide nn by 2
                x = x * x;
                nn = nn / 2;
            }
        }

        // If the original exponent was negative, return the reciprocal of ans
        if (n < 0) {
            return 1 / ans;
        }

        // Otherwise, return the calculated result
        return ans;
    }
}
