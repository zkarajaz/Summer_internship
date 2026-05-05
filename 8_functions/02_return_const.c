#include <stdio.h>

int get_answer(void) {
    return 42;
}

int main(void) {
    int x = get_answer();
    printf("%d\n", x);
    return 0;
}
