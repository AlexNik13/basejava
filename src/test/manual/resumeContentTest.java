package test.manual;

import main.model.*;
import main.mapper.GsonPrintMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class resumeContentTest {
    public static void main(String[] args) {
        Resume resume = new Resume("UnNumb", "Petro Piatochkin");

        resume.addContact(ContactType.PHONE, new Contact("+7(921) 855-0482"));
        resume.addContact(ContactType.EMAIL, new Contact("123qw@adf.asd"));
        resume.addContact(ContactType.SKYPE, new Contact("skype:grigory.kislin"));
        resume.addContact(ContactType.GITHUB, new Contact("https://basejava.herokuapp.com/"));
        resume.addContact(ContactType.STACKOVERFLOW, new Contact("https://stackoverflow.com/users/548473"));
        resume.addContact(ContactType.HOMEPAGE, new Contact("https://basejava.herokuapp.com/"));

        List<Print> achievements = new ArrayList<>();
        achievements.add(new Section("Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет"));
        achievements.add(new Section("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."));
        achievements.add(new Section("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django)."));
        achievements.add(new Section("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга."));
        achievements.add(new Section("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера."));
        achievements.add(new Section("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk."));
        achievements.add(new Section("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников."));



        resume.addSection(SectionType.ACHIEVEMENT, achievements);


        List<Print> personals = new ArrayList<>();
        personals.add(new Section("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));

        resume.addSection(SectionType.PERSONAL, personals);

        List<Print> work = new ArrayList<>();

        work.add(new SectionWork(LocalDate.now().minusDays(1), LocalDate.now(), "Java Online Projects", "http://javaops.ru/", "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок."));
        work.add(new SectionWork(LocalDate.now().minusDays(1), LocalDate.now(), "Wrike", "https://www.wrike.com/", "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."));
        work.add(new SectionWork(LocalDate.now().minusDays(1), LocalDate.now(), "Alcatel", "http://www.alcatel.ru/", "Инженер по аппаратному и программному тестированию", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)."));

        resume.addSection(SectionType.EXPERIENCE, work);


        List<Print> education = Arrays.asList(
                new SectionEducation(LocalDate.now().minusDays(1), LocalDate.now(), "Coursera", "https://www.coursera.org/course/progfun", "Functional Programming Principles in Scala' by Martin Odersky"),
                new SectionEducation(LocalDate.now().minusDays(1), LocalDate.now(), "Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366", "Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.'"),
                new SectionEducation(LocalDate.now().minusDays(1), LocalDate.now(), "Siemens AG", "http://www.siemens.ru/", "3 месяца обучения мобильным IN сетям (Берлин)")
        );


        SectionWork sectionWork =   new SectionWork(LocalDate.now().minusDays(1), LocalDate.now(), "Alcatel", "http://www.alcatel.ru/", "Инженер по аппаратному и программному тестированию", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).");
        System.out.println(sectionWork.toString());

        System.out.println();
        System.out.println();
        String strGson = GsonPrintMapper.toGson(resume);
        System.out.println(strGson);

        resume.addSection(SectionType.EDUCATION, education);

      //  resume.print();
    }




}
