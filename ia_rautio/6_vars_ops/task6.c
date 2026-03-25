#include <stdio.h>

int main(void) {
    int res;
    res = (1, 2, 3);

    printf("Result: %d\n", res);
    return 0;
}