#include <stdio.h>

int main(void) {
    FILE *f = fopen("/no/such/file", "r");
    if (f == NULL) {
        perror("fopen");
        return 1;
    }
    fclose(f);
    return 0;
}
