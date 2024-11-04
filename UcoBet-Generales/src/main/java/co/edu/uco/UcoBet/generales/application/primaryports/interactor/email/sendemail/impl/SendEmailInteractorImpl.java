package co.edu.uco.UcoBet.generales.application.primaryports.interactor.email.sendemail.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.UcoBet.generales.application.primaryports.dto.EmailDataDTO;
import co.edu.uco.UcoBet.generales.application.primaryports.interactor.email.sendemail.SendEmailInteractor;
import co.edu.uco.UcoBet.generales.application.primaryports.mapper.EmailDataMapper;
import co.edu.uco.UcoBet.generales.application.usecase.email.SendEmail;
import co.edu.uco.UcoBet.generales.domain.EmailData;

@Service
public class SendEmailInteractorImpl implements SendEmailInteractor {

	private final SendEmail sendEmail;

	public SendEmailInteractorImpl(SendEmail sendEmail) {
		this.sendEmail = sendEmail;
	}

	@Override
	public void execute(EmailDataDTO data) {
		// Usando la instancia estática del mapper
		EmailData emailData = EmailDataMapper.INSTANCE.toDomain(data);
		// Llamada al caso de uso
		sendEmail.execute(emailData);

	}
}
