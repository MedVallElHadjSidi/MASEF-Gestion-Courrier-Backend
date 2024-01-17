package si.masef.gestioncourier.entity;

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"numberInscription", "destination"})})
public class Courrier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    @Column(nullable = false)
    private int numberInscription;
    private String nni;
    private String tel;
    @Column(nullable = true, updatable = false)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @CreationTimestamp
    private Date date;
    @Column(nullable = true)
    private String destination;
    private String nature;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date dateDepart;
    private boolean status = false;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberInscription() {
        return numberInscription;
    }

    public void setNumberInscription(int numberInscription) {
        this.numberInscription = numberInscription;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }





    public String getNni() {
        return nni;
    }

    public void setNni(String nni) {
        this.nni = nni;
    }


    public Courrier(Long id, String name, int numberInscription, String nni, String tel, Date date, String destination,
            String nature, Date dateDepart, boolean status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.numberInscription = numberInscription;
        this.nni = nni;
        this.tel = tel;
        this.date = date;
        this.destination = destination;
        this.nature = nature;
        this.dateDepart = dateDepart;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Courrier(String name, int numberInscription, String nni, String tel, Date date, String destination,
            String nature, Date dateDepart, boolean status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.numberInscription = numberInscription;
        this.nni = nni;
        this.tel = tel;
        this.date = date;
        this.destination = destination;
        this.nature = nature;
        this.dateDepart = dateDepart;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Courrier() {
    }

}
