int main(void) {
    volatile int a = 0;
    
    for (long i = 0; i < 1000000000L; i++) {
        a++;
    }
    
    return 0;
}