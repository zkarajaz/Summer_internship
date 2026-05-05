#include <stdio.h>

unsigned long long factorial(unsigned int n) {
    if (n == 0) return 1ULL;
    return (unsigned long long)n * factorial(n - 1);
}

int main(void) {
    printf("%llu\n", factorial(0));
    printf("%llu\n", factorial(1));
    printf("%llu\n", factorial(5));
    printf("%llu\n", factorial(10));
    return 0;
}
