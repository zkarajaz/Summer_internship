#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    if (argc < 3) {
        printf("Usage: ./<name> num1 num2\n");
        return 1;
    }

    int a = atoi(argv[1]);
    int b = atoi(argv[2]);

    if (strstr(argv[0], "add") != NULL) {
        printf("%d\n", a + b);
    } else if (strstr(argv[0], "mul") != NULL) {
        printf("%d\n", a * b);
    } else {
        printf("Unknown command: %s\n", argv[0]);
    }
    
    return 0;
}