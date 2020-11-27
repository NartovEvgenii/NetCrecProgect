package ContractPackage;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ValidatContract {

    public enum CheckStatus {
        OK,
        Error,
        RedRisk
    }

    private String errorMessage = "";
    private CheckStatus status = CheckStatus.OK;

    /**
     * The method checks the incoming array for contract creation.
     *
     * @param data - data array for validation
     * @return - a class method containing validation status and error message
     * @throws java.lang.ClassNotFoundException
     */
    public ValidatContract contractValidate(String[] data) throws ClassNotFoundException {
        if (data.length >= 12) {
            try {
                Class contr = Class.forName("ContractPackage.Contract");
                String[] nameContractFields = {"id", "startDate", "endDate", "numberContract"};
                for (int i = 0; i < nameContractFields.length; i++) {
                    Field fld = contr.getDeclaredField(nameContractFields[i]);
                    String value = data[i];
                    if (!checkTypeForField(value, fld)) {
                        status = CheckStatus.RedRisk;
                        errorMessage = "element in array with index " + i
                                + " and the value " + data[4 + i] 
                                + " does not match contract field with name " + fld.getName()
                                + " with type " + fld.getType().getTypeName();
                        return this;
                    }
                }
                Class client = Class.forName("ContractPackage.Client");
                String[] nameClientFields = {"id", "name", "surname", "patronymic", "dateofBirth", "gender", "passportNum", "passportSerial"};
                for (int i = 0; i < nameClientFields.length; i++) {
                    Field fld = client.getDeclaredField(nameClientFields[i]);
                    String value = data[4 + i];
                    if (!checkTypeForField(value, fld)) {
                        status = CheckStatus.RedRisk;
                        errorMessage = "element in array with index " + (4 + i)
                                + " and the value " + data[4 + i] 
                                + " does not match client field with name " + fld.getName()
                                + " with type " + fld.getType().getTypeName();
                        return this;
                    }
                }
                if (data.length == 14 && !data[12].isEmpty() && !data[13].isEmpty()) {
                    switch (data[12]) {
                        case "Cellular":
                            String[] dop_info = data[13].split("\\s");
                            Class cellcontr = Class.forName("ContractPackage.CellularContract");
                            String[] nameCellularFields = {"colMinutes", "colGigabytes", "colSms"};
                            checkClassFieldTypes(cellcontr, nameCellularFields, dop_info);
                            return this;
                        case "Internet":
                            String[] maxSpeed = {data[13]};
                            Class intercontr = Class.forName("ContractPackage.InternetContract");
                            String[] nameInternetFields = {"maxSpeed"};
                            checkClassFieldTypes(intercontr, nameInternetFields, maxSpeed);
                            return this;
                        case "DijitalTV":
                            return this;
                        default:
                            status = CheckStatus.Error;
                            errorMessage = "entered the array allows you to create a contract of the base type "
                            + "but does not have enough fields to expand it or cannot find class type named " + data[12];
                            return this;
                    }
                } else {
                    status = CheckStatus.Error;
                    errorMessage = "entered the array allows you to create a contract of the base type "
                            + "but type does not match contract subtype";
                }
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(ValidatContract.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(ValidatContract.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            status = CheckStatus.RedRisk;
            errorMessage = "entered the array does not have enough fields to create a contract";
        }
        return this;
    }

    /**
     * The method checks the subclass fields and additional information fields for data type compliance.
     *
     * @param cls - class type to check
     * @param nameField - an array of class field names to check
     * @param dop_inf - an array of additional information to check
     */
    private void checkClassFieldTypes(Class cls, String[] nameField, String[] dop_inf) {
        try {
            if (nameField.length > dop_inf.length) {
                status = CheckStatus.Error;
                errorMessage = "entered the array allows you to create a contract of the base type "
                        + "but there is not enough additional information to create a contract subtype";
                return;
            }
            for (int i = 0; i < nameField.length; i++) {
                Field fld = cls.getDeclaredField(nameField[i]);
                String value = dop_inf[i];
                if (!checkTypeForField(value, fld)) {
                    status = CheckStatus.Error;
                    errorMessage = "entered the array allows you to create a contract of the base type "
                            + "but additional information field element " + dop_inf[i]
                            + "does not match field name " + fld.getName()
                            + "with type " + fld.getType().getTypeName()
                            + "in the class " + cls.getName();
                    return;
                }
            }
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(ValidatContract.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(ValidatContract.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * The method checks if the field type matches and converts the input string.
     *
     * @param value - string value to check for type
     * @param fld - type check field
     * @return - check value
     */
    public static boolean checkTypeForField(String value, Field fld) {
        switch (fld.getType().getTypeName()) {
            case "int":
                return isInteger(value);
            case "double":
                return isDouble(value);
            case "java.time.LocalDate":
                return isLocalDate(value);
            case "java.lang.String":
                return true;
            case "ContractPackage.Gender":
                return isGender(value);
            default:
                break;
        }
        return false;
    }

    /**
     * The method checks if a string can be converted to an integer.
     *
     * @param number - string to check the format
     * @return - check value
     */
    public static boolean isInteger(String number) {
        try {
            int d = Integer.parseInt(number);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    /**
     * The method checks if a string can be converted to an Double.
     *
     * @param number - string to check the format
     * @return - check value
     */
    public static boolean isDouble(String number) {
        try {
            double d = Double.parseDouble(number);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    /**
     * The method checks the possibility of converting a string to a date using a template:dd.mm.yyyy
     *
     * @param date - string to check the format
     * @return - check value
     */
    public static boolean isLocalDate(String date) {
        return date.matches("^(0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[012])\\.((19|20)\\d\\d)$");
    }

    /**
     * The method checks if the string can be converted to the client's gender type
     *
     * @param gender - string to check the format
     * @return - check value
     */
    public static boolean isGender(String gender) {
        for (Gender gend : Gender.values()) {
            if (gend.name().equals(gender)) {
                return true;
            }
        }
        return false;
    }

    /**
     * The method returns a validation error message
     *
     * @return - a validation error message
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * The method returns the status of the validation check
     *
     * @return - the status of the validation check
     */
    public CheckStatus getStatus() {
        return status;
    }

}
