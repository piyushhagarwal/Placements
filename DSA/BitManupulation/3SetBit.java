package BitManupulation;

class SetBit {

    public static void main(String args[]) {
        int a = 12; // 1100
        int posision = 1; // 2nd bit from right

        // Step 1: Create a bitmask with 1 at the specified position
        int bitmask = 1 << posision; // 0010

        // Step 2: Perform or operation with the number
        int bit = a | bitmask; // 1110

        System.out.println(bit);
    }
}
