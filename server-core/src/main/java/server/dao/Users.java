package server.dao;

import javax.persistence.*;
import static javax.persistence.GenerationType.AUTO;

// Класс юзер для таблицы хранения данных о пользователях(Имя, фамилия, Услуга)
@Entity
@Table(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID")
    int id;

    @Column(name = "NAME")
    String firstName;

    @Column(name = "LAST_NAME")
    String lastName;

    @Column(name = "SERVICE")
    int service;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }
}
