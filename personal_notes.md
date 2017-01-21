-------------------------- Week 4 --------------------------

Karatsuba's Algorithm for Faster DnC Polynomial Multiplication

 * a1b0+a0b1=(a0+a1)(b0+b1)−a0b0−a1

Applied Karatsuba on large integer multiplication:

 * For a number A=a1a2…an¯¯¯¯¯¯¯¯¯¯¯¯¯¯ with n digits create a corresponding polynomial a(x)=a1xn−1+a2xn−2+⋯+an. Then a(10)=A. Do the same with number B=b1b2…bn¯¯¯¯¯¯¯¯¯¯¯¯¯ and create polynomial b(x). Multiply polynomials a(x) and b(x), get polynomial c(x) =c1c2…cn¯¯¯¯¯¯¯¯¯¯¯¯¯. If we create a number C=c1c2…cn¯¯¯¯¯¯¯¯¯¯¯¯¯, it is almost the same as product of A and B, but some of its "digits" may be 10 or bigger. If the last "digit" is 52, for example, make the last digit just 2 and add 5 to the previous digit. Go on until all the digits are from 0 to 9.

 * Suppose we need to multiply numbers 13 and 24. The correct result is 312. To get this result, we first create polynomials a(x)=x+3 and b(x)=2x+4 corresponding to numbers 13 and 24 respectively. We then use Karatsuba's algorithm to multiply those polynomials and get polynomial c(x)=2x2+10x+12. To get the answer, we need to compute c(10)=2×102+10×10+12. You see that some of the coefficients of polynomial c are not digits, because they are bigger than 9. To fix that, for each such coefficient from right to left we subtract 10 from it and add 1 to the previous coefficient: c(10)=2×102+10×10+12=2×102+11×10+2=3×102+1×10+2=312

Master Theorem Shortcut:
 * If the amount of work is constant, O(n^d log(n))
 * If the amount of work is decreasing, O(n^d)
 * If the amount of work is increasing, O(n (log a / log b)


MergeSort:
 * Well that was fun. Dumb little mistakes like forgetting to update the index of the arrays while merging but overall easy to implement. Good DnC algorithms. 10/10 would implement again. 

 Apparently it is the most asymptotically optimal of the comparison-based sorting algorithms. O(n * log(n))

 --------------------------------------Week 5----------------------------------------------------

  * T[i,j] is computed based on T[i−1,j], T[i,j−1] and T[i−1,j−1]: we decide what will be the last edit and then try to use the minimum number of edits needed before that, which is already stored in the table T for all the variants of the last editing action. If the minimum number of edits T[i,j] can be obtained via different last editing actions, we should sum all the ways that exactly T[i,j] edits can be made to change the i-th prefix of the first word into the j-th prefix of the second word.

 * First if checks all the ways when the last action is to delete the last symbol. Second if checks all the ways when the last action is to insert the necessary symbol. Third if checks all the ways to match last symbols of the prefixes. Last if checks all the ways to replace the last symbol of the i-th prefix of the first word by the last symbol of the j-th prefix of the second word.