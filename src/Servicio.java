// Clase que representa un servicio dentro del sistema (modelo de datos)
public class Servicio {

    // Atributo que almacena el ID único del servicio (clave primaria en la BD)
    private int id;

    // Nombre del servicio (ejemplo: "corte dama", "tintura", etc.)
    private String nombre;

    // Precio del servicio (almacenado como tipo double)
    private double precio;

    // Constructor vacío: necesario para instanciar sin valores iniciales
    public Servicio() {}

    // Constructor para crear un servicio nuevo (sin ID, ya que lo genera la BD)
    public Servicio(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Constructor con ID, usado para actualizar servicios existentes
    public Servicio(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Métodos getter y setter (encapsulamiento)

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }

    public void setPrecio(double precio) { this.precio = precio; }

    // Método que convierte el objeto Servicio a una cadena de texto legible
    @Override
    public String toString() {
        return String.format("ID: %d | Servicio: %s | Precio: %s COP", id, nombre, formatearPesos(precio));
    }

    // Método privado que formatea el valor del precio en formato de pesos colombianos (sin decimales)
    private String formatearPesos(double valor) {
        // "%,.0f" => sin decimales, separador de miles con coma
        // replace(",", ".") => cambia coma por punto para estilo colombiano
        return String.format("%,.0f", valor).replace(",", ".");
    }
}
