#include <stdio.h>
#include <stdarg.h>

int sum_all(int count, ...) {
    va_list ap;
    va_start(ap, count);
    int s = 0;
    for (int i = 0; i < count; i++) {
        s += va_arg(ap, int);
    }
    va_end(ap);
    return s;
}

int main(void) {
    printf("%d\n", sum_all(3, 1, 2, 3));
    printf("%d\n", sum_all(10, 1,2,3,4,5,6,7,8,9,10));
    return 0;
}
