import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class Consultas {

    public static int idUsuarioLogueado = -1;

    // Metodo para inicar secion en el login
    public boolean validarUsuario(String correo, String password) {
        try (Connection conn = DatabaseConnection.conectar();
                Statement stmt = conn.createStatement()) {

            if (conn == null)
                return false;

            String query = "SELECT * FROM users WHERE email = '" + correo + "' AND password = '" + password + "'";
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) { // Si encuentra el usuario, devuelve true
                idUsuarioLogueado = rs.getInt("id");
                return true;
            }

            return false;

        } catch (Exception e) {
            System.out.println("Error en consulta: " + e.getMessage());
            return false;
        }
    }

    // Método para registrar usario en la base de datos
    public void registrarUsuario(String correo, String password, String userName, String randomString) {

        try (Connection conn = DatabaseConnection.conectar();
                Statement stmt = conn.createStatement()) {

            if (conn == null)
                return;

            // 1. Obtenemos la fecha de hoy automáticamente
            String fechaCreacion = LocalDate.now().toString();

            // 2. Inyectamos correo, password y la fecha en la tabla
            String query = "INSERT INTO users (user_Name,email, password, creation_date, user_photo) VALUES ('"
                    + userName + "','"
                    + correo + "', '" + password + "', '" + fechaCreacion + "' , '" + randomString + "')";

            stmt.executeUpdate(query);
            System.out.println("✅ Usuario registrado con éxito el día: " + fechaCreacion);

        } catch (Exception e) {
            System.out.println("❌ Error al registrar: " + e.getMessage());
        }

    }

    // Metodo para cambiar la contraseña :)
    public void changesPassword(String nuevaPassword) {

        try (Connection conn = DatabaseConnection.conectar();
                Statement stmt = conn.createStatement()) {

            if (conn == null)
                return;

            String query = "UPDATE users SET password = '" + nuevaPassword + "' WHERE id = " + idUsuarioLogueado;

            int usuario = stmt.executeUpdate(query);

            if (usuario > 0) {
                System.out.println("Cambio de contraseña exitoso");
            }

        } catch (Exception e) {
            System.out.println("Error al cambiar la contraseña: " + e.getMessage());
        }

    }

    // Metodo para consultar los puntos del usario
    public int consultarPuntos() {

        try (Connection conn = DatabaseConnection.conectar();
                Statement stmt = conn.createStatement()) {

            if (conn == null)
                return 0;

            String query = "SELECT points FROM users WHERE id = " + idUsuarioLogueado;
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                int puntos = rs.getInt("points");
                return puntos;
            }

        } catch (Exception e) {
            System.out.println("Error al consultar los puntos: " + e.getMessage());
        }

        return 0;
    }

    // Consulta los puntos de Vidrios
    public int consultarGlass() {

        try (Connection conn = DatabaseConnection.conectar();
                Statement stmt = conn.createStatement()) {

            if (conn == null)
                return 0;

            String query = "SELECT glass FROM users WHERE id = " + idUsuarioLogueado;
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                int pointsGlass = rs.getInt("glass");
                return pointsGlass;
            }

        } catch (Exception e) {
            System.out.println("Error al consultar los putnos de vidrios: " + e.getMessage());
        }

        return 0;

    }

    // Consulta los puntos de Platico
    public int consultarPlastic() {

        try (Connection conn = DatabaseConnection.conectar();
                Statement stmt = conn.createStatement()) {

            if (conn == null)
                return 0;

            String query = "SELECT plastic FROM users WHERE id = " + idUsuarioLogueado;
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                int pointsPlastic = rs.getInt("plastic");
                return pointsPlastic;
            }

        } catch (Exception e) {
            System.out.println("Error al consultar los puntos del Platico: " + e.getMessage());
        }

        return 0;

    }

    // Consulta los puntos del Metal
    public int consultarMetal() {

        try (Connection conn = DatabaseConnection.conectar();
                Statement stmt = conn.createStatement()) {

            if (conn == null)
                return 0;

            String query = "SELECT metal FROM users WHERE id = " + idUsuarioLogueado;
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                int pointsMetal = rs.getInt("metal");
                return pointsMetal;
            }

        } catch (Exception e) {
            System.out.println("Error al consultar los puntos del Metal: " + e.getMessage());
        }

        return 0;

    }

    public int consultarDifilResiclaje() {

        try (Connection conn = DatabaseConnection.conectar();
                Statement stmt = conn.createStatement()) {

            if (conn == null)
                return 0;

            String query = "SELECT hard_to_recycle FROM users WHERE id = " + idUsuarioLogueado;
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                int pointsHard = rs.getInt("hard_to_recycle");
                return pointsHard;
            }

        } catch (Exception e) {
            System.out.println("Error al consultar los puntos del Metal: " + e.getMessage());
        }

        return 0;

    }

    // Consulta el numero de foto del usuario actual
    public int consultarFoto() {

        try (Connection conn = DatabaseConnection.conectar();
                Statement stmt = conn.createStatement()) {

            if (conn == null)
                return 0;

            String query = "SELECT user_photo FROM users WHERE id = " + idUsuarioLogueado;
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                int numeroFoto = rs.getInt("user_photo");
                return numeroFoto;
            }

        } catch (Exception e) {
            System.out.println("Error al consultar el numero de foto: " + e.getMessage());
        }

        return 0;

    }

}