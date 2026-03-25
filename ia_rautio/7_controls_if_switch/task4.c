#include <stdio.h>

int main(void) {
    int year = 2000;
    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
        printf("Leap\n");
    } else {
        printf("Not Leap\n");
    }
    return 0;
}