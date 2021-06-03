/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Nal
 */
public class Users {
    private String Id;
    private String Name;
    private String Email;
    private String Address;
    private String Phone;
    private int NumberWater;
    private float TotalMoney;

    public Users() {
    }

    public Users(String Id, String Name, String Email, String Address, String Phone, int NumberWater, float TotalMoney) {
        this.Id = Id;
        this.Name = Name;
        this.Email = Email;
        this.Address = Address;
        this.Phone = Phone;
        this.NumberWater = NumberWater;
        this.TotalMoney = TotalMoney;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public int getNumberWater() {
        return NumberWater;
    }

    public void setNumberWater(int NumberWater) {
        this.NumberWater = NumberWater;
    }

    public float getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(float TotalMoney) {
        this.TotalMoney = TotalMoney;
    }
    
    
    @Override
    public String toString() {
        return "Users{" + "Id=" + Id + ", Name=" + Name + ", Email=" + Email + ", Address=" + Address + ", Phone=" + Phone + ", NumberWater=" + NumberWater + ", TotalMoney=" + TotalMoney + '}';
    }

    private Session getSendEmail() throws NamingException {
        Context c = new InitialContext();
        return (Session) c.lookup("java:comp/env/sendEmail");
    }

    private void sendMail(String email, String subject, String body) throws NamingException, MessagingException {
        Session sendEmail = getSendEmail();
        MimeMessage message = new MimeMessage(sendEmail);
        message.setSubject(subject);
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email, false));
        message.setText(body);
        Transport.send(message);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Users other = (Users) obj;
        if (this.NumberWater != other.NumberWater) {
            return false;
        }
        if (Float.floatToIntBits(this.TotalMoney) != Float.floatToIntBits(other.TotalMoney)) {
            return false;
        }
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        if (!Objects.equals(this.Address, other.Address)) {
            return false;
        }
        if (!Objects.equals(this.Phone, other.Phone)) {
            return false;
        }
        return true;
    }
    
    
}