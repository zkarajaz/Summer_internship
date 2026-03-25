#include <stdio.h>
#include <math.h>

int main(void) {
    double inf = 1.0 / 0.0;

    printf("Value: %f\n", inf);

    if (isinf(inf)) {
        printf("Is it infinite? Yes\n");
    }

    return 0;
}