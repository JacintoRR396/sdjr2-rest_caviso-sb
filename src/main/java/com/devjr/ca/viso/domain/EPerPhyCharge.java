package com.devjr.ca.viso.domain;

import java.util.*;
import javafx.beans.property.*;
import javafx.collections.*;
import javafx.util.StringConverter;

/**
 * Representa el <strong color="#AED6F1">Tipo de Cargo en la Junta</strong> que puede tiene una <strong color="#A2D9CE">Persona Física</strong>.
 * @author Jacinto R^2
 * @version 1.0
 * @since <strong color="#f39c12">02/03/2018</strong>
 * @modify 27/05/2018
 */
public enum EPerPhyCharge implements Comparable<EPerPhyCharge> {
    
    PRESIDENTE("Presidente", 1),
    VICEPRESIDENTE("Vicepresidente", 2),
    SECRETARIO("Secretario", 3),
    TREASURER("Tesorero", 4),
    VOCAL("Vocal", 5),
    EMPTY("", 6);
    
        /* CONSTANT */
    public static final int I_SIZE_WORD = 50;
    
        /* VARIABLES */
    /** <strong color="#D2B4DE">Cadena</strong> que representa el <em color="#AED6F1">Tipo de Cargo</em> de una <strong color="#A2D9CE">Persona Física</strong>. (<strong color="#2ECC71">Obligatorio</strong>) */
    private final StringProperty sName;
    /** <strong color="#D2B4DE">Propiedad Entero (JFX)</strong> que representa el <em color="#AED6F1">Tipo de Cargo</em> de una <strong color="#A2D9CE">Persona Física</strong>. (<strong color="#2ECC71">Obligatorio</strong>) */
    private final IntegerProperty iCode;

        /* CONSTRUCTOR */
    /** <strong color="#D2B4DE">Constructor</strong> que recibe <em color="#AED6F1">2 Parámetros</em>:
     * @param sName <strong color="#D2B4DE">Cadena</strong> para establecer el <em color="#AED6F1">Cargo en la Junta</em> de una <strong color="#A2D9CE">Persona Física</strong>, es asiganada a {@link #sName} .
     * @param iCode <strong color="#D2B4DE">Entero</strong> para establecer el <em color="#AED6F1">Cargo en la Junta</em> de una <strong color="#A2D9CE">Persona Física</strong>, es asiganada a {@link #iCode} . */
    private EPerPhyCharge(String sName, int iCode){
        this.sName = new SimpleStringProperty(this, "spName", sName);
        this.iCode = new SimpleIntegerProperty(this, "ipCode", iCode);
    }
    
        /* GETTERS AND SETTERS */
    public final String getName(){ return this.sName.get(); }
    public void setName(String sName){ this.sName.set(sName); }
    public final StringProperty nameProperty(){ return this.sName; }
    
    public final int getCode(){ return this.iCode.get(); }
    public void setCode(int iCode){ this.iCode.set(iCode); }
    public final IntegerProperty codeProperty(){ return this.iCode; }
    
        /* MEHTHODS OF INSTANCE */
    public int compare(EPerPhyCharge eCharge1, EPerPhyCharge eCharge2){
        return eCharge1.iCode.get() - eCharge2.iCode.get();
    }
    
        /* METHODS OF CLASSES */
    public static Comparator<EPerPhyCharge> CodeComparatorASC = (EPerPhyCharge eCharge1, EPerPhyCharge eCharge2) -> eCharge1.iCode.get() - eCharge2.iCode.get();
    
    public static boolean equalsEnum(EPerPhyCharge oEnumCharge){
        Boolean bRes = false;
        for(EPerPhyCharge eCharge : EPerPhyCharge.values()){
            if(oEnumCharge.equals(eCharge)){
                bRes = true;
                break;
            }
        }
        return bRes;
    }
    
    public static StringConverter<EPerPhyCharge> createEnumStringConverter(){
        return new StringConverter<EPerPhyCharge>() {
            @Override
            public String toString(EPerPhyCharge object) {
                return object.getName();
            }
            @Override
            public EPerPhyCharge fromString(String string) {
                return EPerPhyCharge.valueOf(string.toUpperCase());
            }
        };
    }
    
    public static ObservableList<EPerPhyCharge> getObsListEnum(){
        ArrayList<EPerPhyCharge> oAList = new ArrayList<EPerPhyCharge>();
        oAList.addAll(Arrays.asList(EPerPhyCharge.values()));
        ObservableList<EPerPhyCharge> oObsList = FXCollections.observableArrayList(oAList);
        return oObsList;
    }
    
    public static ObservableList<String> getObsListString(){
        ArrayList<String> oAList = new ArrayList<String>();
        for(EPerPhyCharge eCharge : EPerPhyCharge.values()){
            oAList.add(eCharge.getName());
        }
        ObservableList<String> oObsList = FXCollections.observableArrayList(oAList);
        return oObsList;
    }
        
}