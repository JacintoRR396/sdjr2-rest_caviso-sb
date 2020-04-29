package com.devjr.ca.viso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representa al DAO respecto a los Medios de Contacto de una Persona
 * Física/Jurídica o Carrera.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 18/04/2020
 * @modify 18/04/2020
 */
@Entity
@Table(name = "contact", schema = "db_ca_viso")
public class ContactEntity{

    /* VARIABLES */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact", unique = true, updatable = false, nullable = false)
    private Integer id;

    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;

    @Column(name = "phone_mobile", unique = true, nullable = true, length = 15)
    private String phoneMobile;

    @Column(name = "phone_home", nullable = true, length = 12)
    private String phoneHome;

    /* CONSTRUCTORS */
    public ContactEntity(){
        super();
    }

    public ContactEntity(final Integer id, final String email, final String phoneMobile, final String phoneHome){
        super();
        this.id = id;
        this.email = email;
        this.phoneMobile = phoneMobile;
        this.phoneHome = phoneHome;
    }

    /* GETTERS AND SETTERS */
    public Integer getId(){
        return this.id;
    }

    public void setId(final Integer id){
        this.id = id;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(final String email){
        this.email = email;
    }

    public String getPhoneMobile(){
        return this.phoneMobile;
    }

    public void setPhoneMobile(final String phoneMobile){
        this.phoneMobile = phoneMobile;
    }

    public String getPhoneHome(){
        return this.phoneHome;
    }

    public void setPhoneHome(final String phoneHome){
        this.phoneHome = phoneHome;
    }

}
