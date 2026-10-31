import java.sql.*;

public class Cliente {

    static String todos = "SELECT * FROM clientes ORDER BY nombrec";
    static String codigos = "SELECT codigoc FROM clientes ORDER BY codigoc";

    int codigo;
    String nombre, rfc;

    public Cliente() {
    }

    public Cliente(int codigo, String nombre, String rfc) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.rfc = rfc;
    }

    public int insertar(Connection con) {
        int resultado = 0;
        String sql = "INSERT INTO clientes (codigoc, nombrec, rfc) VALUES(?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.setString(2, nombre);
            ps.setString(3, rfc); // rfc puede ser null
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int borrar(Connection con) {
        int resultado = 0;
        String sql = "DELETE FROM clientes WHERE codigoc = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int actualizar(Connection con) {
        int resultado = 0;
        String sql = "UPDATE clientes SET nombrec = ?, rfc = ? WHERE codigoc = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, rfc);
            ps.setInt(3, codigo);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

}
