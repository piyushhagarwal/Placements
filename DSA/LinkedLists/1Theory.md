## Linked List

### Advantages of Linked List over Array

- Dynamic size
- Ease of insertion/deletion from any position as we don’t need to shift elements unlike arrays
- No wastage of memory
- Implementation of other data structures (stacks, queues, etc) is easier with linked lists.
- Memory allocation is efficient: no need to pre-allocate memory (like arrays)

### Disadvantages of Linked List over Array

- Random access is not allowed. We have to access elements sequentially starting from the first node. So we cannot do binary search with linked lists efficiently with its default implementation. Read about it here.
- Extra memory space for a pointer is required with each element of the list.
- With an array, you get better performance for random access memory if you already know the index of the element you want to access. With a linked list, you need to traverse the list from the beginning to find the element you want.
- With an array, you get better performance for adding and deleting elements to the end of the list. With a linked list, you need to traverse the list to find the end and then add or delete the element.

### Types of Linked List

- Singly Linked List
- Doubly Linked List
- Circular Linked List
