#include <stdio.h>

int main(void) {
    int num = 258;
    char truncated = (char)num;
    
    printf("(char)%d is %d\n", num, truncated);
    
    return 0;
}