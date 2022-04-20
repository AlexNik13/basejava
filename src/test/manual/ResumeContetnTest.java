package test.manual;

import main.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ResumeContetnTest {
    public static void main(String[] args) {
        Resume resume = new Resume("UnNumb", "Petro Piatochkin");

        resume.addContact(ContactType.PHONE, new Contact("+7(921) 855-0482"));
        resume.addContact(ContactType.EMAIL, new Contact("123qw@adf.asd"));
        resume.addContact(ContactType.SKYPE, new Contact("skype:grigory.kislin"));
        resume.addContact(ContactType.GITHUB, new Contact("https://basejava.herokuapp.com/"));
        resume.addContact(ContactType.STACKOVERFLOW, new Contact("https://stackoverflow.com/users/548473"));
        resume.addContact(ContactType.HOMEPAGE, new Contact("https://basejava.herokuapp.com/"));

        List<String> achievements = new ArrayList<>();
        achievements.add("Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет");
        achievements.add("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
        achievements.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        achievements.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        achievements.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        achievements.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        achievements.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.");

        Section achievement = new Section(achievements);

        resume.addSection(SectionType.ACHIEVEMENT, achievement);


        Section personal = new Section();
        personal.addDescription("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");

        resume.addSection(SectionType.PERSONAL, personal);

        SectionWork sectionWork = new SectionWork (LocalDate.now().minusDays(1), LocalDate.now(), "Java Online Projects", "http://javaops.ru/", "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок.");

        resume.addSection(SectionType.EXPERIENCE, sectionWork);

        resume.print();
    }
}
