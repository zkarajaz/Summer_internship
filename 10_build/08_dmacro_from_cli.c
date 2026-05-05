#include <stdio.h>

#ifndef VERSION
#define VERSION "unset"
#endif

int main(void) {
    printf("version: %s\n", VERSION);
    return 0;
}
