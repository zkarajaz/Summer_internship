#include <stdio.h>

int main(void) {
    int a = 5, b = 5;
    int x = a++; 
    int y = ++b;

    printf("Post: x=%d, a=%d\n", x, a);
    printf("Pre:  y=%d, b=%d\n", y, b);
    return 0;
}