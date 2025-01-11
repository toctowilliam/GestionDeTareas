import javax.swing.*;

public class TareaView {

    private TareaController tareaController;

    // Constructor
    public TareaView(TareaController tareaController) {
        this.tareaController = tareaController;
    }

    // Método para iniciar la interfaz de usuario
    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            try {
                // Mostrar el menú y obtener la opción del usuario
                int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                        "Ingrese el número de la opción que desea realizar:\n\n" +
                        "1. Agregar Tarea\n" +
                        "2. Marcar Tarea como Completada\n" +
                        "3. Eliminar Tarea\n" +
                        "4. Ver Tareas Pendientes\n" +
                        "5. Ver Próxima Tarea\n" +
                        "6. Salir"
                ));

                // Procesar la opción seleccionada
                switch (opcion) {
                    case 1:
                        agregarTarea();
                        break;
                    case 2:
                        tareaController.marcarTareaCompletada();
                        break;
                    case 3:
                        eliminarTarea();
                        break;
                    case 4:
                        tareaController.verTareasPendientes();
                        break;
                    case 5:
                        tareaController.verProximaTarea();
                        break;
                    case 6:
                        continuar = false;
                        JOptionPane.showMessageDialog(null, "¡Gracias por usar el sistema de gestión de tareas!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido. Por favor, intente nuevamente.");
            }
        }
    }

    // Método para agregar una tarea
    private void agregarTarea() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la tarea:");
        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre de la tarea no puede estar vacío.");
            return;
        }
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripción de la tarea:");
        if (descripcion == null) descripcion = "Sin descripción";
        String fechaCreacion = JOptionPane.showInputDialog("Ingrese la fecha de creación (ej. 08/01/2025):");
        if (fechaCreacion == null || fechaCreacion.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La fecha de creación no puede estar vacía.");
            return;
        }
        Tarea nuevaTarea = new Tarea(nombre, descripcion, fechaCreacion);
        tareaController.agregarTarea(nuevaTarea);
    }

    // Método para eliminar una tarea
    private void eliminarTarea() {
        String nombreTarea = JOptionPane.showInputDialog("Ingrese el nombre de la tarea a eliminar:");
        if (nombreTarea == null || nombreTarea.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre válido.");
            return;
        }
        tareaController.eliminarTareaPendiente(nombreTarea);
    }
}
