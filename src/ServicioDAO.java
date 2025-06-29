// Importa las clases necesarias para la conexión con base de datos y manipulación de resultados
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Clase que maneja las operaciones de base de datos para la entidad Servicio
public class ServicioDAO {

    // URL de conexión a la base de datos MySQL
    private final String url = "jdbc:mysql://localhost:3306/peluqueria_jdbc";

    // Usuario de la base de datos (por defecto "root" en MySQL local)
    private final String user = "root";

    // Contraseña del usuario (en este caso vacía)
    private final String password = "";

    // Método que establece y retorna una conexión con la base de datos
    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Método para insertar un nuevo servicio en la base de datos
    public void insertarServicio(Servicio servicio) {
        String sql = "INSERT INTO servicios (nombre, precio) VALUES (?, ?)";
        try (
            Connection conn = conectar(); // Abre conexión
            PreparedStatement stmt = conn.prepareStatement(sql) // Prepara la consulta
        ) {
            // Asigna valores a los parámetros de la consulta
            stmt.setString(1, servicio.getNombre());
            stmt.setDouble(2, servicio.getPrecio());

            // Ejecuta la inserción
            stmt.executeUpdate();
            System.out.println("Servicio registrado correctamente.");

        } catch (SQLException e) {
            // Maneja errores de SQL
            System.err.println("Error al insertar: " + e.getMessage());
        }
    }

    // Método para obtener todos los servicios desde la base de datos
    public List<Servicio> listarServicios() {
        List<Servicio> lista = new ArrayList<>();
        String sql = "SELECT * FROM servicios";

        try (
            Connection conn = conectar(); // Abre conexión
            Statement stmt = conn.createStatement(); // Crea la sentencia SQL
            ResultSet rs = stmt.executeQuery(sql) // Ejecuta la consulta
        ) {
            // Itera sobre los resultados y agrega cada fila a la lista como objeto Servicio
            while (rs.next()) {
                Servicio s = new Servicio(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getDouble("precio")
                );
                lista.add(s);
            }

        } catch (SQLException e) {
            // Maneja errores de SQL
            System.err.println("Error al listar: " + e.getMessage());
        }

        return lista; // Retorna la lista de servicios
    }

    // Método para actualizar los datos de un servicio existente
    public void actualizarServicio(Servicio servicio) {
        String sql = "UPDATE servicios SET nombre = ?, precio = ? WHERE id = ?";

        try (
            Connection conn = conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            // Asigna nuevos valores a la consulta
            stmt.setString(1, servicio.getNombre());
            stmt.setDouble(2, servicio.getPrecio());
            stmt.setInt(3, servicio.getId());

            // Ejecuta la actualización y verifica si se modificó alguna fila
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Servicio actualizado.");
            } else {
                System.out.println("No se encontró el servicio con ID: " + servicio.getId());
            }

        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
        }
    }

    // Método para eliminar un servicio de la base de datos por su ID
    public void eliminarServicio(int id) {
        String sql = "DELETE FROM servicios WHERE id = ?";

        try (
            Connection conn = conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, id); // Asigna el ID al parámetro de la consulta

            // Ejecuta la eliminación y verifica si se eliminó alguna fila
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Servicio eliminado.");
            } else {
                System.out.println("No se encontró el servicio con ID: " + id);
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }
}
