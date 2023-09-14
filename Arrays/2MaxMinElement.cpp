// Maximum and minimum of an array using minimum number of comparisons

#include <iostream>
using namespace std;

int maxElement(int input_array[], int size)
{
    int max_element = INT32_MIN;
    for (int i = 0; i < size; i++)
    {
        if (input_array[i] > max_element)
        {
            max_element = input_array[i];
        }
    }
    return max_element;
}

int minElement(int input_array[], int size)
{
    int min_element = INT32_MAX;
    for (int i = 0; i < size; i++)
    {
        if (input_array[i] < min_element)
        {
            min_element = input_array[i];
        }
    }
    return min_element;
}
// Another approach is sort the array and then the first element would be the smallest and last will be the largest.

int main()
{
    int input_array[] = {2, 4, 5, 2, 77, 1};
    int size = sizeof(input_array) / sizeof(input_array[0]);
    int max_element = maxElement(input_array, size);
    int min_element = minElement(input_array, size);
}