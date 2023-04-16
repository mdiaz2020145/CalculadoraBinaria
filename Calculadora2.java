import java.util.Scanner;

public class Calculadora2 {
    public static void main(String[] args) {
        //Declara el objeto Scanner
        Scanner sc = new Scanner(System.in);

        //Realiza un try and catch para la solicitud de los numeros binarios
        try {
            System.out.print("Ingresa el primer número binario: ");
            //Declara la variable String
            String num1 = sc.nextLine();
            if (!esBinario(num1)) {
                //Realiza una validacion de excepciones en este caso si ingresa un numero no binario imprime en consola dicha validacion
                throw new IllegalArgumentException("El número debe ser binario");
            }

            System.out.print("Ingresa el segundo número binario: ");
            //Declara la variable String
            String num2 = sc.nextLine();
            if (!esBinario(num2)) {
                //Realiza una validacion de excepciones en este caso si ingresa un numero no binario imprime en consola dicha validacion
                throw new IllegalArgumentException("El número debe ser binario");
            }

            //Realiza un parseo para trasformarlo en int
            int decimal1 = Integer.parseInt(num1, 2);
            int decimal2 = Integer.parseInt(num2, 2);

            System.out.println("Elige la operación que deseas realizar: ");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.print("Ingresa el número de la operación que deseas realizar: ");
            int opcion = sc.nextInt();

            //Se realiza un switch para que ejecute la operacion que quiera el usuario
            switch (opcion) {
                case 1:
                    int suma = decimal1 + decimal2;
                    System.out.println("El resultado de la suma es: " + Integer.toBinaryString(suma));
                    break;
                case 2:
                    int resta = decimal1 - decimal2;
                    System.out.println("El resultado de la resta es: " + Integer.toBinaryString(resta));
                    break;
                case 3:
                    int multiplicacion = decimal1 * decimal2;
                    System.out.println("El resultado de la multiplicación es: " + Integer.toBinaryString(multiplicacion));
                    break;
                case 4:
                    if (decimal2 == 0) {
                        throw new ArithmeticException("No se puede dividir por cero");
                    }
                    int division = decimal1 / decimal2;
                    System.out.println("El resultado de la división es: " + Integer.toBinaryString(division));
                    break;
                default:
                    throw new IllegalArgumentException("Opción inválida");
            }

        } catch (NumberFormatException e) {
            System.out.println("Los números deben ser binarios");
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean esBinario(String numero) {
        for (int i = 0; i < numero.length(); i++) {
            if (numero.charAt(i) != '0' && numero.charAt(i) != '1') {
                return false;
            }
        }
        return true;
    }
}

