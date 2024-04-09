1. What is your hash function like for hash table solution (if you implemented hash table).

The hash function I implemented calculates the hash value based on the string representation of the key. The specific calculation method is to loop through each character and multiply the hash value of each character in the loop by a prime number, such as 31. Multiplying by 31 can be achieved using displacement and subtraction to provide a good hash distribution, and then add up the ASCII value of the current character.

2. For binary search trees (if you implemented it), how does your implementation get the top-100 list?

Adopting mid order traversal. Firstly, recursively traverse the left subtree of the binary tree until reaching the leftmost node. After traversing the left subtree, access the current root node. Finally, recursively traverse the right subtree of the current node.

3. What can you say about the **correctness** of your implementation? Any issues, bugs or problems you couldn't solve? Any idea why the problem persists and what could perhaps be the solution?

In terms of implementation correctness, I believe that most of my current writing meets the requirements and testing of the course, as I have debugged the code multiple times without any obvious bugs. Bugs that occur during the modification process may be caused by logical errors. By consulting relevant information and asking teachers and classmates, I can usually solve bugs. The issue with the software is that the testing process for the code may be too long, and my VSCode may suddenly experience a situation where the *Test* flag disappears.

4. What can you say about the **time complexity** of your implementation? How efficient is the code in reading and managing the words and their counts? How efficient is your code in getting the top-100 list? Which sorting algorithm are you using? What is the time complexity of that algorithm?

In the program I have already implemented:
The time complexity of a binary search tree depends on its balance, which is "O (log n)", where "n" is the number of nodes.
The average time complexity of the hash table is O (1), while the time complexity of the heapSort method and the addToTree method is O (n-logn).

5. What did you find the **most difficult things** to understand and implement in this programming task? Why?

I think the most difficult task is to implement binary search trees and hash tables while complying with the requirements outlined in the document, and optimizing various performance to handle large amounts of data. This course still has a certain level of difficulty for me.

6. What did you learn doing this?

In the process of learning programming tasks, I learned about hash functions and calculating the maximum depth of binary search trees, as well as the advantages and disadvantages of different functions and algorithms, including time complexity and the ability to effectively process large amounts of data. I have learned at a deeper level how to debug code to meet specific requirements.