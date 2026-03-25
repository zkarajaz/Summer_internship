#include <stdio.h>

enum Color {
    RED,
    GREEN,
    BLUE
};

int main(void) {
    printf("Size of enum Color: %zu bytes\n", sizeof(enum Color));
    return 0;
}