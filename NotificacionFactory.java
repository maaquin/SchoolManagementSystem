public class NotificacionFactory {
    public Notificacion crearNotificacion(String tipo) {
        switch (tipo.toLowerCase()) {
            case "email":
                return new EmailNotificacion();
            case "sms":
                return new SMSNotificacion();
            case "app":
                return new AppNotificacion();
            default:
                throw new IllegalArgumentException("Tipo de notificación no soportado.");
        }
    }
}