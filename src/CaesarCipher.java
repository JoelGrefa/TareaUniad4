import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {  // Bucle para que se repita el proceso
            System.out.println("Seleccione una opción:");
            System.out.println("1. Encriptar texto");
            System.out.println("2. Desencriptar texto");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            if (option == 3) {
                System.out.println("¡Hasta luego!\n");
                break;  // Salir del bucle y terminar el programa
            }
            
            System.out.print("Ingrese el texto: ");
            String text = scanner.nextLine();
            
            System.out.print("Ingrese el desplazamiento: ");
            int shift = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            if (option == 1) {
                // Encriptar el mensaje
                String encryptedText = encrypt(text, shift);
                System.out.println("Texto encriptado: " + encryptedText + "\n");
            } else if (option == 2) {
                // Desencriptar el mensaje
                String decryptedText = decrypt(text, shift);
                System.out.println("Texto desencriptado: " + decryptedText + "\n");
            } else {
                System.out.println("Opción no válida\n");
            }
        }
        
        scanner.close();
    }

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                character = (char) ((character - base + shift) % 26 + base);
            }
            result.append(character);
        }
        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);
    }
}


