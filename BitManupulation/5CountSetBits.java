package BitManupulation;

class CountSetBits {
    public static int countSetBits(int N) {
        int count = 0;
        while (N > 0) {
            if ((N & 1) == 1) {
                count++;
            }
            N = N >> 1;
        }
        return count;
    }

    public static void main(String args[]) {
        int N = 13;
        System.out.println(countSetBits(N));
    }
}
