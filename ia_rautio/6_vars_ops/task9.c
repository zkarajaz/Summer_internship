#include <stdio.h>

int main(void) {
    int x = 42, y = 15;
    int max = (x > y) ? x : y;

    printf("Max of %d and %d is %d\n", x, y, max);
    return 0;
}