package BitManupulation;

class ClearBit {
    public static void main(String args[]) {
        int a = 12; // 1100
        int posision = 2; // 3rd bit from right

        // Step 1: Create a bitmask with 1 at the specified position
        int bitmask = 1 << posision; // 0100

        // Step 2: Perforn negation on the bitmask
        bitmask = ~bitmask; // 1011

        // Set 3: Perform and operation with the number
        int bit = a & bitmask; // 1000

        System.out.println(bit); // 8
    }
}