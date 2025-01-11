public class Tarea {

    private String nombre;        // Nombre de la tarea
    private String descripcion;   // Descripción de la tarea
    private String fechaCreacion; // Fecha de creación de la tarea
    private boolean esCompleta;   // Estado de la tarea

    // Constructor
    public Tarea(String nombre, String descripcion, String fechaCreacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.esCompleta = false; // Por defecto, la tarea no está completada
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isCompletada() {
        return esCompleta;
    }

    public void setCompletada(boolean completada) {
        this.esCompleta = completada;
    }

    // Método para mostrar la tarea como texto
    @Override
    public String toString() {
        return "Tarea: " + nombre + "\n" +
                "Descripción: " + descripcion + "\n" +
                "Fecha de creación: " + fechaCreacion + "\n" +
                "Estado: " + (esCompleta ? "Completada" : "Pendiente");
    }
}
