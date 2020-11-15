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

public class ContactCSVReader {

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
                Client cli = getClientOfString(nextRow);
                contrStore.addContract(builtContract(nextRow,id,startDate,endDate,numb_contr,cli)); 
            }
        }

    }

    private LocalDate getDateOfString(String str) {
        String[] substr = str.split("//.*");
        return LocalDate.of(Integer.parseInt(substr[2]), Integer.parseInt(substr[1]), Integer.parseInt(substr[0]));
    }

    private Gender getGenderOfString(String str) {
        if (str.equals("Male")) {
            return Gender.Male;
        } else if (str.equals("Female")) {
            return Gender.Female;
        }
        return null;
    }

    private Client getClientOfString(String[] nextRow) {
        int id = Integer.parseInt(nextRow[4]);
        String name = nextRow[5];
        String surname = nextRow[6];
        String patronymic = nextRow[7];
        LocalDate dateofBirth = getDateOfString(nextRow[8]);
        Gender gender = getGenderOfString(nextRow[9]);
        int passportNum = Integer.parseInt(nextRow[10]);
        int passportSerial = Integer.parseInt(nextRow[11]);
        return new Client(id, name, surname, patronymic, dateofBirth, gender, passportNum, passportSerial);
    }

    private Contract builtContract(String[] nextRow, int id, LocalDate startDate, LocalDate endDate, int numberContract, Client client) {
        switch (nextRow[12]) {
            case "Cellular":
                String[] dop_info = nextRow[13].split("//s*");
                int colMinutes = Integer.parseInt(dop_info[0]);
                int colGigabytes = Integer.parseInt(dop_info[1]);
                int colSms = Integer.parseInt(dop_info[2]);
                return new CellularContract(id,startDate,endDate,numberContract,client,colMinutes,colGigabytes,colSms);                
            case "Internet":
                double maxSpeed = Double.parseDouble(nextRow[13]);
                return new InternetContract(id,startDate,endDate,numberContract,client,maxSpeed);
            case "DijitalTV":
                String[] listContr = nextRow[13].split("//,*");
                List<String> channelPackage = new ArrayList();
                channelPackage.addAll(Arrays.asList(listContr));
                return new DijitalTVContract(id,startDate,endDate,numberContract,client,channelPackage);
            default:
                break;
        }
        return null;
    }
}
