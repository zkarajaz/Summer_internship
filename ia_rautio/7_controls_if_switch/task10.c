#include <stdio.h>

int main(void) {
    char op = '?';
    int a = 10, b = 5;

    switch (op) {
        case '+': printf("%d\n", a + b); break;
        case '-': printf("%d\n", a - b); break;
        case '*': printf("%d\n", a * b); break;
        case '/': printf("%d\n", a / b); break;
        default:  printf("Error: Unknown operation '%c'\n", op);
    }
    return 0;
}