#include <stdio.h>

int main(void) {
    int a = 5, b = 9;
    printf("Before: a=%d, b=%d. ", a, b);
    
    a ^= b;
    b ^= a;
    a ^= b;
    
    printf("After: a=%d, b=%d.\n", a, b);
    return 0;
}