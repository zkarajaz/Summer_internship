#include <stdio.h>

int main(int argc, char *argv[], char *envp[]) {
    (void)argc;
    (void)argv;
    
    int count = 0;
    while (envp[count] != NULL) {
        count++;
    }
    
    printf("Environment variables count: %d\n", count);
    return 0;
}