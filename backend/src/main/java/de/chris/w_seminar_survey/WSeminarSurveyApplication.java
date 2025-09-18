package de.chris.w_seminar_survey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("de.chris.w_seminar_survey.survey")
public class WSeminarSurveyApplication {

	@Value("${custom.frontend.url}")
	private static String frontendUrl;

	@Value("${custom.frontend.port}")
	private static String frontendPort;

	public static final String FRONTEND_URL = frontendUrl;
	public static String FRONTEND_PORT = frontendPort;

	public static String s = FRONTEND_URL + ":" + FRONTEND_PORT;

	private static WSeminarSurveyApplication instance;

	public WSeminarSurveyApplication() {
		instance = this;

	}

	public static void main(String[] args) {
		SpringApplication.run(WSeminarSurveyApplication.class, args);
	}

	public WSeminarSurveyApplication get() {
		return instance;
	}
}
