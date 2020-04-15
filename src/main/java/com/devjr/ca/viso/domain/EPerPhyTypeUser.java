package com.devjr.ca.viso.domain;

import java.util.*;
import javafx.beans.property.*;
import javafx.collections.*;
import javafx.util.StringConverter;

/**
 * Representa el <strong color="#AED6F1">Tipo de Usuario a nivel de la Aplicación</strong> que puede ser una <strong color="#A2D9CE">Persona Física</strong>.
 * @author Jacinto R^2
 * @version 1.0
 * @since <strong color="#f39c12">15/02/2018</strong>
 * @modify 27/05/2018
 */
public enum EPerPhyTypeUser implements Comparable<EPerPhyTypeUser> {
    
    USUARIO("Usuario", 1),
    SOCIO("Socio", 2),
    ADMIN("Admin", 3);
    
        /* CONSTANT */
    public static final int I_SIZE_WORD = 50;
    
        /* VARIABLES */
    /** <strong color="#D2B4DE">Cadena</strong> que representa el <em color="#AED6F1">Tipo de Usuario</em> de una <strong color="#A2D9CE">Persona Física</strong>. (<strong color="#2ECC71">Obligatorio</strong>) */
    private final StringProperty spName;
    /** <strong color="#D2B4DE">Entero</strong> que representa el <em color="#AED6F1">Tipo de Usuario</em> de una <strong color="#A2D9CE">Persona Física</strong>. (<strong color="#2ECC71">Obligatorio</strong>) */
    private final IntegerProperty ipCode;

        /* CONSTRUCTOR */
    /** <strong color="#D2B4DE">Constructor</strong> que recibe <em color="#AED6F1">2 Parámetros</em>:
     * @param sName <strong color="#D2B4DE">Cadena</strong> para establecer el <em color="#AED6F1">Tipo de Usuario</em> de una <strong color="#A2D9CE">Persona Física</strong>, es asiganada a {@link #spName} .
     * @param iCode <strong color="#D2B4DE">Entero</strong> para establecer el <em color="#AED6F1">Tipo de Usuario</em> de una <strong color="#A2D9CE">Persona Física</strong>, es asiganada a {@link #ipCode} . */
    private EPerPhyTypeUser(String sName, int iCode){
        this.spName = new SimpleStringProperty(this, "spName", sName);
        this.ipCode = new SimpleIntegerProperty(this, "ipCode", iCode);
    }
    
        /* GETTERS AND SETTERS */
    public final String getName(){ return this.spName.get(); }
    public void setName(String sName){ this.spName.set(sName); }
    public final StringProperty nameProperty(){ return this.spName; }

    public final int getCode(){ return this.ipCode.get(); }
    public void setCode(int iCode){ this.ipCode.set(iCode); }
    public final IntegerProperty codeProperty(){ return this.ipCode; }
    
        /* MEHTHODS OF INSTANCE */
    public int compare(EPerPhyTypeUser eTypeUser1, EPerPhyTypeUser eTypeUser2){
        return eTypeUser1.ipCode.get() - eTypeUser2.ipCode.get();
    }
    
        /* METHODS OF CLASSES */
    public static Comparator<EPerPhyTypeUser> CodeComparatorASC = (EPerPhyTypeUser eTypeUser1, EPerPhyTypeUser eTypeUser2) -> eTypeUser1.ipCode.get() - eTypeUser2.ipCode.get();
    
    public static boolean equalsEnum(EPerPhyTypeUser oEnumTypeUser){
        Boolean bRes = false;
        for(EPerPhyTypeUser eTypeUser : EPerPhyTypeUser.values()){
            if(oEnumTypeUser.equals(eTypeUser)){
                bRes = true;
                break;
            }
        }
        return bRes;
    }
    
    public static StringConverter<EPerPhyTypeUser> createEnumStringConverter(){
        return new StringConverter<EPerPhyTypeUser>() {
            @Override
            public String toString(EPerPhyTypeUser object) {
                return object.getName();
            }
            @Override
            public EPerPhyTypeUser fromString(String string) {
                return EPerPhyTypeUser.valueOf(string.toUpperCase());
            }
        };
    }
    
    public static ObservableList<EPerPhyTypeUser> getObsListEnum(){
        ArrayList<EPerPhyTypeUser> oAList = new ArrayList<EPerPhyTypeUser>();
        oAList.addAll(Arrays.asList(EPerPhyTypeUser.values()));
        ObservableList<EPerPhyTypeUser> oObsList = FXCollections.observableArrayList(oAList);
        return oObsList;
    }
    
    public static ObservableList<String> getObsListString(){
        ArrayList<String> oAList = new ArrayList<String>();
        for(EPerPhyTypeUser eTypeUser : EPerPhyTypeUser.values()){
            oAList.add(eTypeUser.getName());
        }
        ObservableList<String> oObsList = FXCollections.observableArrayList(oAList);
        return oObsList;
    }
    
}