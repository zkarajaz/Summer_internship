#include <stdio.h>

int main(void) {
    int x = 10;
    int *p = &x;
    printf("%d\n", *p);
    return 0;
}
