/*
 * Given two sorted arrays A, B of size m and n respectively. Find the k-th smallest element in the union of A and B. 
 * You can assume that there are no duplicate elements.
 */

public static int kthSmallestSortedArrays(int[] a, int[] b, int k){

}

k 4
a [1 3 4 10 | 6]
b [1 2 3 5  | 6 7 8 9]

a[2] = 4
b[2] = 3

Note: all [x..y] represents a k/2 half
i = j = k/2
a[i] == b[j]
a[i] < b[j]: Recurse on elements a[i..k] and b[0..j]
a[i] > b[j]: 
Discard a[i..k] because that half is greater than a[0..i] and b[0..j]
Discard 
Recurse on elements a[0..i] and b[j..k]


what the flying fuck
k = 4
a [-1, -2, 7, 10, 11, 12]
b [2, 3, 4, 6, 13, 15]
expected answer is 3, but we discard it!