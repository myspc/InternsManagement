package um5.fmp.stages.gestion_stages.services;

import um5.fmp.stages.gestion_stages.models.EmailDetails;

public interface EmailService {
	String sendSimpleMail(EmailDetails details);
    String sendMailWithAttachment(EmailDetails details);
}
