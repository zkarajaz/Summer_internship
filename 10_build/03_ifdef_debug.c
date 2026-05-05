#include <stdio.h>

int main(void) {
#ifdef DEBUG
    printf("debug build\n");
#else
    printf("release build\n");
#endif
    return 0;
}
