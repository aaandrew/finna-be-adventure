/*
 * Print a C string without looping.
 */
void print(char *s){
	if(s != NULL){
		putchar(*s);
		print(s+1);
	}
}

/*
 * Print a C string without looping in reverse.
 */
void printReverse(char *s){
	if(s != NULL){
		printReverse(s+1);
		putchar(*s);
	}
}
