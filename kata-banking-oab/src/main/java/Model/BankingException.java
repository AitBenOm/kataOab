package Model;

public class BankingException extends RuntimeException  {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5402653821815582682L;



    /**
     *
     * Constructeur de la classe.
     *
     * @param message
     * @param excception
     */
    public BankingException(String message, Throwable excception) {
        super(excception);
        System.err.println(excception.getMessage());
    }

    /**
     *
     * Constructeur de la classe.
     *
     * @param message
     */
    public BankingException(String message) {
        super(message);
        System.err.println(message);

    }
}
