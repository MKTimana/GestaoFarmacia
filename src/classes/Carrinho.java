package classes;

public class Carrinho extends Produto{
    private double total;
    
    public Carrinho(int id, String nome, String categoria, String entStock, int quantidade, double preco, double total) {
        super(id, nome, categoria, entStock, quantidade, preco);
        this.total = total;

    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
