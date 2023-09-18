// Move all negative numbers to beginning and positive to end with constant extra space
// Dutch national flag approach
// More detailed solution: https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/

#include <iostream>
using namespace std;

void NegativeOneSide(int arr[], int n)
{
    int neg = 0;
    int mid = 0;
    int pos = n - 1;
    while (mid <= pos)
    {
        if (arr[mid] < 0)
        {
            swap(arr[neg], arr[mid]);
            neg++;
            mid++;
        }
        else if (arr[mid] > 0)
        {
            swap(arr[mid], arr[pos]);
            pos--;
        }
        else
        {
            mid++;
        }
    }
}

int main()
{
    int arr1[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
    int n1 = sizeof(arr1) / sizeof(arr1[0]);

    NegativeOneSide(arr1, n1);

    // Print sorted arrays
    for (int i = 0; i < n1; i++)
        cout << arr1[i] << " ";
    cout << std::endl;

    return 0;
}