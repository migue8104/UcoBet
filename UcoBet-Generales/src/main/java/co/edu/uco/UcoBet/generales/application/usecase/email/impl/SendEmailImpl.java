package co.edu.uco.UcoBet.generales.application.usecase.email.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.UcoBet.generales.application.usecase.email.SendEmail;
import co.edu.uco.UcoBet.generales.crosscutting.exceptions.SendgridUCOBETException;
import co.edu.uco.UcoBet.generales.domain.EmailData;
import co.edu.uco.UcoBet.generales.infraestructure.secondaryadapters.sendgrid.EmailSender;


@Service
public class SendEmailImpl implements SendEmail {

    private final EmailSender emailSender;

    public SendEmailImpl(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void execute(EmailData emailData) {
        try {
            emailSender.sendEmail(emailData.getTo(), emailData.getSubject(), emailData.getContent());
        } catch (SendgridUCOBETException exception) {
            System.err.println("Error enviando email");
            throw exception; 
        }
    }
}

