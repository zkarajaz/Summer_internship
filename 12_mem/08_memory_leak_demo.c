#include <stdio.h>
#include <stdlib.h>

int main(void) {
    for (int i = 0; i < 5; i++) {
        int *p = malloc(sizeof *p);
        if (p == NULL) return 1;
        *p = i;
        /* НИКОГДА не free(p) — это утечка по 5 блоков */
    }
    printf("done (but leaked 5 blocks)\n");
    return 0;
}
