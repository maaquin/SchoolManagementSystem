public class Main {
    public static void main(String[] args) {
        NotificacionFactory factory = new NotificacionFactory();

        Notificacion notificacionEmail = factory.crearNotificacion("email");
        notificacionEmail.enviarMensaje("Este es un mensaje de prueba por email.");

        Notificacion notificacionSMS = factory.crearNotificacion("sms");
        notificacionSMS.enviarMensaje("Este es un mensaje de prueba por SMS.");

        Notificacion notificacionApp = factory.crearNotificacion("app");
        notificacionApp.enviarMensaje("Este es un mensaje de prueba en la app.");
    }
}