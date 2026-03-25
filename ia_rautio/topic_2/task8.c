#include <stdlib.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    (void)argv;
    
    if (argc <= 1) {
        printf("Error: at least one argument required.\n");
        return EXIT_FAILURE;
    }
    
    printf("Success.\n");
    return EXIT_SUCCESS;
}