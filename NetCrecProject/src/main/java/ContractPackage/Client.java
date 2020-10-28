package ContractPackage;

import java.time.LocalDate;
enum Gender{
  Male,
  Female
}
public class Client {

    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate dateofBirth;
    private Gender gender;
    private int passportNum; 
    private int passportSerial;

    public Client(int id, String name, String surname, String patronymic, LocalDate dateofBirth, Gender gender, int passportNum, int passportSerial) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateofBirth = dateofBirth;
        this.gender = gender;
        this.passportNum = passportNum;
        this.passportSerial = passportSerial;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getDateofBirth() {
        return dateofBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(int passportNum) {
        this.passportNum = passportNum;
    }

    public int getPassportSerial() {
        return passportSerial;
    }

    public void setPassportSerial(int passportSerial) {
        this.passportSerial = passportSerial;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setDateofBirth(LocalDate dateofBirth) {
        this.dateofBirth = dateofBirth;
    }
}
