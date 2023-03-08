package ru.dediev.hibernate.view;

import ru.dediev.hibernate.controller.DevelopersController;
import ru.dediev.hibernate.entity.DeveloperEntity;
import ru.dediev.hibernate.entity.SkillEntity;
import ru.dediev.hibernate.entity.SpecialtyEntity;
import ru.dediev.hibernate.entity.Status;

import java.util.List;
import java.util.Scanner;

public class DevelopersView {

    private final DevelopersController devsController = new DevelopersController();
    private final SkillsView skillsView = new SkillsView();
    private final SpecialtiesView specialtiesView = new SpecialtiesView();
    private Scanner scanner;

    public void startWorkWithDevelopers() {
        scanner = new Scanner(System.in);
        boolean stopper = true;

        System.out.println("Добро пожаловать в меню специальностей!\n" +
                "1) Добавить разработчика\n" +
                "2) Просмотр всех разработчиков в базе\n" +
                "3) Найти разработчика по ID\n" +
                "4) Изменить разработчика в списке\n" +
                "5) Удалить разработчика из списка\n" +
                "6) Вернуться в главное меню");

        final int choice = scanner.nextInt();
        while (stopper) {
            switch (choice) {
                case 1:
                    addDeveloper();
                    stopper = false;
                    break;
                case 2:
                    showAllDevs();
                    stopper = false;
                    break;
                case 3:
                    getById();
                    stopper = false;
                    break;
                case 4:
                    updateDeveloper();
                    stopper = false;
                    break;
                case 5:
                    deleteDeveloper();
                    stopper = false;
                    break;
                default:
                    MainView mainView = new MainView();
                    mainView.start();
            }
        }
    }


    private void addDeveloper() {
        scanner = new Scanner(System.in);
        DeveloperEntity developerEntity;
        System.out.println("Пожалуйста! Введите фамилию разработчика:");
        String developersFirstName = scanner.nextLine();
        System.out.println("Пожалуйста! Введите имя разработчика:");
        String developersLastName = scanner.nextLine();
        final List<SkillEntity> skillEntities = skillsView.addSkill();
        final SpecialtyEntity specialtyEntity = specialtiesView.addSpecialty();
        developerEntity = new DeveloperEntity(
                null,
                developersFirstName,
                developersLastName,
                skillEntities,
                specialtyEntity,
                Status.ACTIVE);
        devsController.create(developerEntity);
        startWorkWithDevelopers();
    }

    private void getById() {
        scanner = new Scanner(System.in);

        System.out.println("Пожалуйста введите ID для поиска:\n");
        final Long idOfDeveloper = scanner.nextLong();
       final DeveloperEntity developerEntityById = devsController.getById(idOfDeveloper);
       System.out.println("По ID " + idOfDeveloper + " найден разработчик: " + developerEntityById);
    }

    private void showAllDevs() {
        System.out.println(devsController.readAll());
        startWorkWithDevelopers();
    }

    private void updateDeveloper() {
        scanner = new Scanner(System.in);
        DeveloperEntity developerEntity = new DeveloperEntity();
        System.out.println(devsController.readAll());
        System.out.println("Введите ID разработчика, которого хотите отредактировать");
        Long id = scanner.nextLong();
        System.out.println("Введите новую фамилию для разработчика");
        String firstName = scanner.nextLine();
        System.out.println("Введите новое имя для разработчика");
        String lastName = scanner.nextLine();
        developerEntity.setFirstName(firstName);
        developerEntity.setLastName(lastName);
        devsController.update(developerEntity, id);
        System.out.println(devsController.read(id));
        startWorkWithDevelopers();
    }

    private void deleteDeveloper() {
        scanner = new Scanner(System.in);

        System.out.println("Пожалуйста введите ID разработчика, которого хотите удалить");
        Long idOfDeveloper = scanner.nextLong();
        System.out.println(devsController.delete(idOfDeveloper));
        startWorkWithDevelopers();
    }
}

