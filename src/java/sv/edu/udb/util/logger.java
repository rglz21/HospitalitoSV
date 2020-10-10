/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

/**
 *
 * @author rgonz
 */
public class logger {

    FileWriter archivo;
   
//nuestro archivo log

    public void InfoLog(String Operacion,String info) throws IOException {

 //C:\Users\boris\OneDrive\Documentos\HospitalitoSV       
//Pregunta el archivo existe, caso contrario crea uno con el nombre log.txt
        if (new File("C://Users//jonat//OneDrive//Documentos//HospitalSVV//log" + "//" + "log.txt").exists() == false) {
            archivo = new FileWriter(new File("C://Users//jonat//OneDrive//Documentos//HospitalSVV//log" + "//" + "log.txt"), false);
        }
        archivo = new FileWriter(new File("C://Users//jonat//OneDrive//Documentos//HospitalSVV//log" + "//" + "log.txt"), true);
        Calendar fechaActual = Calendar.getInstance(); //Para poder utilizar el paquete calendar
//Empieza a escribir en el archivo C:\Users\rgonz\Documents\HospitalitoSV\log
        archivo.write("[" + (String.valueOf(fechaActual.get(Calendar.DAY_OF_MONTH))
                + "/" + String.valueOf(fechaActual.get(Calendar.MONTH) + 1)
                + "/" + String.valueOf(fechaActual.get(Calendar.YEAR))
                + " " + String.valueOf(fechaActual.get(Calendar.HOUR_OF_DAY))
                + ":" + String.valueOf(fechaActual.get(Calendar.MINUTE))
                + ":" + String.valueOf(fechaActual.get(Calendar.SECOND))) + "]" + "["+info+"]" + " " + Operacion + "\r\n");
        archivo.close(); //Se cierra el archivo
    }//Fin del metodo crearLog

    //Como ejemplo ponemos el caso que se este agregando nombres de personas a un vector
    //y queremos guardar en el Log cada vez que ocurre el evento, seria así:
    public void agregarLog(String mensaje,String tipo) throws IOException {
        //Codigo .....
       this.InfoLog(mensaje,tipo); //Guarda en el Log el evento realizado
    }
    
  
     

   
}
