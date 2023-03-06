public class Main {
    public static void main(String[] args) {
        validateCredentials("skypro", "123123", "123123");
        validateCredentials("skypro!", "123123","123123");
        validateCredentials("skypro", "123123","1231234");
        validateCredentials("skyproskyproskyproskyproskypro", "123123","123123");

    }

    public static boolean validateCredentials(String login, String password, String repeatPassword) {
        try {
            checkLogin(login);
            checkPassword(password, repeatPassword);
             return true;
        } catch (WrongLoginExeption e) {
            System.out.println("Invalid Login: " + e.getMessage());
            return false;
        } catch (WrongPasswordExeption e) {
            System.out.println("Invalid Password: " + e.getMessage());
            return false;
        }


    }

    private static void checkLogin(String login) {
        if (hasLengthMoreThat(login, 20) || isNoneAlphanumeric(login)) {
            throw new WrongLoginExeption("login is wrong");
        }
    }

    private static void checkPassword(String password, String repeatPassword) {
        if (hasLengthMoreThat(password, 20) || isNoneAlphanumeric(password) || stringsNotEquals(password, repeatPassword)) {
            throw new WrongPasswordExeption("Password is wrong");
        }
    }

    private static boolean stringsNotEquals(String value, String value2) {
        return !value.equals(value2);
    }
    private static boolean isNoneAlphanumeric(String string) {
        final String alphabet = "abcdefghijklmnopqrstuvwxyz123456789_";
        for (int i = 0; i < string.length(); i++) {
            if (!alphabet.contains(String.valueOf(string.charAt(i)))) {
                return true;
            }
        }
        return false;
    }


    private static boolean hasLengthMoreThat (String string, int length){
        return string.length() > length;
    }
}