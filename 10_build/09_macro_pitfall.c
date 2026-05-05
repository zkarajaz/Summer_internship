#include <stdio.h>

#define SQUARE_BAD(x) x*x
#define SQUARE_OK(x)  ((x)*(x))

static inline int square_fn(int x) { return x * x; }

int main(void) {
    printf("bad: %d\n", SQUARE_BAD(1+2));
    printf("ok: %d\n",  SQUARE_OK(1+2));
    printf("fn: %d\n",  square_fn(1+2));
    return 0;
}
