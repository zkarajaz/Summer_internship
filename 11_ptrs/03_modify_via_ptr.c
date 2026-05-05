#include <stdio.h>

int main(void) {
    int x = 0;
    int *p = &x;
    printf("before: %d\n", x);
    *p = 99;
    printf("after: %d\n", x);
    return 0;
}
