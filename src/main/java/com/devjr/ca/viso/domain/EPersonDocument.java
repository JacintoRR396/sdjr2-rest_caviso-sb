package com.devjr.ca.viso.domain;

import java.util.Arrays;
import java.util.Optional;

/**
 * Representa el Documento de Identidad de un Socio (Persona Física)
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 12/04/2020
 * @modify 12/04/2020
 */
public enum EPersonDocument{

    DNI, NIE, CIF, EMPTY;

    /* METHODS OF CLASSES */
    public static boolean equalsEnum(final EPersonDocument category){

        Optional<EPersonDocument> opt = Arrays.stream(EPersonDocument.values()).filter(epd -> epd.equals(category))
                .findFirst();
        return opt.isPresent();
        //        for(final EPersonDocument ec : EPersonDocument.values()){
        //            if(category.equals(ec))
        //                return true;
        //        }
        //        return false;
    }

}