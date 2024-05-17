package Gestion_Almacen;

import java.util.HashMap;

public class Login {
    private HashMap<String, String> administradores;
    private HashMap<String, String> almaceneros;
    private HashMap<String, String> contadores;

    public Login() {
        administradores = new HashMap<>();
        almaceneros = new HashMap<>();
        contadores = new HashMap<>();

        administradores.put("admin", "admin123");
        almaceneros.put("almace", "almace123");
        contadores.put("cont", "cont123");
    }

    public boolean verificarLoginAdmin(String usuario, String contrasena) {
        return administradores.containsKey(usuario) && administradores.get(usuario).equals(contrasena);
    }
    public boolean verificarLoginAlmace(String usuario, String contrasena) {
        return almaceneros.containsKey(usuario) && almaceneros.get(usuario).equals(contrasena);
    }
    public boolean verificarLoginCont(String usuario, String contrasena) {
        return contadores.containsKey(usuario) && contadores.get(usuario).equals(contrasena);
    }
}
