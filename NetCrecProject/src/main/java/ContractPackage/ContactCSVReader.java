package ContractPackage;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import validators.ContractValidator;
import validators.Message;

public class ContactCSVReader {

    /**
     * Method adds contacts from the csv file to the contracts store
     *
     * @param fileName - path to used file
     * @param contrStore - used contract storage
     * @throws java.io.IOException
     * @throws com.opencsv.exceptions.CsvValidationException
     */
    public void loadDataToStore(String fileName, ContractStore contrStore) throws IOException, CsvValidationException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(fileName));
                CSVReader csvReader = new CSVReader(reader);) {
            String[] nextRow;
            csvReader.readNext();
            while ((nextRow = csvReader.readNext()) != null) {
                int id = Integer.parseInt(nextRow[0]);
                LocalDate startDate = getDateOfString(nextRow[1]);
                LocalDate endDate = getDateOfString(nextRow[2]);
                int numb_contr = Integer.parseInt(nextRow[3]);
                Client cli = getClientOfString(nextRow,contrStore);
                Contract add_contr = builtContract(nextRow, id, startDate, endDate, numb_contr, cli);
                ContractValidator valid = new ContractValidator();
                Message mess = valid.validate(add_contr);
                if(mess.getStatus().equals(Message.CheckStatus.OK)){
                    contrStore.addContract(add_contr);  
                }else{
                    System.out.print(mess.getErrorMessage()); 
                }
            }
        }

    }

    /**
     * Method adds contacts from the csv file to the contracts store
     *
     * @param str - date string
     * @return - date
     */
    private LocalDate getDateOfString(String str) {
        String[] substr = str.split("\\.");
        return LocalDate.of(Integer.parseInt(substr[2]), Integer.parseInt(substr[1]), Integer.parseInt(substr[0]));
    }

    /**
     * Method finds or creates a client to add to the contract from an array of strings
     * from the csv file starting at index 4
     *
     * @param nextRow - comparator sort criterion
     * @return - client of the contract
     */
    private Client getClientOfString(String[] nextRow,ContractStore contrStore) {
        int id = Integer.parseInt(nextRow[4]);
        for (int i = 0; i < contrStore.getColCoctr(); i++) {
            if (contrStore.getContract(i).getClient().getId() == id) {
                return contrStore.getContract(i).getClient();
            }
        }
        String name = nextRow[5];
        String surname = nextRow[6];
        String patronymic = nextRow[7];
        LocalDate dateofBirth = getDateOfString(nextRow[8]);
        Gender gender = Gender.valueOf(nextRow[9]);
        int passportSerial = Integer.parseInt(nextRow[10]);
        int passportNum = Integer.parseInt(nextRow[11]);        
        return new Client(id, name, surname, patronymic, dateofBirth, gender, passportNum, passportSerial);
    }

    /**
     * Method collects the contract from the input data and the rest of the csv file
     *
     * @param nextRow - the rest of the csv file 
     * @param id - ID of the contract
     * @param startDate - start date of the contract
     * @param endDate - end date of the contract
     * @param numberContract - number of the contract
     * @param client - client of the contract
     * @return - contract
     */
    private Contract builtContract(String[] nextRow, int id, LocalDate startDate, LocalDate endDate, int numberContract, Client client) {
        switch (nextRow[12]) {
            case "Cellular":
                String[] dop_info = nextRow[13].split("\\s");
                int colMinutes = Integer.parseInt(dop_info[0]);
                int colGigabytes = Integer.parseInt(dop_info[1]);
                int colSms = Integer.parseInt(dop_info[2]);
                return new CellularContract(id, startDate, endDate, numberContract, client, colMinutes, colGigabytes, colSms);
            case "Internet":
                double maxSpeed = Double.parseDouble(nextRow[13]);
                return new InternetContract(id, startDate, endDate, numberContract, client, maxSpeed);
            case "DijitalTV":
                String[] listContr = nextRow[13].split("\\;");
                List<String> channelPackage = new ArrayList();
                channelPackage.addAll(Arrays.asList(listContr));
                return new DijitalTVContract(id, startDate, endDate, numberContract, client, channelPackage);
            default:
                break;
        }
        return null;
    }
}
