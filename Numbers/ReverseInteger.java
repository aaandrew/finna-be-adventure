public int reverse(int x) {
	int num = 0;
	boolean neg = false;
	if(x < 0){
		x = -x;
		neg = true;
	}

	while(x > 0){
		if(num > Integer.MAX_VALUE/10) return 0;
		num = num*10 + x%10;
		x /= 10;
	}
	return neg ? (int)-num : (int)num;
}