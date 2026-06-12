import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Notification {

    private String notificationId;
    private String userName;
    private String email;
    private String mobile;
    private String message;
    private String notificationType;
    private String priority;
}
