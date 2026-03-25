#include <stdio.h>
#include <math.h>

int main(void) {
    double result = 0.0 / 0.0;

    printf("Value: %f\n", result);

    if (isnan(result)) {
        printf("Is it NaN? Yes\n");
    }

    return 0;
}