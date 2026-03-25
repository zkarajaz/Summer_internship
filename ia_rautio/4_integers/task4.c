#include <stdio.h>

int main(void) {
    long long big_num = 9223372036854775807LL;
    unsigned int unsigned_num = 4000000000U;
    
    printf("A very big number: %lld\n", big_num);
    printf("An unsigned number: %u\n", unsigned_num);
    
    return 0;
}