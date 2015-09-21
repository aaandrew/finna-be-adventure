/* Leetcode
 * Given a non-negative integer num, repeatedly add all
 * its digits until the result has only one digit.
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2.
 *  Since 2 has only one digit, return it.
 */ 

// Recursive
public int addDigits(int num) {
	if(num < 10) return num;
	int sum = 0;
	while(num > 0){
		sum += num%10;
		num /= 10;
	}
	return addDigits(sum);
}

// O(1) - Congruence formula
// Result is periodic
// input: 0 1 2 3 4 ...
// output: 0 1 2 3 4 5 6 7 8 9 1 2 3 4 5 6 7 8 9 1 2 3 ...
public int addDigits(int num{
	return 1 + (num-1) % 9;
}
