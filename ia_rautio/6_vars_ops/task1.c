#include <stdio.h>

int x = 10;

int main(void) {
    int x = 20;
    {
        int x = 30;
        printf("Inner block: %d\n", x);
    }
    printf("Main scope: %d\n", x);
    return 0;
}