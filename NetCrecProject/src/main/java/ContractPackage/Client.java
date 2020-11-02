package ContractPackage;

import java.time.LocalDate;
import java.time.Period;
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
    private int age ;

    public Client(int id, String name, String surname, String patronymic, LocalDate dateofBirth, Gender gender, int passportNum, int passportSerial) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateofBirth = dateofBirth;
        this.gender = gender;
        this.passportNum = passportNum;
        this.passportSerial = passportSerial;
        this.age = Period.between(dateofBirth, LocalDate.now()).getYears();
    }

    /**
     * @return -  client's ID 
     */
    public int getId() {
        return id;
    }

    /**
     * @return -  client's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return -  client's surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @return -  client's patronymic
     */
    public String getPatronymic() {
        return patronymic;
    }
    
    /**
     * @return - client's date of birth
     */
    public LocalDate getDateofBirth() {
        return dateofBirth;
    }

    /**
     * @return - client's gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * replace client's gender
     * @param gender - new client's gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
    /**
     * @return -  client's passport number 
     */
    public int getPassportNum() {
        return passportNum;
    }

    /**
     * replace client's passport number
     * @param passportNum - new client's passport number
     */
    public void setPassportNum(int passportNum) {
        this.passportNum = passportNum;
    }

    /**
     * @return -  client's passport serial 
     */
    public int getPassportSerial() {
        return passportSerial;
    }

    /**
     * replace client's passport series
     * @param passportSerial - nw client's passport serial
     */
    public void setPassportSerial(int passportSerial) {
        this.passportSerial = passportSerial;
    }

    /**
     * replace client's ID
     * @param id - new client's ID 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * replace client's name
     * @param name - new client's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * replace client's surname
     * @param surname - new client's surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * replace client's patronymic
     * @param patronymic - new client's patronymic
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * replace client's date of birth
     * @param dateofBirth - new client's date of birth
     */
    public void setDateofBirth(LocalDate dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    /**
     * @return - client's age
     */
    public int getAge() {
        return Period.between(dateofBirth, LocalDate.now()).getYears();
    }
}
