import java.sql.*;

public class Mesa {

    static String todos = "SELECT * FROM mesas ORDER BY numero";
    static String numeros = "SELECT numero FROM mesas ORDER BY numero";

    int numero, capacidad;
    String estado;

    public Mesa() {
    }

    public Mesa(int numero, String estado, int capacidad) {
        this.numero = numero;
        this.estado = estado;
        this.capacidad = capacidad;
    }

    public int insertar(Connection con) {
        int resultado = 0;
        String sql = "INSERT INTO mesas (numero, estadom, capacidad) VALUES(?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, numero);
            ps.setString(2, estado);
            ps.setInt(3, capacidad);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int borrar(Connection con) {
        int resultado = 0;
        String sql = "DELETE FROM mesas WHERE numero = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, numero);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int actualizar(Connection con) {
        int resultado = 0;
        String sql = "UPDATE mesas SET estadom = ?, capacidad = ? WHERE numero = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, estado);
            ps.setInt(2, capacidad);
            ps.setInt(3, numero);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

}
