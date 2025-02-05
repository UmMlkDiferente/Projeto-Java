import java.util.HashMap;
import java.util.Map;

class Banco {
    private final Map<String, Cliente> clientes = new HashMap<>();

    public Cliente criarCliente(String nome) {
        Cliente cliente = new Cliente(nome);
        clientes.put(nome, cliente);
        return cliente;
    }
}
