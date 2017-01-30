-------------------------- Week 2 --------------------------

 * Amortized Cost := Given a seq. of n ops., the amortized cost is cost(n ops.) / n

 - For example, in a dynamic array if the overhead cost is O(n), then by the aggregate method, the cost is basically O(n)/n or O(1)
 - In the physicist method, the cost would be c(t) + phi(hsub(i)) - phi(hsub(i - 1)), where c(t) is the true cost and phi is the potential function and the base case is 0. You sum that stuff together and you get phi(hsub(n)) + phi(hsub(0)) + the sum of the the true cost from 1 to n. 
 - In the case of the adding in a dynamic array, that's essentially O(1) + (2 x (n - (n - 1))) or 3 without a resize. When resizing size and capacity are the same (sizesub(i - 1) = capacitysub(i - 1) = k), so it becomes: O(n) + 2 - k (2 simplified from 2sizesub(i) - capacitysub(i) = 2 (k + 1)  - 2K, and k simplified from 2sizesub(i - 1) - capacitysub(i - 1) = 2k - k = k) 

PopBack reallocates the dynamically-allocated array to a new array of half the capacity if the size is ≤ the capacity / 4 . So, for example, if, before a PopBack the size were 5 and the capacity were 8, then after the PopBack, the size would be 4 and the capacity would be 8. Only after two more PopBack when the size went down to 2 would the capacity go down to 4.

When we start, size=capacity=0, so Φ(h0)=0
Φ(ht)≥0 since, if size > capacity/2, the first term of the max is non-negative, and if size ≤ capacity/2, the second term of the max is non-negative.
The analysis of PushBack remains just as in lecture. The question is what happens when we do a PopBack. Amortized cost = true cost + Φ(ht)−Φ(ht−1)

no resize needed: true cost = 1. If size > capacity/2, the change in Φ=Φ(ht)−Φ(ht−1)=2. If size ≤ capacity/2, the change in Φ=1. Max total amortized cost is 3.
Resize needed: true cost = capacity/4 + 1. Φ(ht)=0,Φ(ht−1) = capacity/2 - (capacity/4 + 1) = capacity/4 - 1. Total amortized cost = capacity/4 + 1 - (capacity/4 - 1) = 2.

Thinsg that utilize priority queues:
 * Dijsktra's Algorithm
 * Prim's Algorithm, constructs min. spanning tree of a graph
 * Huffman's Algorithm, constructs max. prefix-free encoding of a string
 * Heap Sort