#include <stdio.h>

int main(void) {
    double small = 0.000001;
    double large = 123456789.0;

    printf("Small: %e\n", small);
    printf("Large: %e\n", large);

    return 0;
}