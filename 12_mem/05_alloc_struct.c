#include <stdio.h>
#include <stdlib.h>

struct Point { int x, y; };

int main(void) {
    struct Point *p = malloc(sizeof *p);
    if (p == NULL) return 1;
    p->x = 3;
    p->y = 4;
    printf("(%d, %d)\n", p->x, p->y);
    free(p);
    return 0;
}
