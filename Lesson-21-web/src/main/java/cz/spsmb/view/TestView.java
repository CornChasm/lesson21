package cz.spsmb.view;

import cz.spsmb.model.Person;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import cz.spsmb.dao.PersonRepository;

import java.util.List;

@Named
@RequestScoped
public class TestView {

    @Inject
    PersonRepository personRepository;


    List<Person> personList;
    String name;
    int age;

    @PostConstruct
    public void init() {
        personList = personRepository.listAll();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Transactional
    public void savePerson() {
        Person person = new Person(name, age);
        personRepository.persist(person);
        personList.add(person);
        System.out.println("Saved " + person);
    }
}
