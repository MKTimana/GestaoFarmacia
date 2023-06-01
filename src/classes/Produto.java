package classes;
import java.io.Serializable;
import java.util.Calendar;

public class Produto implements Serializable{
    private int id;
    private String nome;
    private String categoria;
    private String entStock;
    private int quantidade;
    private double preco;

    public Produto(int id, String nome, String categoria, String entStock, int quantidade, double preco) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.entStock = entStock;
        this.quantidade = quantidade;
        this.preco = preco;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEntStock() {
        return entStock;
    }

    public void setEntStock(String entStock) {
        this.entStock = entStock;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        // return "Produto [id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", entStock=" +entStock.get(Calendar.DAY_OF_MONTH)+"/"+entStock.get(Calendar.MONTH)+"/"+entStock.get(Calendar.YEAR)+ ", quantidade=" + quantidade + ", preco=" + preco + "]";
        return "Produto [id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", entStock=" +entStock+", quantidade=" + quantidade + ", preco=" + preco + "]";
    }

}