package co.edu.uco.UcoBet.generales.application.secondaryports.notificationservice;

public interface NotificationService {

	void send(String to, String subject, String content);

}
