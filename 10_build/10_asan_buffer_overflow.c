#include <stdio.h>

int main(void) {
    int a[10] = {0};
    /* допустимы a[0]..a[9]; следующая строка — выход за границы (UB) */
    a[10] = 42;
    printf("%d\n", a[10]);
    return 0;
}
