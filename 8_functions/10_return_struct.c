#include <stdio.h>

struct Point { int x, y; };

struct Point make_point(int x, int y) {
    struct Point p = { x, y };
    return p;
}

int main(void) {
    struct Point p = make_point(3, 4);
    printf("(%d, %d)\n", p.x, p.y);
    return 0;
}
