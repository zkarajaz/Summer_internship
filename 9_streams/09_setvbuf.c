#include <stdio.h>
#include <unistd.h>

int main(void) {
    setvbuf(stdout, NULL, _IONBF, 0);
    printf("tick");
    sleep(1);
    printf(" done\n");
    return 0;
}
