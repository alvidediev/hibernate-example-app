package ru.dediev.hibernate.view;

import ru.dediev.hibernate.controller.DevelopersController;
import ru.dediev.hibernate.controller.SkillsController;
import ru.dediev.hibernate.entity.SkillEntity;
import ru.dediev.hibernate.entity.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SkillsView {

    private Scanner scanner;
    private final SkillsController skillsController = new SkillsController();
    private final DevelopersController developersController = new DevelopersController();

    public void startWorkWithSkills() {
        scanner = new Scanner(System.in);
        boolean stopper = true;

        System.out.println("Добро пожаловать в меню специальностей!\n" +
                "1) Просмотр всех навыков в базе\n" +
                "2) Получить скилл по ID\n" +
                "3) Изменить навыки в списке\n" +
                "4) Удалить навык из списка\n" +
                "5) Вернуться в главное меню");

        final int choice = scanner.nextInt();
        while (stopper) {
            switch (choice) {
                case 1:
                    showAllSkills();
                    stopper = false;
                    break;
                case 2:
                    getSkillById();
                    stopper = false;
                    break;
                case 3:
                    updateSkill();
                    stopper = false;
                    break;
                case 4:
                    deleteSkill();
                    stopper = false;
                    break;
                default:
                    MainView mainView = new MainView();
                    mainView.start();
            }
        }
    }

    public List<SkillEntity> addSkill() {
        scanner = new Scanner(System.in);
        List<SkillEntity> skillEntities = new ArrayList<>();

        boolean stopper = true;
        while (stopper) {
            System.out.println("Хотите добавить скилл?\n" +
                    "1) Да\n" +
                    "2) Нет");
            final int addSkillsChoice = scanner.nextInt();
            switch (addSkillsChoice) {
                case 1:
                    SkillEntity skillEntity = new SkillEntity();
                    scanner = new Scanner(System.in);
                    System.out.println("Введите, пожалуйста, название вашего умения: ");
                    final String nameOfSkill = scanner.nextLine();
                    skillEntity.setName(nameOfSkill);
                    skillEntity.setStatus(Status.ACTIVE);
                    skillEntities.add(skillEntity);
                    continue;
                case 2:
                    stopper = false;
                    break;
                default:
                    System.out.println("Enter correct data...");
            }
        }
        return skillEntities;
    }

    private void getSkillById() {
        scanner = new Scanner(System.in);

        System.out.println("Пожалуйста, введите ID скилла, который хотите найти: ");
        final Long skillId = scanner.nextLong();
        final SkillEntity skillEntityById = skillsController.getById(skillId);
        System.out.println("Найден скилл: " + skillEntityById);
        startWorkWithSkills();
    }

    private void showAllSkills() {
        System.out.println(skillsController.readAll());
        startWorkWithSkills();
    }

    private void updateSkill() {
        scanner = new Scanner(System.in);
        SkillEntity skillEntity = new SkillEntity();

        System.out.println("Введите ID навыка, который хотите изменить:");
        final Long id = scanner.nextLong();
        System.out.println("Введите новое имя навыка");
        scanner.nextLine();
        final String name = scanner.nextLine();
        skillEntity.setName(name);
        skillsController.update(skillEntity, id);
        System.out.println("Вы успешно изменили навык " + skillsController.read(id));
        startWorkWithSkills();
    }

    private void deleteSkill() {
        scanner = new Scanner(System.in);

        System.out.println("Введите ID навыка, который хотите удалить");
        final Long id = scanner.nextLong();
        skillsController.delete(id);
        System.out.println(skillsController.read(id));
        startWorkWithSkills();
    }
}
