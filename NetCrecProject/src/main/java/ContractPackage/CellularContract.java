package ContractPackage;

import java.time.LocalDate;

public class CellularContract extends Contract {

    private int colMinutes;
    private int colGigabytes;
    private int colSms;

    public CellularContract(int id, LocalDate startDate, LocalDate endDate,int numberContract, Client client,int colMinutes,int colGigabytes,int colSms) {
        super(id, startDate, endDate,numberContract, client);
        this.colMinutes = colMinutes;
        this.colGigabytes = colGigabytes;
        this.colSms = colSms;
    }

    /**
     * @return - number of minutes provided
     */
    public int getColMinutes() {
        return colMinutes;
    }

    /**
     * replace number of minutes provided
     * @param colMinutes - new number of minutes provided
     */
    public void setColMinutes(int colMinutes) {
        this.colMinutes = colMinutes;
    }

    /**
     * @return - number of gigabytes of Internet provided
     */
    public int getColGigabytes() {
        return colGigabytes;
    }

    /**
     * replace number of gigabytes of Internet provided
     * @param colGigabytes - new number of gigabytes of Internet provided
     */
    public void setColGigabytes(int colGigabytes) {
        this.colGigabytes = colGigabytes;
    }

    /**
     * @return - number of provided SMS
     */
    public int getColSms() {
        return colSms;
    }

    /**
     * replace number of provided SMS
     * @param colSms - new number of provided SMS
     */
    public void setColSms(int colSms) {
        this.colSms = colSms;
    }
}
