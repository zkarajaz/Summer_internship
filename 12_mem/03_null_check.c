#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int *p = malloc(sizeof *p);
    if (p == NULL) {
        fprintf(stderr, "out of memory\n");
        return 1;
    }
    *p = 0;
    printf("ok\n");
    free(p);
    return 0;
}
