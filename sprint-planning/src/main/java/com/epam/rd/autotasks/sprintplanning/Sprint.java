package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

public class Sprint {
    private int capacity;
    private int ticketsLimit;
    private Ticket [] sprintTickets;

// Делим весь код условно на 2 подтипа
    // 1: Провера словий выполнение спринта
    // 2: добавление тикетов (bug / ticket / userStory)

    // Стандартный конструктор + массив тикетов
    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;

        this.sprintTickets = new Ticket[0];
    }

    //Создаем зависимость прохождения Стринта по условием задания
    public boolean acceptsSprint (UserStory  userStory) {

        int countUnCompleted = 0;
        int countSprint = 0;

        UserStory [] userS = userStory.getDependencies(); // userS == клонированному массиву

        for (UserStory x : userS) {
            if (!x.isCompleted()) {
                countUnCompleted++;
                for (Ticket y : sprintTickets) {
                    if (x==y) {
                        countSprint++;
                    }
                }
            }
        }

        if (countUnCompleted == countSprint) {
            return true;
        }
        else return false;
    }

    public boolean isCapacityOverflow(Ticket ticket) {
        if ((getTotalEstimate() + ticket.getEstimate()) > capacity) {
            return true;
        } else return false;
    }

    //принимает userStory, если она не равна null,
// не завершена и её незавершенные зависимости,
// если такие есть, уже приняты в спринт.
// Возвращает true, если история пользователя принята, в противном случае false.
    public boolean addUserStory(UserStory userStory)
        if (userStory != null )
        if (userStory == null || userStory.isCompleted() || ticketsLimit == 0 || isCapacityOverflow(userStory)) {
            //System.out.println("1st if");
            return false;
        }
        if (acceptsSprint(userStory)) {
            addTickets(userStory);

            return true;
        } else {
            return false;
        }
    }

    //принимает bug, если он не равен null и не завершен.
// Возвращает true, если баг принят, в противном случае false.
//public boolean addBug(Bug bugReport) {

    public boolean addBug(Bug bugReport) {
        if (bugReport == null || bugReport.isCompleted() || ticketsLimit == 0 || isCapacityOverflow(bugReport)) {
            return false;
        } else {
            addTickets(bugReport);
            return true;
        }
    }

    // создаем метод согласно условию задания для добавления
    // Спринт должен принимать ticket’ы с помощью методов add*
    public void addTickets (Ticket tickets) {

        Ticket[] temp = new Ticket[this.sprintTickets.length + 1];
        for (int i = 0; i < this.sprintTickets.length; i++) {
            temp[i] = this.sprintTickets[i];
        }
        temp [temp.length - 1] = tickets;
        sprintTickets = new Ticket[temp.length];
        sprintTickets = temp.clone();
        ticketsLimit -= 1;
    }

    //возвращает защитную копию массива ticket’ов на спринт
    public Ticket[] getTickets() {
        return sprintTickets.clone();
    }

    // возвращает сумму оценок времени выполнения всех ticket’ов, принятых на спринт.
    public int getTotalEstimate() {
        int summ = 0;
        if (sprintTickets !=null) {
            for (Ticket x : sprintTickets) { // заходим в каждый ячейку спринтТикетса
               if (x != null)
                summ += x.getEstimate();  // и сумируем все значения времени тикетов
            }
        }
        return summ;
    }

}
