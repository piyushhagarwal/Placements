// Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.
// In O(n) time complexity
// It is known as Dutch national flag problem(https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/)
#include <iostream>
using namespace std;

void sort012(int a[], int arr_size)
{
    int lo = 0;
    int hi = arr_size - 1;
    int mid = 0;

    // Iterate till all the elements
    // are sorted
    while (mid <= hi)
    {
        switch (a[mid])
        {

        // If the element is 0
        case 0:
            swap(a[lo], a[mid]);
            lo++;
            mid++;
            break;

        // If the element is 1 .
        case 1:
            mid++;
            break;

        // If the element is 2
        case 2:
            swap(a[mid], a[hi]);
            hi--;
            break;
        }
    }
}

// Function to print array arr[]
void printArray(int arr[], int arr_size)
{
    // Iterate and print every element
    for (int i = 0; i < arr_size; i++)
        cout << arr[i] << " ";
}

int main()
{
    int arr1[] = {0, 1, 2, 0, 1, 2};
    int n1 = sizeof(arr1) / sizeof(arr1[0]);

    int arr2[] = {2, 2, 1, 1, 0, 0};
    int n2 = sizeof(arr2) / sizeof(arr2[0]);

    int arr3[] = {1, 0, 2, 1, 0};
    int n3 = sizeof(arr3) / sizeof(arr3[0]);

    sort012(arr1, n1);
    sort012(arr2, n2);
    sort012(arr3, n3);

    // Print sorted arrays
    for (int i = 0; i < n1; i++)
        std::cout << arr1[i] << " ";
    std::cout << std::endl;

    for (int i = 0; i < n2; i++)
        std::cout << arr2[i] << " ";
    std::cout << std::endl;

    for (int i = 0; i < n3; i++)
        std::cout << arr3[i] << " ";
    std::cout << std::endl;

    return 0;
}