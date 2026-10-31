import java.sql.*;

public class Alimento {

    static String todos = "SELECT * FROM alimentos ORDER BY nombre";
    static String ids = "SELECT idalimentos FROM alimentos ORDER BY idalimentos";

    int id;
    String nombre, descripcion, categoria, estado;
    float precio;
    byte[] foto;

    public Alimento() {
    }

    public Alimento(int id, String nombre, String descripcion, float precio, byte[] foto, String categoria, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.foto = foto;
        this.categoria = categoria;
        this.estado = estado;
    }

    public int insertar(Connection con) {
        int resultado = 0;
        // idalimentos es AUTO_INCREMENT: no se incluye en el INSERT
        String sql = "INSERT INTO alimentos (nombre, descripcion, precio, foto, categoria, estado) VALUES(?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setFloat(3, precio);
            ps.setBytes(4, (foto == null) ? new byte[0] : foto); // la columna es NOT NULL
            ps.setString(5, categoria);
            ps.setString(6, estado);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int borrar(Connection con) {
        int resultado = 0;
        String sql = "DELETE FROM alimentos WHERE idalimentos = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int actualizar(Connection con) {
        int resultado = 0;
        String sql = "UPDATE alimentos SET nombre = ?, descripcion = ?, precio = ?, foto = ?, categoria = ?, estado = ? WHERE idalimentos = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setFloat(3, precio);
            ps.setBytes(4, (foto == null) ? new byte[0] : foto);
            ps.setString(5, categoria);
            ps.setString(6, estado);
            ps.setInt(7, id);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

}
