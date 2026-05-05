#include <stdio.h>
#include <unistd.h> /* sleep */

int main(void) {
    printf("loading...");
    fflush(stdout);   /* без этого строка может «зависнуть» в буфере */
    sleep(2);
    printf(" done\n");
    return 0;
}
