#include <stdio.h>

int main(void) {
    int choice = 1;
    switch (choice) {
        case 1: {
            int x = 10;
            printf("X = %d\n", x);
            break;
        }
        default: break;
    }
    return 0;
}