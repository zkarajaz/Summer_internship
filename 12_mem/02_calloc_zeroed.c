#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int *a = calloc(5, sizeof *a);
    if (a == NULL) return 1;
    for (int i = 0; i < 5; i++) {
        printf("%d%s", a[i], i == 4 ? "\n" : " ");
    }
    free(a);
    return 0;
}
