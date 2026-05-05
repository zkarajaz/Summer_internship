#include <stdio.h>

static inline int imax(int a, int b) {
    return a > b ? a : b;
}

int main(void) {
    printf("%d\n", imax(3, 5));
    printf("%d\n", imax(-1, -7));
    return 0;
}
