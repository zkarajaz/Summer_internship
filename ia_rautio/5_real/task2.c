#include <stdio.h>

int main(void) {
    double a = 0.1;
    double b = 0.2;
    double sum = a + b;

    printf("Sum is %.17f\n", sum);

    if (sum == 0.3) {
        printf("Result: Equal!\n");
    } else {
        printf("Result: Not Equal!\n");
    }

    return 0;
}