#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int *p = NULL;
    free(p);          /* безопасно — это no-op */
    printf("ok\n");
    return 0;
}
