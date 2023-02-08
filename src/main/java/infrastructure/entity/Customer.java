package infrastructure.entity;

public class Customer {

   private Long id;// long ma większą pojemność niż int
   private String firstName;
   private String lastName;
   private String numberIdCard;
   private Integer pinNumber;
   private String mail;

    public Customer(Long id, Customer customer) {
        this.id = id;
        this.firstName = customer.getFirstName();
        this.lastName = customer.firstName;
        this.numberIdCard = customer.getNumberIdCard();
        this.pinNumber = customer.getPinNumber();
        this.mail = customer.getMail();
    }

    public Customer(String firstName, String lastName, String numberIdCard, Integer pinNumber, String mail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberIdCard = numberIdCard;
        this.pinNumber = pinNumber;
        this.mail = mail;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumberIdCard() {
        return numberIdCard;
    }

    public Integer getPinNumber() {
        return pinNumber;
    }

    public String getMail() {
        return mail;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", numberIdCard='" + numberIdCard + '\'' +
                ", pinNumber=" + pinNumber +
                ", mail='" + mail + '\'' +
                '}';
    }
}
