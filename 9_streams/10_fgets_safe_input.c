#include <stdio.h>

int main(void) {
    char buf[64];
    if (fgets(buf, sizeof buf, stdin) == NULL) {
        fprintf(stderr, "no input\n");
        return 1;
    }
    printf("вы ввели: %s", buf); /* fgets оставляет '\n', если влез */
    return 0;
}
