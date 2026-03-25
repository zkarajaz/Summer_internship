#include <stdio.h>

int main(void) {
    int day = 6;
    switch (day) {
        case 1: case 2: case 3: case 4: case 5:
            printf("Workday\n");
            break;
        case 6: case 7:
            printf("Weekend\n");
            break;
        default:
            printf("Invalid day\n");
    }
    return 0;
}