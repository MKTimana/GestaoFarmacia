package interfaces;

import java.util.Vector;

import classes.Cliente;
import classes.Produto;

public interface GestaoOperacoes {
    // Metodos do Cliente
    public void adicionarCliente(Vector v, Cliente c);

    public void atualizarCliente(Vector v, int nuit);

    public void listarCliente(Vector v);

    public void apagarCliente(Vector v, int idC);

    // Metodos do Produto
    public void adicionarProduto(Vector v, Produto p);

    public void atualizarProduto(Vector v, int p);

    public void listarProduto(Vector v);

    public void apagarProduto(Vector v, int idP);

    // Nova venda
    public void novaVenda(Vector v, int idC);

    // Listagem de vendas

    public void todasVendasCliente(int id, Vector v);

    public boolean gravarObj(Object obj, String path);

    public Object recuperarObj(Object obj, String path);

    public boolean atualizarObj(Object obj, String path);

    public boolean apagarObj(Object obj, String path, int id);
}
