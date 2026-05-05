#include <stdio.h>

static int square(int x) {
    return x * x;
}

int main(void) {
    printf("%d\n", square(3));
    printf("%d\n", square(7));
    return 0;
}
