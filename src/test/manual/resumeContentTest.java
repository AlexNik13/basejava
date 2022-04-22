package test.manual;

import main.model.section.AchievementOrQualifications;
import main.model.section.Contact;
import main.model.Resume;
import main.model.section.*;
import main.model.type.ContactType;
import main.model.type.SectionType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class resumeContentTest {
    public static void main(String[] args) {
        Resume resume = new Resume("UnNumb", "Petro Piatochkin");

        resume.addSection(ContactType.PHONE, new Contact(ContactType.PHONE.getTitle(), "+7(921) 855-0482"));
        resume.addSection(ContactType.EMAIL, new Contact(ContactType.EMAIL.getTitle(), "123qw@adf.asd"));
        resume.addSection(ContactType.SKYPE, new Contact(ContactType.SKYPE.getTitle(), "skype:grigory.kislin"));
        resume.addSection(ContactType.GITHUB, new Contact(ContactType.GITHUB.getTitle(), "https://basejava.herokuapp.com/"));
        resume.addSection(ContactType.STACKOVERFLOW, new Contact(ContactType.STACKOVERFLOW.getTitle(), "https://stackoverflow.com/users/548473"));
        resume.addSection(ContactType.HOMEPAGE, new Contact(ContactType.HOMEPAGE.getTitle(), "https://basejava.herokuapp.com/"));

        List<String> achievements = new ArrayList<>();
        achievements.add("Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет");
        achievements.add("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
        achievements.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        achievements.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        achievements.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        achievements.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        achievements.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.");

        AchievementOrQualifications achievement = new AchievementOrQualifications(SectionType.ACHIEVEMENT.getTitle(), achievements);

        resume.addSection(SectionType.ACHIEVEMENT, achievement);

        List<String> qualifications = new ArrayList<>();
        qualifications.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualifications.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualifications.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB");
        qualifications.add("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy");
        qualifications.add("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts");
        qualifications.add("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        qualifications.add("Python: Django.");
        qualifications.add("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        qualifications.add("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        qualifications.add("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.");
        qualifications.add("Инструменты: Maven + plugin development, Gradle, настройка Ngnix");
        qualifications.add("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer");
        qualifications.add("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования");
        qualifications.add("Родной русский, английский \"upper intermediate\"");

        AchievementOrQualifications qualification = new AchievementOrQualifications(SectionType.QUALIFICATIONS.getTitle(), qualifications);

        resume.addSection(SectionType.QUALIFICATIONS, qualification);

        PositionOrQualities position = new PositionOrQualities("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");

        resume.addSection(SectionType.PERSONAL, position);

        List<ExperienceWork> experienceWorks = new ArrayList<>();

        experienceWorks.add(new ExperienceWork(LocalDate.now().minusDays(1), LocalDate.now(), "Java Online Projects", "http://javaops.ru/", "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок."));
        experienceWorks.add(new ExperienceWork(LocalDate.now().minusDays(1), LocalDate.now(), "Wrike", "https://www.wrike.com/", "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."));
        experienceWorks.add(new ExperienceWork(LocalDate.now().minusDays(1), LocalDate.now(), "Alcatel", "http://www.alcatel.ru/", "Инженер по аппаратному и программному тестированию", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)."));

        SectionWork sectionWork = new SectionWork(experienceWorks);
        resume.addSection(SectionType.EXPERIENCE, sectionWork);


        List<Experience> education = Arrays.asList(
                new Experience(LocalDate.now().minusDays(1), LocalDate.now(), "Coursera", "https://www.coursera.org/course/progfun", "Functional Programming Principles in Scala' by Martin Odersky"),
                new Experience(LocalDate.now().minusDays(1), LocalDate.now(), "Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366", "Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.'"),
                new Experience(LocalDate.now().minusDays(1), LocalDate.now(), "Siemens AG", "http://www.siemens.ru/", "3 месяца обучения мобильным IN сетям (Берлин)")
        );

        SectionEducation sectionEducation = new SectionEducation(education);

        resume.addSection(SectionType.EDUCATION, sectionEducation);

        resume.printContactOrSection(ContactType.EMAIL);
       // resume.printResume();
    }


}
