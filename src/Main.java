//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*

Это мини-проект про маркетплейс цифровых подписок,
где пользователи подключают музыку, видео и облачное хранилище.
Нужно реализовать биллинг за месяц с учётом пробного периода, пауз и совместного использования.
Биллинг - система учета и выставления счетов как мы можем реализовать биллинг?
необходимо чтобы в консоль выводилась сумма к оплате по уникальному ИД за месяц.

базовый родитель class Subscription - для вариантов подписок
поля: String id, String title, float monthlyPrice, int startDate, boolean active
методы: activate(), cancel(), isActive(), price().

1. Создадим класс базового родителя.
2. Создадим классы для подписок.
3. Создадим интерфейсы для взаимодействия с подписками и пользолвателями

Также предусматривается расчёт стоимости по объёму услуг

(например, дополнительный терабайт в облаке)
и валидные ограничения (лимиты участников, корректные даты).
 Итог — корректные деньги, прозрачные правила списаний и понятные ошибки при нарушениях.
*

есть осущность  подписка,может быть музыкальная, облако и видео у нее есть ид, название, цена, дата начала, стоимость,флаг активна, не активна, активация, дезактивация. 
*
* */

public class Main {
    public static void main(String[] args) {


        MusicPlan music = new MusicPlan("m1", "Spotify Lite", 300f, 1);
        System.out.println("Музыка, месяц 1 (в trial): " + music.monthlyCharge(1));
        System.out.println("Музыка, месяц 2: " + music.monthlyCharge(2));

        VideoPlan video = new VideoPlan("v1", "Netflix Family", 600f, 1);
        video.pause(5, 10);
        System.out.println("Видео, месяц 1: " + video.monthlyCharge(1));
        video.addMember("user123");
        System.out.println("Участников: " + video.getMemberCount());

        CloudPlan cloud = new CloudPlan("c1", "Yandex.Disk Pro", 200f, 1, 5, 200, 100);
        System.out.println("Облако, месяц 1: " + cloud.monthlyCharge(1));


    }
}