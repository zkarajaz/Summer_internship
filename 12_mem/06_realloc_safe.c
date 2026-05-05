#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int *buf = malloc(4 * sizeof *buf);
    if (buf == NULL) return 1;
    for (int i = 0; i < 4; i++) buf[i] = i;

    int *tmp = realloc(buf, 8 * sizeof *buf);
    if (tmp == NULL) {
        free(buf);          /* старый блок ещё жив — освобождаем */
        return 1;
    }
    buf = tmp;
    for (int i = 4; i < 8; i++) buf[i] = -1;

    for (int i = 0; i < 8; i++) {
        printf("%d%s", buf[i], i == 7 ? "\n" : " ");
    }
    free(buf);
    return 0;
}
