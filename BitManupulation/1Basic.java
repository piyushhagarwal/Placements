package BitManupulation;

class Basic {
    public static void main(String args[]) {
        // Pre-increment operator: It increments the value of variable by 1 and then
        // assigns the value to the variable.
        int a = 10;
        int b = ++a;
        System.out.println(a + " " + b);// 11 11

        // Post-increment operator: It assigns the value to the variable and then
        // increments the value of variable by 1.
        int c = 10;
        int d = c++;
        System.out.println(c + " " + d);// 11 10

        // and operator(&): 0 & 0 = 0, 0 & 1 = 0, 1 & 0 = 0, 1 & 1 = 1
        int e = 10; // 1010
        int f = 5; // 0101
        int g = e & f; // 0000
        System.out.println(g); // 0

        // or operator(|): 0 | 0 = 0, 0 | 1 = 1, 1 | 0 = 1, 1 | 1 = 1
        int h = 10; // 1010
        int i = 5; // 0101
        int j = h | i; // 1111
        System.out.println(j); // 15

        // xor operator(^): 0 ^ 0 = 0, 0 ^ 1 = 1, 1 ^ 0 = 1, 1 ^ 1 = 0 (same = 0,
        // different = 1)
        int k = 10; // 1010
        int l = 6; // 0110
        int m = k ^ l; // 1100
        System.out.println(m); // 12

        // left shift operator(<<): Shifts the bits of the number to the left and fills
        // 0 on voids left as a result. Similar effect as of multiplying the number with
        // some power of two.
        int p = 10; // 1010
        int q = p << 2; // 101000
        System.out.println(q); // 40

        // right shift operator(>>): Shifts the bits of the number to the right and
        // fills 0 on voids left as a result. Similar effect as of dividing the number
        // with some power of two.
        int r = 10; // 1010
        int s = r >> 2; // 10
        System.out.println(s); // 2

        // not operator(~): ~0 = 1, ~1 = 0 It is used to convert negative numbers to
        // positive numbers and positive numbers to negative numbers.
        int n = 10; // 0000 0000 0000 0000 0000 0000 0000 1010
        int o = ~n; // 1111 1111 1111 1111 1111 1111 1111 0101
        System.out.println(o); // -11

    }
}
