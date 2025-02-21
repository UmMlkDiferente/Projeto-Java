import java.util.ArrayList;
import java.util.List;

class Banco {
    private List<Cliente> clientes = new ArrayList<>();
    public Cliente criarCliente(String nome){
        Cliente cliente = new Cliente (nome);
        clientes.add(cliente);
        return cliente;
    }

    public Cliente buscarCliente(String nome){
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)){
                return cliente;
            }
        }
        return null;

    }

}
