#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int *a = malloc(10 * sizeof *a);
    if (a == NULL) return 1;
    for (int i = 0; i < 10; i++) a[i] = i * i;
    for (int i = 0; i < 10; i++) {
        printf("%d%s", a[i], i == 9 ? "\n" : " ");
    }
    free(a);
    return 0;
}
