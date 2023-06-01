package classes;

import java.io.Serializable;


public class Venda implements Serializable {
    private int id;
    private String dataVenda;
    private int idCliente;
    private int idProduto;
    private double total;

    public Venda(int id, String dataVenda, int idCliente, int idProduto, double total) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public String toString() {
        return "Venda [id=" + id + ", dataVenda=" + dataVenda + ", idCliente=" + idCliente + ", idProduto=" + idProduto
                + "]";
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
