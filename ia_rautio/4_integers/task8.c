#include <stdio.h>

int main(void) {
    int negative_num = -8;
    int result = negative_num >> 1;
    
    printf("%d >> 1 = %d\n", negative_num, result);
    
    return 0;
}