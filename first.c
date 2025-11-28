/*Algorithm
Start
Declare a string variable
Read the input string
For each character in the string
XOR the character with 0
Print the result
Stop*/
#include <stdio.h>

int main() {
    char str[100];

    printf("Enter a string: ");
    scanf("%s", str);  // No fgets, only scanf

    printf("\nOriginal String: %s", str);

    printf("\nAfter XOR with 0: ");
    for (int i = 0; str[i] != '\0'; i++) {
        char x = str[i] ^ 0;  // XOR with 0
        printf("%c", x);
    }

    printf("\n");

    return 0;
}
