import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TareaController {
    private Stack<Tarea> tareasPendientes; // Pila para las tareas pendientes
    private Queue<Tarea> tareasCompletadas; // Cola para las tareas completadas

    // Constructor
    public TareaController() {
        this.tareasPendientes = new Stack<>();
        this.tareasCompletadas = new LinkedList<>();
    }

    // Agregar una tarea
    public void agregarTarea(Tarea tarea) {
        tareasPendientes.push(tarea);
        JOptionPane.showMessageDialog(null, "Tarea agregada:\n" + tarea.getNombre());
    }

    // Marcar una tarea como completada
    public void marcarTareaCompletada() {
        if (tareasPendientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay tareas pendientes para completar.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Tarea tareaCompletada = tareasPendientes.pop();
        tareaCompletada.setCompletada(true);
        tareasCompletadas.offer(tareaCompletada);
        JOptionPane.showMessageDialog(null, "Tarea completada:\n" + tareaCompletada.getNombre());
    }

    // Eliminar una tarea pendiente
    public void eliminarTareaPendiente(String nombreTarea) {
        Stack<Tarea> tareasTemporales = new Stack<>();
        boolean encontrada = false;

        while (!tareasPendientes.isEmpty()) {
            Tarea tarea = tareasPendientes.pop();
            if (tarea.getNombre().equalsIgnoreCase(nombreTarea)) {
                encontrada = true;
                JOptionPane.showMessageDialog(null, "Tarea eliminada:\n" + tarea.getNombre());
                break;
            } else {
                tareasTemporales.push(tarea);
            }
        }

        // Volver a poner las tareas no eliminadas en la pila original
        while (!tareasTemporales.isEmpty()) {
            tareasPendientes.push(tareasTemporales.pop());
        }
        if (!encontrada) {
            JOptionPane.showMessageDialog(null, "Tarea no encontrada: " + nombreTarea);
        }
    }

    // Ver las tareas pendientes
    public void verTareasPendientes() {
        if (tareasPendientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay tareas pendientes.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        StringBuilder mensaje = new StringBuilder("Tareas pendientes:\n");
        for (Tarea tarea : tareasPendientes) {
            mensaje.append("> ").append(tarea.getNombre()).append(": ").append(tarea.getDescripcion()).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    // Ver la próxima tarea
    public void verProximaTarea() {
        if (tareasPendientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay tareas pendientes.");
        } else {
            JOptionPane.showMessageDialog(null, "Próxima tarea a realizar:\n" + tareasPendientes.peek());
        }
    }
}
