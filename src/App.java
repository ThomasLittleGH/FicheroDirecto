import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;


public class App {

    static final String NOMBREARCHIVO = "personas.dat";
    // Se generan objetos para los archivos
    static File fichero = new File(NOMBREARCHIVO);
    static RandomAccessFile archivo;
    static final byte TAMANO = 20; // Tamaño de registro
    public static void main(String[] args) throws Exception {
        // Programa que pertire utilizar ficheros directos
        // boolean: 1 bit; byte: 8 bits; char: 2 bytes; short: 2 bytes; int: 4 bytes; long: 8 bytes; float: 4 bytes; double: 4 bytes; String: cantidad de caracteres + 2 bytes
        // @author Thomas Little
        // Definicion de variables
        Scanner input = new Scanner(System.in);
        String opcion = "0";
        int reg = 0; // Numero del registro
        archivo = new RandomAccessFile(NOMBREARCHIVO, "rw"); // Se instancia el archivo, hay 2 modos, "r" o read, y "rw" o read & write
        int pos = (archivo.length() == 0) ? 0 : (int)archivo.length() - TAMANO; // Posicion  -> total de bytes por registro
        archivo.seek(pos); // Se posiciona en el registro correspondiente
        int registro = (archivo.length() == 0) ? 0: archivo.readInt(); // Se almacena el numero de registro de la ultima pos

        do {
            opcion = "0";
            System.out.println("*** Menu Fichero ***");
            System.out.println("1) Ingresar datos \n2) Visualisar datos \n0) Salir");
            opcion = input.nextLine();
            
            switch (opcion) {
                case "0":
                    break;
                case "1":
                    guardarDatos();
                    break;
                case "2":
                    leerDatos();
                    break;
                default: // Si el usuario no ingresa un dato valido el programa le avisa
                    System.out.println("Error 01 - seleccione un numero valido");
                    break;
            }
        } while (opcion != "0");
        
    }
    public static void guardarDatos(){

    }
    public static void leerDatos(){

    }
}
