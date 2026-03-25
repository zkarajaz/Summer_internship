#include <stdio.h>

int main(void) {
    int a = 0;
    if (0 && ++a) {
    }
    printf("a is still %d\n", a);
    return 0;
}