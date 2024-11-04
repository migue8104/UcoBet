package co.edu.uco.UcoBet.generales.infraestructure.secondaryadapters.sendgrid;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.SendgridUCOBETException;


@Component
public class EmailSender {

    private final String apiKey;

    public EmailSender(@Value("${sendgrigapikey}") String apiKey) {
        this.apiKey = apiKey;
    }


    public void sendEmail(String to, String subject, String content) throws SendgridUCOBETException {
        Email from = new Email("cirojeronimo17@gmail.com");
        Email toEmail = new Email(to);
        Content emailContent = new Content("text/plain", content);
        Mail mail = new Mail(from, subject, toEmail, emailContent);

        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
        } catch (IOException exception) {
            throw SendgridUCOBETException.create("Error al enviar el correo");
        }
    }
}
