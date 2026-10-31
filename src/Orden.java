import java.sql.*;

public class Orden {

    static String todos = "SELECT * FROM ordenes ORDER BY fecha_hora DESC";
    static String folios = "SELECT folio FROM ordenes ORDER BY folio";

    int folio, silla, cliente, mesa, alimento;
    String fecha, observaciones, estado, mesero, cocinero;

    public Orden() {
    }

    public Orden(int folio, String fecha, String observaciones, String estado, int silla,
            int cliente, int mesa, int alimento, String mesero, String cocinero) {
        this.folio = folio;
        this.fecha = fecha;
        this.observaciones = observaciones;
        this.estado = estado;
        this.silla = silla;
        this.cliente = cliente;
        this.mesa = mesa;
        this.alimento = alimento;
        this.mesero = mesero;
        this.cocinero = cocinero;
    }

    public int insertar(Connection con) {
        int resultado = 0;
        // folio es AUTO_INCREMENT: no se incluye en el INSERT
        String sql = "INSERT INTO ordenes (fecha_hora, observaciones, estadoo, silla, clientes_codigoc, "
                + "mesas_numero, alimentos_idalimentos, empleados_codigo_mesero, empleados_codigo_cocinero) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, fecha);
            ps.setString(2, observaciones);
            ps.setString(3, estado);
            ps.setInt(4, silla);
            ps.setInt(5, cliente);
            ps.setInt(6, mesa);
            ps.setInt(7, alimento);
            ps.setString(8, mesero);
            ps.setString(9, cocinero);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int borrar(Connection con) {
        int resultado = 0;
        String sql = "DELETE FROM ordenes WHERE folio = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, folio);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int actualizar(Connection con) {
        int resultado = 0;
        String sql = "UPDATE ordenes SET fecha_hora = ?, observaciones = ?, estadoo = ?, silla = ?, "
                + "clientes_codigoc = ?, mesas_numero = ?, alimentos_idalimentos = ?, "
                + "empleados_codigo_mesero = ?, empleados_codigo_cocinero = ? WHERE folio = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, fecha);
            ps.setString(2, observaciones);
            ps.setString(3, estado);
            ps.setInt(4, silla);
            ps.setInt(5, cliente);
            ps.setInt(6, mesa);
            ps.setInt(7, alimento);
            ps.setString(8, mesero);
            ps.setString(9, cocinero);
            ps.setInt(10, folio);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

}
