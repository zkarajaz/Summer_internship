#include <stdio.h>

int main(void) {
    double val = 3.9;
    int truncated = (int)val;

    printf("Original: %f\n", val);
    printf("As int: %d\n", truncated);

    return 0;
}