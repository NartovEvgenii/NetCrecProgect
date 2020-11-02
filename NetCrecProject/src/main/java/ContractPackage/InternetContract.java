package ContractPackage;

import java.time.LocalDate;


public class InternetContract extends Contract{
    
    private double maxSpeed;

    public InternetContract(int id, LocalDate startDate, LocalDate endDate,int numberContract, Client client,double maxSpeed){
        super(id, startDate, endDate,numberContract, client);
        this.maxSpeed = maxSpeed;
    }    

    /**
     * @return - maximum internet speed
     */
    public double getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * replace maximum internet speed
     * @param maxSpeed - new maximum internet speed
     */
    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
