package sk.euba.tajj.cviko.configuration;

public class ServiceException extends Throwable {
    public ServiceException(String missing_argument) {
        System.err.println(missing_argument);
    }
}
