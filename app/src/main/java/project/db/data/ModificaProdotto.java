package project.db.data;

public class ModificaProdotto {
    private String codiceProdotto;
    private String codiceRiga;
    private String nomeIngrediente;
    private String codiceIngrediente;
    private String tipoModifica;

    public ModificaProdotto(String codiceProdotto, String codiceRiga, String nomeIngrediente, String codiceIngrediente, String tipoModifica) {
        this.codiceProdotto = codiceProdotto;
        this.codiceRiga = codiceRiga;
        this.nomeIngrediente = nomeIngrediente;
        this.codiceIngrediente = codiceIngrediente;
        this.tipoModifica = tipoModifica;
    }

    public static class DAO {

    }
}
