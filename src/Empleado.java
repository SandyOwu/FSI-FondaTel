import java.sql.*;

public class Empleado {

    static String todos = "SELECT * FROM empleados ORDER BY nombree";
    static String codigos = "SELECT codigo FROM empleados ORDER BY codigo";

    String codigo, nombre, puesto, usuario, nip, turno, estado;

    public Empleado() {
    }

    public Empleado(String codigo, String nombre, String puesto, String usuario, String nip, String turno, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.puesto = puesto;
        this.usuario = usuario;
        this.nip = nip;
        this.turno = turno;
        this.estado = estado;
    }

    public int insertar(Connection con) {
        int resultado = 0;
        String sql = "INSERT INTO empleados (codigo, nombree, puesto, nom_usr, nip, turno, estadoe) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, codigo);
            ps.setString(2, nombre);
            ps.setString(3, puesto);
            ps.setString(4, usuario);
            ps.setString(5, nip);
            ps.setString(6, turno);
            ps.setString(7, estado);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int borrar(Connection con) {
        int resultado = 0;
        String sql = "DELETE FROM empleados WHERE codigo = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, codigo);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int actualizar(Connection con) {
        int resultado = 0;
        String sql = "UPDATE empleados SET nombree = ?, puesto = ?, nom_usr = ?, nip = ?, turno = ?, estadoe = ? WHERE codigo = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, puesto);
            ps.setString(3, usuario);
            ps.setString(4, nip);
            ps.setString(5, turno);
            ps.setString(6, estado);
            ps.setString(7, codigo);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

}
