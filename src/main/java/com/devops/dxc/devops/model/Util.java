package com.devops.dxc.devops.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.devops.dxc.devops.dto.GeneralUfDto;

import org.springframework.web.client.RestTemplate;

public class Util {

 

    /**
     * Método para cacular el 10% del ahorro en la AFP.  Las reglas de negocio se pueden conocer en 
     * https://www.previsionsocial.gob.cl/sps/preguntas-frecuentes-nuevo-retiro-seguro-10/
     * 
     * @param ahorro
     * @param sueldo
     * @return
     */
    public static int getDxc(int ahorro, int sueldo){
        double uf = getUf();

        if(((ahorro*0.1)/uf) > 150 ){
            return (int) (150*getUf()) ;
        } else if((ahorro*0.1)<=1000000 && ahorro >=1000000){
            return (int) 1000000;
        } else if( ahorro <=1000000){
            return (int) ahorro;
        } else {
            return (int) (ahorro*0.1);
        }
    }
    
    
    /**
     * Método que retorna el valor de la UF.  Este método debe ser refactorizado por una integración a un servicio
     * que retorne la UF en tiempo real.  Por ejemplo mindicador.cl
     * @return
     */
    public static  double getUf(){

            SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy");
            Date date = new Date(System.currentTimeMillis());
            System.out.println(formatter.format(date));


           String  url = "https://mindicador.cl/api/uf/"+formatter.format(date);
            System.out.println("url : " + url);
            System.out.println("inicio Servicio");
            RestTemplate restTemplate = SingleObjectFactory.getRestTemplateInstance();
            GeneralUfDto generalUfDto = restTemplate.getForObject(url, GeneralUfDto.class);
           
            System.out.println(generalUfDto.toString());
            System.out.println("fin servicio");

       
      
        return  Double.parseDouble(generalUfDto.getSerie().get(0).getValor());
    }


    public static int saldoAhorro(int ahorro) {
		double noventaxciento = ahorro * 0.9;
		System.out.println("SaldoAhorro: "+(int) noventaxciento); 
		return (int) noventaxciento;
	}
    
    public static int impuesto(int dxc) {
		double impuesto = dxc * 0.1;
		System.out.println("impuesto1: "+(int) impuesto); 
		return (int) impuesto;
	}

}
