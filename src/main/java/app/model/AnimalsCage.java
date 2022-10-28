package app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AnimalsCage {

    private Animal animal;      // Убрал @Autowired, с ней не работает
    private final Timer timer;

    // Связываем по имени через параметры конструктора
    public AnimalsCage(@Qualifier("dog") Animal animal, Timer timer) {
        this.animal = animal;
        this.timer = timer;
    }

    public Timer getTimer() {
        return timer;
    }       // это для проверки в MainTest

    public void whatAnimalSay() {
        System.out.println("Say:");
        System.out.println(animal.toString());
        System.out.println("At:");
        System.out.println(timer.getTime());        // мы должны вызывать таймер у уже существующего бина
        System.out.println("________________________");
    }
}
