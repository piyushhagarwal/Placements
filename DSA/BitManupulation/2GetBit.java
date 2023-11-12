package BitManupulation;

class GetBit {
    public static void main(String args[]) {
        // Get Bit: It returns the bit at the specified position.
        int a = 12; // 1100
        int position = 2; // 3rd bit from right

        // Step 1: Create a bitmask with 1 at the specified position
        int bitmask = 1 << position; // 0100

        // Step 2: Perform and operation with the number
        int bit = a & bitmask; // 0000

        if (bit == 0) {
            System.out.println("Bit is 0");
        } else {
            System.out.println("Bit is 1");
        }
    }
}
