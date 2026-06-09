/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author u11174571179
 */
public class Conversor {
    public static Date TextoDate(String textoData){
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);//impede datas invalidas
        try{
          java.util.Date minhaData = sdf.parse(textoData);
          return new Date(minhaData.getTime());
        }catch (ParseException ex){
        return null;
    }
    }
}
