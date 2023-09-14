// Given an array (or string), the task is to reverse the array/string.
#include <iostream>
using namespace std;

// This approach I tried on my own for which i had to create a new variable and its not optimal
int *reverse_array(int input_array[], int size)
{
    int *result = new int[size];
    for (int i = 0; i < size; i++)
    {
        result[size - 1 - i] = input_array[i];
    }
    return result;
}

// Optimal approach(Time complexity: O(n) and Space complexity: O(1) )
void reverse_array_optimal(int input_array[], int start, int end)
{
    while (start < end)
    {
        int temp = input_array[start];
        input_array[start] = input_array[end];
        input_array[end] = temp;
        start++;
        end--;
    }
}

int main()
{
    int input_array[] = {1, 2, 3};
    int size = sizeof(input_array) / sizeof(input_array[0]); // sizeof method returns size of array in bytes
    // int *output_array = reverse_array(input_array, size);
    reverse_array_optimal(input_array, 0, size - 1);
    for (int i = 0; i < size; i++)
    {
        cout << input_array[i] << endl;
    }
}