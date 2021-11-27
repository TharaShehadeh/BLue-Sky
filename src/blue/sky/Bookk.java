/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blue.sky;

class Bookk {
public String depart,arrive,departDate,arriveDate;   
   
    Bookk(){
    
    
    }

    Bookk(String depart, String arrive, String departDate) {
           this.depart = depart;  
           this.arrive= arrive ;
           this.departDate= departDate ; 
         
          
            
    }

    public String getDepart() {
        return depart;
    }

    public String getArrive() {
        return arrive;
    }

    public String getDepartDate() {
        return departDate;
    }

    

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public void setArrive(String arrive) {
        this.arrive = arrive;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    

 
}