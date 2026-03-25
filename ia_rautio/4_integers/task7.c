#include <stdio.h>
#include <stdint.h>

int main(void) {
    int32_t signed_32_bit_int = -12345;
    uint64_t unsigned_64_bit_int = 18446744073709551615ULL;

    (void)signed_32_bit_int;
    (void)unsigned_64_bit_int;
    
    printf("Size of int32_t: %zu bytes\n", sizeof(int32_t));
    printf("Size of uint64_t: %zu bytes\n", sizeof(uint64_t));
    
    return 0;
}