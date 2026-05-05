#include <stdio.h>

int main(void) {
    int a[5] = {1, 2, 3, 4, 5};
    for (int *p = a; p < a + 5; p++) {
        printf("%d%s", *p, (p < a + 4) ? " " : "\n");
    }
    return 0;
}
