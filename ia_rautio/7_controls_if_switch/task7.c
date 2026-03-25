#include <stdio.h>

enum Role { USER, MOD, ADMIN };

int main(void) {
    enum Role my_role = ADMIN;
    
    printf("Your rights: ");
    switch (my_role) {
        case ADMIN: printf("Admin rights, ");
        case MOD:   printf("Moderator rights, ");
        case USER:  printf("User rights.\n");
    }
    return 0;
}