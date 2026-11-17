
import java.sql.*;
import javax.swing.ImageIcon;

public class Alimento {

//    static String todos = "SELECT * FROM alimentos ORDER BY nombre";
//    static String ids = "SELECT idalimentos FROM alimentos ORDER BY idalimentos";
    int id;
    String nombre, descripcion, categoria, estado;
    float precio;
    ImageIcon foto;

    public Alimento() {
    }

    public Alimento(int id, String nombre, String descripcion, float precio, ImageIcon foto, String categoria, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.foto = foto;
        this.categoria = categoria;
        this.estado = estado;
    }

    public int insertar(Conexion cnx) {
        String sql = "INSERT INTO alimentos (nombre, descripcion, precio, foto, categoria, estado) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = cnx.con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setFloat(3, precio);
            ps.setBinaryStream(4, cnx.ImagenBytes(foto));
            ps.setString(5, categoria);
            ps.setString(6, estado);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    public int borrar(Conexion cnx) {
        String sql = "DELETE FROM alimentos WHERE idalimentos = ?";
        try (PreparedStatement ps = cnx.con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            // Falla, por ejemplo, si el alimento ya tiene órdenes (llave foránea)
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    public int actualizar(Conexion cnx) {
        String sql;
        if (foto != null) {
            sql = "UPDATE alimentos SET nombre = ?, descripcion = ?, precio = ?, categoria = ?, estado = ?, foto = ? WHERE idalimentos = ?";
        } else {
            sql = "UPDATE alimentos SET nombre = ?, descripcion = ?, precio = ?, categoria = ?, estado = ? WHERE idalimentos = ?";
        }

        try (PreparedStatement ps = cnx.con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setFloat(3, precio);
            ps.setString(4, categoria);
            ps.setString(5, estado);
            if (foto != null) {
                ps.setBinaryStream(6, cnx.ImagenBytes(foto));
                ps.setInt(7, id);
            } else {
                ps.setInt(6, id);
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }
    
     public static Alimento buscar(Conexion cnx, int id) {
        String sql = "SELECT nombre, descripcion, precio, foto, categoria, estado FROM alimentos WHERE idalimentos = ?";
        try (PreparedStatement ps = cnx.con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Alimento a = new Alimento();
                    a.id = id;
                    a.nombre = rs.getString("nombre");
                    a.descripcion = rs.getString("descripcion");
                    a.precio = rs.getFloat("precio");
                    a.categoria = rs.getString("categoria");
                    a.estado = rs.getString("estado");
                    byte[] bytes = rs.getBytes("foto");
                    if (bytes != null && bytes.length > 0) {
                        a.foto = new ImageIcon(bytes);
                    }
                    return a;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

}
