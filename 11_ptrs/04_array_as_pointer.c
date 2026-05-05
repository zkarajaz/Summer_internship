#include <stdio.h>

int main(void) {
    int a[3] = {10, 20, 30};
    printf("a[0]=%d *a=%d\n", a[0], *a);
    printf("a[1]=%d *(a+1)=%d\n", a[1], *(a + 1));
    return 0;
}
