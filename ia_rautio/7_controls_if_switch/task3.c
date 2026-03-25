#include <stdio.h>

int main(void) {
    int score = 85;
    if (score >= 90) printf("Grade: 5\n");
    else if (score >= 80) printf("Grade: 4\n");
    else if (score >= 70) printf("Grade: 3\n");
    else printf("Grade: 2\n");
    return 0;
}