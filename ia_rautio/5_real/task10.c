#include <stdio.h>

int main(void) {
    long double pi = 3.14159265358979323846L;

    printf("Size of long double: %zu bytes\n", sizeof(long double));
    printf("Pi (long double): %.18Lf\n", pi);

    return 0;
}