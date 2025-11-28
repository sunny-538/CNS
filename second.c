/*Start
Read a string from the user
For each character in the string
Perform character AND 127
Perform character OR 127
Perform character XOR 127
Display all three results
Stop*/
#include <stdio.h>

int main() {
    char str[100];

    printf("Enter a string: ");
    scanf("%s", str);

    printf("\nAND with 127: ");
    for (int i = 0; str[i] != '\0'; i++) {
        printf("%c", str[i] & 127);
    }

    printf("\nOR with 127: ");
    for (int i = 0; str[i] != '\0'; i++) {
        printf("%c", str[i] | 127);
    }

    printf("\nXOR with 127: ");
    for (int i = 0; str[i] != '\0'; i++) {
        printf("%c", str[i] ^ 127);
    }

    return 0;
}
