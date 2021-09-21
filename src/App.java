import java.io.File;
import java.io.IOException;
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
        archivo = new RandomAccessFile(fichero, "rw"); // Se instancia el archivo, hay 2 modos, "r" o read, y "rw" o read & write
        int pos = (archivo.length() == 0) ? 0 : (int)archivo.length() - TAMANO; // Posicion  -> total de bytes por registro
        archivo.seek(pos); // Se posiciona en el registro correspondiente
        int registro = (archivo.length() == 0) ? 0: archivo.readInt(); // Se almacena el numero de registro de la ultima pos

        do {
            opcion = "0";
            System.out.println("*** Menu Fichero ***");
            System.out.println("\n1) Agregar");
            System.out.println("2) Busqueda por nombre");
            System.out.println("3) Busqueda por registro");
            System.out.println("4) Modificar");
            System.out.println("5) Eliminar");
            System.out.println("6) Mostrar");
            System.out.println("0) Salir");
            opcion = input.nextLine();
            
            switch (opcion) {
                case "0":
                    archivo.close();
                    break;
                case "1":
                    // Ingreso de datos
                    ingresoData(registro, input);
                    break;
                case "2":
                    // Busqueda por nombre
                    break;
                case "3":
                    // Busqueda por registro
                    break;
                case "4":
                    // Modificar
                    break;
                case "5":
                    // Eliminar
                    break;
                case "6":
                    // Mostrar
                    break;
                default: // Si el usuario no ingresa un dato valido el programa le avisa
                    System.out.println("Error 01 - seleccione un numero valido");
                    break;
            }
        } while (opcion != "0");
    }

    static void ingresoData(int registro, Scanner input, long pos) throws IOException{
        System.out.println("Registro: " + registro);
        System.out.println("Nombre: ");
        String nombre = input.next();
        System.out.println("Sexo: ");
        char sexo = input.next().charAt(0);
        guardarData(registro, nombre, sexo, pos);
    }
    static void guardarData(int registro, String nombre, char sexo, long pos) throws IOException{
        archivo = new RandomAccessFile(fichero, "rw");
        archivo.seek(pos);
        nombre = (nombre.length() < 13) ? nombre + " ".repeat(12 - nombre.length()) : "errorNombre";
        // Se guardan los datos en el fichero
        archivo.writeInt(registro);
        archivo.writeUTF(nombre);
        archivo.writeChar(sexo);
        archivo.close();
    }


}
