#include <stdio.h>

int main(void) {
    int n1 = 10, n2 = 11;

    printf("%d is %s\n", n1, (n1 & 1) ? "Odd" : "Even");
    printf("%d is %s\n", n2, (n2 & 1) ? "Odd" : "Even");

    return 0;
}