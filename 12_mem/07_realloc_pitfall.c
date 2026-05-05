#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int *p = malloc(sizeof *p);
    if (p == NULL) return 1;
    *p = 7;

    /* плохо: при NULL мы теряем исходный p и не сможем его free() */
    p = realloc(p, (size_t)-1);   /* заведомо невозможный размер */
    if (p == NULL) {
        fprintf(stderr,
            "realloc failed; original pointer was overwritten "
            "— potential leak\n");
        return 1;
    }
    free(p);
    return 0;
}
