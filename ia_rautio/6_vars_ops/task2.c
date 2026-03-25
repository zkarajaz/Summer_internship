#include <stdio.h>

void call_me(void) {
    static int counter = 0;
    counter++;
    printf("Call %d\n", counter);
}

int main(void) {
    call_me();
    call_me();
    call_me();
    return 0;
}