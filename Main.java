import model.ContaBancaria;
import service.BancoService;

public class Main {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("João", "1234");
        BancoService banco = new BancoService(conta);
        banco.iniciar();
    }
}
