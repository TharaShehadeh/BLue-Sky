/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blue.sky;

/**
 *
 * @author Mass
 */
class Book {
public String depart,arrive,departDate,arriveDate;   
   
    Book(){
    
    
    }

    Book(String depart, String arrive, String departDate, String arriveDate) {
           this.depart = depart;  
           this.arrive= arrive ;
           this.departDate= departDate ; 
           this.arriveDate=arriveDate;
          
            
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

    public String getArriveDate() {
        return arriveDate;
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

    public void setArriveDate(String arriveDate) {
        this.arriveDate = arriveDate;
    }

 
}