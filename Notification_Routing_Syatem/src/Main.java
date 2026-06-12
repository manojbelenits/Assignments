import java.util.HashMap;
import java.util.Map;





public class Main {

    public static void main(String[] args) {

        NotificationSender emailSender =
                notification -> {
                    System.out.println("Email Sent to "
                            + notification.getEmail());
                };

        NotificationSender smsSender =
                notification -> {
                    System.out.println("SMS Sent to "
                            + notification.getMobile());
                };

        NotificationSender whatsappSender =
                notification -> {
                    System.out.println("WhatsApp Sent to "
                            + notification.getMobile());
                };

        NotificationSender pushSender =
                notification -> {
                    System.out.println("Push Notification Sent to "
                            + notification.getUserName());
                };

        Map<String, NotificationSender> senders = new HashMap<>();

        senders.put("EMAIL", emailSender);
        senders.put("SMS", smsSender);
        senders.put("WHATSAPP", whatsappSender);
        senders.put("PUSH", pushSender);

        Notification notification =
                new Notification(
                        "N101",
                        "Smith",
                        "smith@gmail.com",
                        "9234510",
                        "Your class starts at 7:30 AM",
                        "SMS",
                        "HIGH"
                );

        processNotification(notification, senders);

    }

    private static void processNotification(
            Notification notification,
            Map<String, NotificationSender> senders) {

        System.out.println("Message : " + notification.getMessage());

        if ("HIGH".equalsIgnoreCase(notification.getPriority())) {

            System.out.println("\nSending HIGH priority notification...");

            if (notification.getEmail() != null
                    && !notification.getEmail().isBlank()) {

                senders.get("EMAIL").send(notification);

            } else {

                System.out.println(
                        "Email skipped. Email not available.");
            }

            if (notification.getMobile() != null
                    && !notification.getMobile().isBlank()) {

                senders.get("WHATSAPP").send(notification);

            } else {

                System.out.println(
                        "WhatsApp skipped. Mobile number not available.");
            }

        } else {

            String type = notification.getNotificationType();

            if ("EMAIL".equalsIgnoreCase(type)
                    && (notification.getEmail() == null
                    || notification.getEmail().isBlank())) {

                System.out.println(
                        "Email skipped. Email not available.");
                return;
            }

            if (("SMS".equalsIgnoreCase(type)
                    || "WHATSAPP".equalsIgnoreCase(type))
                    && (notification.getMobile() == null
                    || notification.getMobile().isBlank())) {

                System.out.println(
                        type + " skipped. Mobile number not available.");
                return;
            }

            NotificationSender sender = senders.get(type);

            if (sender != null) {
                sender.send(notification);
            } else {
                System.out.println(
                        "Invalid notification type : " + type);
            }
        }
    }
}