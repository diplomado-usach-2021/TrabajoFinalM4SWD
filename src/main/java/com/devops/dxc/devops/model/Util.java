package com.devops.dxc.devops.model;

import com.devops.dxc.devops.dto.GeneralUfDto;

import org.springframework.beans.factory.annotation.Autowired;
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
        if(((ahorro*0.1)/getUf()) > 150 ){
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
    public static  int getUf(){

      
        try {
            System.out.println("inicio Servicio");
            RestTemplate restTemplate = SingleObjectFactory.getRestTemplateInstance();
          // GeneralUfDto generalUfDto = restTemplate.getForObject("https://mindicador.cl/api/uf/19-03-2022", GeneralUfDto.class);
           
           
            System.out.println("fin servicio");
        
         //   System.out.println("generalUfDto.getUfDto().getValor(): " +  generalUfDto.getSerie().getValor()); 
       
        } catch (Exception e) {
           System.out.println(e.toString());
        }
   
        return 29000;
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
