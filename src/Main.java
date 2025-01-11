public class Main {
    public static void main(String[] args) {
        TareaController tareaController = new TareaController();
        TareaView tareaView = new TareaView(tareaController);
        tareaView.iniciar();
    }
}