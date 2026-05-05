#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int *p = malloc(sizeof *p);
    if (p == NULL) return 1;
    *p = 1;

    free(p);
    /* здесь обычно ставят p = NULL, чтобы повторный free стал free(NULL) */

    free(p);   /* без зануления — UB / падение под ASan */
    return 0;
}
