//Given that there are N books and M students. 
//Also given are the number of pages in each book in ascending order. 
//Book allocation is in contiguous manner
//The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum, with the condition that every student is assigned to read some consecutive books. 
//Print that minimum number of pages.

// Input: N = 4, pages[] = {12, 34, 67, 90}, M = 2

// Output: 113

// Explanation: There are 2 number of students. Books can be distributed in following combinations: 

// [12] and [34, 67, 90] -> Max number of pages is allocated to student ‘2’ with 34 + 67 + 90 = 191 pages
// [12, 34] and [67, 90] -> Max number of pages is allocated to student ‘2’ with 67 + 90 = 157 pages 
// [12, 34, 67] and [90] -> Max number of pages is allocated to student ‘1’ with 12 + 34 + 67 = 113 pages
// Of the 3 cases, Option 3 has the minimum pages = 113.

//Hard level question

package BinarySearch;

class BookAllocation {

    static int countStudents(int pagesArr[], int mid) {
        int count = 1;
        int slotSum = 0;
        for (int i = 0; i < pagesArr.length; i++) {
            if (slotSum + pagesArr[i] <= mid) {
                slotSum += pagesArr[i];
            } else {
                count++;
                slotSum = pagesArr[i];
            }
        }
        return count;

    }

    static int findPages(int pagesArr[], int m) {
        int sum = 0;
        for (int num : pagesArr) {
            sum += num;
        }
        int max = pagesArr[0];
        for (int i = 1; i < pagesArr.length; i++) {
            if (pagesArr[i] > max) {
                max = pagesArr[i];
            }
        }

        int start = max; // Max element in the array
        int end = sum;
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int students = countStudents(pagesArr, mid);
            if (students > m) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        int arr[] = { 25, 46, 28, 49, 24 };
        System.out.println(findPages(arr, 4));

    }
}
