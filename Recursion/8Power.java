package Recursion;

class Power {
    public static int calculatePower(int base, int power) {
        if (power == 0) {
            return 1;
        }
        return base * calculatePower(base, power - 1);
    }

    public static int optimizedWay(int base, int power) {
        if (power == 0) {
            return 1;
        }
        if (power % 2 == 0) {
            return optimizedWay(base * base, power / 2);
        } else {
            return base * optimizedWay(base, power - 1);
        }
    }

    public static void main(String args[]) {
        System.out.println(calculatePower(3, 2));
        System.out.println(optimizedWay(2, 10));
    }
}
