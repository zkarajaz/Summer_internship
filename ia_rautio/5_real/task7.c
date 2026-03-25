#include <stdio.h>
#include <math.h>

int main(void) {
    double a = 0.1 + 0.2;
    double b = 0.3;
    double epsilon = 0.000000001;

    if (fabs(a - b) < epsilon) {
        printf("Numbers are equal within epsilon!\n");
    } else {
        printf("Numbers are different!\n");
    }

    return 0;
}