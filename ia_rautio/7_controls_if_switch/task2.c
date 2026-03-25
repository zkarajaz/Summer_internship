#include <stdio.h>

int main(void) {
    int x = 5, y = 20;
    
    if (x > 10) 
        if (y > 10) 
            printf("Both > 10\n");
    else 
        printf("X is <= 10?\n");

    return 0;
}