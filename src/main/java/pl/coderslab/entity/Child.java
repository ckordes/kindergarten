package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.validation.ChildValidation;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
public class Child {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    @NotNull(groups = ChildValidation.class)
    private Person person;
    @NotNull(groups = ChildValidation.class)
    @ManyToMany(mappedBy = "childList")//, cascade = CascadeType.ALL)//,fetch = FetchType.EAGER
    private List<Parent> parentList;
    @NotEmpty(groups = ChildValidation.class)
    @ManyToMany(mappedBy = "childList")//, cascade = CascadeType.ALL)//,fetch = FetchType.EAGER
    private List<Group> groupList;
    @OneToMany(mappedBy = "child")//, cascade = CascadeType.ALL)//,fetch = FetchType.EAGER)
    private List<Payment> paymentList;
    @OneToMany(mappedBy = "child")//,fetch = FetchType.EAGER)
    private List<ChildRelatedMessages> childRelatedMessagesList;
    @ManyToMany(mappedBy = "childList")//,fetch = FetchType.EAGER)
    private List<Allergie> allergieList;
    @OneToMany(mappedBy = "child")//,fetch = FetchType.EAGER)
    private List<InfoForTeacher> infoForTeachers;
    //    @NotBlank(groups = ChildValidation.class)
    @Digits(integer = 6, fraction = 0)
    private double startHour;
    //    @NotBlank(groups = ChildValidation.class)
    @Digits(integer = 6, fraction = 0)
    private double endHour;

    public Child() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Parent> getParentList() {
        return parentList;
    }

    public void setParentList(List<Parent> parentList) {
        this.parentList = parentList;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public List<ChildRelatedMessages> getChildRelatedMessagesList() {
        return childRelatedMessagesList;
    }

    public void setChildRelatedMessagesList(List<ChildRelatedMessages> childRelatedMessagesList) {
        this.childRelatedMessagesList = childRelatedMessagesList;
    }

    public List<Allergie> getAllergieList() {
        return allergieList;
    }

    public void setAllergieList(List<Allergie> allergieList) {
        this.allergieList = allergieList;
    }

    public List<InfoForTeacher> getInfoForTeachers() {
        return infoForTeachers;
    }

    public void setInfoForTeachers(List<InfoForTeacher> infoForTeachers) {
        this.infoForTeachers = infoForTeachers;
    }

    public double getStartHour() {
        return startHour;
    }

    public void setStartHour(double startHour) {
        this.startHour = startHour;
    }

    public double getEndHour() {
        return endHour;
    }

    public void setEndHour(double endHour) {
        this.endHour = endHour;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return person.getFirstName() + " " + person.getLastName();
    }

    public Child(Person person, List<Parent> parentList, List<Group> groupList, List<Payment> paymentList,
                 List<ChildRelatedMessages> childRelatedMessagesList, List<Allergie> allergieList,
                 List<InfoForTeacher> infoForTeachers, double startHour, double endHour) {
        this.person = person;
        this.parentList = parentList;
        this.groupList = groupList;
        this.paymentList = paymentList;
        this.childRelatedMessagesList = childRelatedMessagesList;
        this.allergieList = allergieList;
        this.infoForTeachers = infoForTeachers;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return id == child.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Child(Child that) {
        this(that.getPerson(), that.getParentList(), that.getGroupList(), that.getPaymentList(), that.getChildRelatedMessagesList(),
                that.getAllergieList(), that.getInfoForTeachers(), that.getStartHour(), that.getEndHour());
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", person=" + person.toString() +
                ", parentList=" + parentList.stream().map(Parent::toString).reduce("", (a, b) -> a + b) +
                ", groupList=" + groupList.stream().map(Group::toString).reduce("", (a, b) -> a + b) +
                ", infoForTeachers=" + infoForTeachers +
                ", startHour=" + startHour +
                ", endHour=" + endHour +
                '}';
    }
}