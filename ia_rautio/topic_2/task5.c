#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[], char *envp[]) {
    (void)argc;
    (void)argv;

    while (*envp != NULL) {
        if (strncmp(*envp, "USER=", 5) == 0) {
            printf("Found: %s\n", *envp);
            break;
        }
        envp++;
    }
    return 0;
}