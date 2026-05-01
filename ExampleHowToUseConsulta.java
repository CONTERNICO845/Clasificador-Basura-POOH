import java.util.Scanner;

public class ExampleHowToUseConsulta {

    // CONTRASEÑA
    /*
     * USARIO: admin
     * Correo: admin@gmail.com
     * Contraseña: admin123
     */
    public static void main(String[] args) {
        Consultas consultas = new Consultas();
        Scanner sc = new Scanner(System.in);

        System.out.println("--- 🚀 MÓDULO DE PRUEBAS RÁPIDAS - EQUIPO MCQUACK ---");

        System.out.println("1. Iniciar Sesión (Normal)");
        System.out.println("2. Saltar Inicio de Sesión (Modo Debug)");
        System.out.print("Selecciona cómo entrar: ");
        int modo = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        if (modo == 2) {
            // Saltamos el login asignando el ID manualmente
            Consultas.idUsuarioLogueado = 1; // Asumimos que el primer usuario es el ID 1
            System.out.println("⚠️ Saltando login... Usando ID: " + Consultas.idUsuarioLogueado);
            abrirMenuPrincipal(consultas, sc);
        } else {
            // Flujo normal de login
            System.out.print("Introduce correo: ");
            String correo = sc.nextLine();
            System.out.print("Introduce contraseña: ");
            String pass = sc.nextLine();

            if (consultas.validarUsuario(correo, pass)) {
                System.out.println("✅ Login correcto.");
                abrirMenuPrincipal(consultas, sc);
            } else {
                System.out.println("❌ Credenciales incorrectas.");
            }
        }

        System.out.println("Saliendo del programa...");
        sc.close();
    }

    // Encapsulamos el menú en una función aparte para que el código sea más limpio
    public static void abrirMenuPrincipal(Consultas consultas, Scanner sc) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- 📊 PANEL DE CONTROL DE DATOS ---");
            System.out.println("1. Ver Puntos Totales");
            System.out.println("2. Ver Estadísticas de Materiales");
            System.out.println("3. Cambiar Contraseña");
            System.out.println("4. Ver ID de Foto");
            System.out.println("5. Salir al Inicio");
            System.out.print("Selecciona opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            /*
             * USARIO: admin
             * Correo: admin@gmail.com
             * Contraseña: admin123
             */

            switch (opcion) {
                case 1:
                    System.out.println("💰 Puntos: " + consultas.consultarPuntos());
                    break;
                case 2:
                    System.out.println("♻️ VIDRIO: " + consultas.consultarGlass());
                    System.out.println("♻️ PLÁSTICO: " + consultas.consultarPlastic());
                    System.out.println("♻️ METAL: " + consultas.consultarMetal());
                    System.out.println("♻️ DIFÍCIL: " + consultas.consultarDifilResiclaje());
                    break;
                case 3:
                    System.out.print("Nueva contraseña: ");
                    consultas.changesPassword(sc.nextLine());
                    break;
                case 4:
                    System.out.println("🖼️ Foto ID: " + consultas.consultarFoto());
                    break;
                case 5:
                    salir = true;
                    break;
            }
        }
    }
}