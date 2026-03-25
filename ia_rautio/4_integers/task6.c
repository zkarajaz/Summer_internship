#include <stdio.h>

int main(void) {
    signed char a = 100;
    signed char b = 100;
    
    int result = a * b;
    
    printf("Result of %d * %d = %d\n", a, b, result);
    
    return 0;
}