-------------------------- Week 2 --------------------------

 * Amortized Cost := Given a seq. of n ops., the amortized cost is cost(n ops.) / n

 - For example, in a dynamic array if the overhead cost is O(n), then by the aggregate method, the cost is basically O(n)/n or O(1)
 - In the physicist method, the cost would be c(t) + phi(hsub(i)) - phi(hsub(i - 1)), where c(t) is the true cost and phi is the potential function and the base case is 0.

 