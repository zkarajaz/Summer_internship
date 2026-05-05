#include <stdio.h>

int main(void) {
    int x = 7;
    printf("x=%d, &x=%p\n", x, (void *)&x);
    return 0;
}
