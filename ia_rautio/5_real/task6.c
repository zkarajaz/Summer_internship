#include <stdio.h>

int main(void) {
    float f = 3.141592653589793f;
    double d = 3.141592653589793;

    printf("Float (7 digits): %.15f\n", f);
    printf("Double (15 digits): %.15f\n", d);

    return 0;
}