package skelet.Baze;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Data {
    public static int dataCount = 6;

    private String firstName;
    private String lastName;
    private String patronymicName;
    private LocalDate birthDate;
    private Long phoneNumber;
    private Gender gender;

    public Data() {
    }

    public void CheckData (String[] splitedString) throws ExceptionParsData {
        if (splitedString == null) {
            throw new NullPointerException("Вы не ввели данные");
        }

        StringBuilder fullErrorsMessages = new StringBuilder();
        for (String string : splitedString) {
            if (Character.isLetter(string.charAt(0))) {
                if (string.length() == 1) {
                    if (this.gender == null) {
                        try {
                            this.gender = checkGender(string);
                        } catch (ExceptionGender e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else {
                        fullErrorsMessages.append("Пол повторили\n");
                    }
                } else {
                    if (this.lastName == null) {
                        try {
                            this.lastName = checkFIO(string);
                        } catch (ExceptionName e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else if (this.firstName == null) {
                        try {
                            this.firstName = checkFIO(string);
                        } catch (ExceptionName e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else if (this.patronymicName == null) {
                        try {
                            this.patronymicName = checkFIO(string);
                        } catch (ExceptionName e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else {
                        fullErrorsMessages.append("Повтор ввода ФИО\n");
                    }
                }
            } else {

                if (string.matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}")) {
                    if (this.birthDate == null) {
                        try {
                            this.birthDate = checkBirthDate(string);
                        } catch (ExceptionBirth e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else {
                        fullErrorsMessages.append("Повтор ввода даты рождения '"
                                + this.birthDate + "','" + string + "'\n");
                    }
                } else {
                    if (this.phoneNumber == null) {
                        try {
                            this.phoneNumber = checkPhoneNumber(string);
                        } catch (ExceptionNumberPhone e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else {
                        fullErrorsMessages.append("Вы ввели несколько номеров телефона: '"
                                + this.phoneNumber + "','" + string + "'\n");
                    }
                }

            }
        }
        if (!fullErrorsMessages.isEmpty()) {
            throw new ExceptionParsData (fullErrorsMessages.toString());
        }
    }

    public String getLastName() {
        return lastName;
    }

    private String checkFIO(String inputString) throws ExceptionName {
        if (inputString.toLowerCase().matches("^[a-zа-яё]*$")) {
            return inputString;
        } else {
            throw new ExceptionName (inputString);
        }
    }

    private long checkPhoneNumber(String inputString) throws ExceptionNumberPhone {
        if (inputString.length() == 10) {
            try {
                return Long.parseLong(inputString);
            } catch (NumberFormatException e) {
                throw new ExceptionNumberPhone(inputString);
            }
        } else {
            throw new ExceptionNumberPhone(inputString);
        }
    }

    private Gender checkGender(String inputString) throws ExceptionGender {
        try {
            return Gender.valueOf(inputString);
        } catch (IllegalArgumentException e) {
            throw new ExceptionGender(inputString);
        }
    }

    private LocalDate checkBirthDate(String inputString) throws ExceptionBirth {
        try {
            return LocalDate.parse(inputString,
                    DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            throw new ExceptionBirth(inputString);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(lastName).append(">")
                .append("<").append(firstName).append(">")
                .append("<").append(patronymicName).append(">")
                .append("<").append(birthDate.toString()).append(">")
                .append("<").append(phoneNumber).append(">")
                .append("<").append(gender).append(">");
        return sb.toString();
    }

}

