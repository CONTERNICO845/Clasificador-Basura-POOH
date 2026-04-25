import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DebugMaestro {
    public static void main(String[] args) {
        System.out.println("===========================================================================================");
        System.out.println("🚀 SISTEMA DE DEPURACIÓN TOTAL - EQUIPO MCQUACK");
        System.out.println("===========================================================================================");

        // 1. Verificación de la conexión física en Arch Linux 
        System.out.print("1. Conectando a BaseDeDatos/clasificador.db... ");
        try (Connection conn = DatabaseConnection.conectar()) {
            
            if (conn == null) {
                System.out.println("❌ ERROR: No se pudo conectar.");
                return;
            }
            System.out.println("✅ ¡CONECTADO!");

            Statement stmt = conn.createStatement();
            
            // 2. Tabla de usuarios con todas las estadísticas de reciclaje
            System.out.println("\n2. REPORTE COMPLETO DE USUARIOS Y RECICLAJE:");
            System.out.println("---------------------------------------------------------------------------------------------------------");
            // Formato: ID | EMAIL | PASS | FECHA | PTS | VID | PLA | MET | DIF
            System.out.printf("%-3s | %-20s | %-10s | %-10s | %-4s | %-3s | %-3s | %-3s | %-3s\n", 
                              "ID", "EMAIL", "PASS", "FECHA", "PTS", "VID", "PLA", "MET", "DIF");
            System.out.println("---------------------------------------------------------------------------------------------------------");

            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            int contador = 0;
            while (rs.next()) {
                System.out.printf("%-3d | %-20s | %-10s | %-10s | %-4d | %-3d | %-3d | %-3d | %-3d\n",
                                  rs.getInt("id"),
                                  rs.getString("email"),
                                  rs.getString("password"),
                                  rs.getString("creation_date"),
                                  rs.getInt("points"),
                                  rs.getInt("glass"),
                                  rs.getInt("plastic"),
                                  rs.getInt("metal"),
                                  rs.getInt("hard_to_recycle"));
                contador++;
            }
            
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.println("📊 Total de usuarios en el sistema: " + contador);
            System.out.println("\n✅ Depuración finalizada para Geovani Gael Carmona Barbosa. ");

        } catch (Exception e) {
            System.err.println("\n❌ FALLO CRÍTICO EN EL DEBUG:");
            e.printStackTrace();
        }
    }
}