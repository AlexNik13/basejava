package test.manual;

import main.model.Education;
import main.model.Resume;
import main.model.Work;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResumeTestData {

    public static void main(String[] args) {

        Map<String, String> socialLinks = new HashMap<>();
        socialLinks.put("Профиль LinkedIn", "https://www.linkedin.com/in/gkislin");
        socialLinks.put("Профиль GitHub", "https://basejava.herokuapp.com/");
        socialLinks.put("Профиль Stackoverflow", "https://stackoverflow.com/users/548473");
        socialLinks.put("Домашняя страница", "http://gkislin.ru/");

        List<String> achievements = Arrays.asList("Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет",
                "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.",
                "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.",
                "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).",
                "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");

        List<String> qualifications = Arrays.asList("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB",
                "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy",
                "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts",
                "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).",
                "Python: Django.",
                "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js",
                "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka",
                "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.",
                "Инструменты: Maven + plugin development, Gradle, настройка Ngnix",
                "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer",
                "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования",
                "Родной русский, английский \"upper intermediate\"");

        List<Work> works = Arrays.asList(
                new Work(LocalDate.now().minusDays(1), LocalDate.now(), "Java Online Projects", "http://javaops.ru/", "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок."),
                new Work(LocalDate.now().minusDays(1), LocalDate.now(), "Wrike", "https://www.wrike.com/", "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."),
                new Work(LocalDate.now().minusDays(1), LocalDate.now(), "Alcatel", "http://www.alcatel.ru/", "Инженер по аппаратному и программному тестированию", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).")
        );

        List<Education> educations = Arrays.asList(
                new Education(LocalDate.now().minusDays(1), LocalDate.now(), "Coursera", "https://www.coursera.org/course/progfun", "Functional Programming Principles in Scala' by Martin Odersky"),
                new Education(LocalDate.now().minusDays(1), LocalDate.now(), "Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366", "Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.'"),
                new Education(LocalDate.now().minusDays(1), LocalDate.now(), "Siemens AG", "http://www.siemens.ru/", "3 месяца обучения мобильным IN сетям (Берлин)")
        );


        Resume resume = new Resume("11111111-1111-1111-1111-111111111111");
        resume.setPhone("+7(921) 855-0482");
        resume.setSkype("skype:grigory.kislin");
        resume.setEmail("gkislin@yandex.ru");
        resume.setSocialLinks(socialLinks);
        resume.setPosition("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        resume.setPersonalQualities("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        resume.setAchievements(achievements);
        resume.setQualifications(qualifications);
        resume.setExperienceWorks(works);
        resume.setEducations(educations);


        System.out.println("uuid: " + resume.getUuid());
        System.out.println("fullName: " + resume.getFullName());
        System.out.println("phone: " + resume.getPhone());
        System.out.println("skype: " + resume.getSkype());
        System.out.println("email: " + resume.getEmail());
        System.out.println("socialLinks: ");
        resume.getSocialLinks().forEach((s, s2) -> System.out.println(s + " " + s2));
        System.out.println();
        System.out.println("position: " + resume.getPosition());
        System.out.println("personalQualities: " + resume.getPersonalQualities());
        System.out.println("achievements: ");
        resume.getAchievements().forEach(s -> System.out.println(" * " + s));
        System.out.println();
        System.out.println("qualifications: " );
        resume.getQualifications().forEach(s -> System.out.println(" * " + s));
        System.out.println();
        System.out.println("Work: ");
        resume.getExperienceWorks().forEach(work -> {
            System.out.println(work.getStartDate() +" - " + work.getFinishDate() + "\t" + work.getTitle() + "\t" + work.getTitleLink());
            System.out.println(work.getDescription());
            System.out.println(work.getDetail());
        });
        System.out.println();

        System.out.println("Education: ");
        resume.getEducations().forEach(education -> {
            System.out.println(education.getStartDate() +" - " + education.getFinishDate() + "\t" + education.getTitle() + "\t" + education.getTitleLink());
            System.out.println(education.getDescription());
        });

    }
}
