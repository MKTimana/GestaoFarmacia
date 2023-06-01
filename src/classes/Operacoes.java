package classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.Vector;

import interfaces.GestaoOperacoes;

public class Operacoes implements GestaoOperacoes {
    static Scanner input = new Scanner(System.in);

    // Metodos do Cliente
    public void adicionarCliente(Vector v, Cliente c) {
        v.add(c);
        System.out.println("Cliente adicionado!");
    }

    public void atualizarCliente(Vector v, int id) {
        int op, idade;
        String nome, celular;
        char sexo;

        for (int i = 0; i < v.size(); i++) {
            if (((Cliente) v.get(i)).getId() == id) {
                System.out.println("O que deseja atualizar neste cliente?");
                System.out.println("1 - Nome\n2 - Idade\n3 - Celular\n4 - Sexo");
                op = input.nextInt();
                input.nextLine();

                switch (op) {

                    case 1:
                        System.out.print("Insira o nome atualizado para o cliente: ");
                        nome = input.nextLine();
                        ((Cliente) v.get(i)).setNome(nome);
                        System.out.println("Nome atualizado com sucesso!");
                        break;

                    case 2:
                        System.out.print("Insira a nova idade do cliente: ");
                        idade = input.nextInt();
                        ((Cliente) v.get(i)).setIdade(idade);
                        System.out.println("Idade atualizada!");
                        break;

                    case 3:
                        System.out.print("Insira o novo numero de celular: ");
                        input.nextLine();

                        celular = input.nextLine();
                        ((Cliente) v.get(i)).setCelular(celular);
                        System.out.println("Celular atualizado com sucesso.");
                        break;

                    case 4:
                        System.out.print("Mmmmm... vamos la atualizar o sexo: ");
                        sexo = input.next().charAt(0);
                        ((Cliente) v.get(i)).setSexo(sexo);
                        System.out.println("Sexo atualizado!");
                        break;

                    default:
                        System.out.println("Desculpe, creio ter selecionado uma opcao invalida!");
                        break;
                }

            } else {
                System.out.println("Desculpe, mas nao existe um cliente com o ID: " + id);
            }
        }
    }

    public void listarCliente(Vector v) {
        if (v != null) {
            for (int i = 0; i < v.size(); i++) {
                System.out.println(i + " - " + (Cliente) v.get(i));
            }
        } else {
            System.out.println("Nao existem clientes...");
        }
    }

    public void apagarCliente(Vector v, int id) {
        if (v != null) {
            for (int i = 0; i < v.size(); i++) {
                if (((Cliente) v.get(i)).getId() == id) {
                    v.removeElementAt(i);
                    System.out.println("Cliente removido!");
                }
            }
        } else {
            System.out.println("Nao eistem clientes para serem removidos...");
        }
    }

    // Metodos do Produto
    public void adicionarProduto(Vector v, Produto p) {
        v.add(p);
        System.out.println("Produto adicionado");
    }

    public void atualizarProduto(Vector v, int p) {
        String nome, categoria;
        int quantidade, op;
        double preco;
        for (int i = 0; i < v.size(); i++) {
            if (((Produto) v.get(i)).getId() == p) {
                System.out.println("O que deseja atualizar neste cliente?");
                System.out.println("1 - Nome\n2 - Categoria\n3 - Quantidade\n4 - Preco");
                op = input.nextInt();

                switch (op) {

                    case 1:
                        System.out.print("Insira o nome atualizado para o produto: ");
                        nome = input.nextLine();
                        ((Produto) v.get(i)).setNome(nome);
                        System.out.println("Nome atualizado com sucesso!");
                        break;

                    case 2:
                        System.out.print("Insira a nova categoria do produto: ");
                        categoria = input.nextLine();
                        ((Produto) v.get(i)).setCategoria(categoria);
                        System.out.println("Categoria atualizada!");
                        break;

                    case 3:
                        System.out.print("Insira as quantidades do produto: ");
                        quantidade = input.nextInt();
                        ((Produto) v.get(i)).setQuantidade(quantidade);
                        System.out.println("Quantidade atualizado com sucesso.");
                        break;

                    case 4:
                        System.out.print("Mmmmm... vamos la atualizar o preço: ");
                        preco = input.nextDouble();
                        ((Produto) v.get(i)).setPreco(preco);
                        System.out.println("Preço atualizado!");
                        break;

                    default:
                        System.out.println("Desculpe, creio ter selecionado uma opcao invalida!");
                        break;
                }

            } else {
                System.out.println("Desculpe, mas nao existe um produto com o ID: " + p);
            }
        }
    }

    public void listarProduto(Vector v) {
        for (int i = 0; i < v.size(); i++) {
            System.out.println(i + " - " + (Produto) v.get(i));
        }
    }

    public void apagarProduto(Vector v, int id) {
        for (int i = 0; i < v.size(); i++) {
            if (((Produto) v.get(i)).getId() == id) {
                v.removeElementAt(i);
                System.out.println("Produto removido!");
            }
        }
    }

    public void novaVenda(Vector v, int c){

    }

    /*public void novaVenda(Vector v, int c) {
        String path = "src/data/Product.txt";
        int opcao, p;
        Vector produtos = new Vector();
        Vector carrinho = new Vector();
        // System.out.print("Insira o ID do cliente para iniciar com a compra: ");
        // c = input.nextInt();
        for (int i = 0; i < v.size(); i++) {
            if (((Cliente) v.get(i)).getId() == c) {

                // ((Venda) v.get(i)).setIdCliente(1);
                // ((Venda) v.get(i)).setIdCliente(((Cliente) v.get(i)).getId());

                System.out.println("Cliente encontrado");
                produtos = (Vector) this.recuperarObj(v, path);
                this.listarProduto(produtos);
                System.out.print("Insira o ID do produto para adicionar ao carrinho: ");
                p = input.nextInt();

                do {
                    for (int j = 0; j < produtos.size(); j++) {

                        if (((Produto) produtos.get(j)).getId() == p) {
                            System.out.println("Qual e a quantidade que deseja?: ");
                            int quant = input.nextInt();
                            // v = (Vector) this.recuperarObj(v, path);
                            if (quant > ((Produto) produtos.get(j)).getQuantidade()) {
                                System.out.println("Desculpa, mas essa quantidade nao esta disponivel.");
                            } else {
                                String nomeProduto = ((Produto)produtos.get(j)).getNome();
                                String nomeCliente = ((Cliente)v.get(i)).getNome();

                                String venda = nomeCliente+" "+nomeProduto;
                                carrinho.add(venda);
                                // carrinho.insertElementAt((Produto) v.get(i), i);
                                this.gravarObj(carrinho, "src/data/Vendas.txt");
                            }
                        }
                        
                        for (int k = 0; k < carrinho.size(); k++) {
                            System.out.println(k + " - " + (Venda) carrinho.get(k));
                        }
                    }
                    System.out.print("Deseja comprar mais alguma coisa? 1-SIM | 2- NAO");
                    opcao = input.nextInt();
                } while (opcao != 2);

            }
        }

    }*/

    public void todasVendasCliente(int id, Vector v) {
        // metodo aqui!
    }

    @Override
    public boolean gravarObj(Object obj, String path) {
        File arquivo = new File(path);

        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        try {

            FileOutputStream fileOut = new FileOutputStream(arquivo);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

            objOut.writeObject(obj);

            objOut.flush();
            fileOut.flush();

            objOut.close();
            fileOut.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object recuperarObj(Object obj, String path) {
        // File arquivo = new File(path);
        // try {
        // FileInputStream fileIn = new FileInputStream(arquivo);
        // ObjectInputStream objIn = new ObjectInputStream(fileIn);

        // Object retorno = objIn.readObject();

        // objIn.close();
        // fileIn.close();

        // return retorno;
        // } catch (Exception e) {
        // e.printStackTrace();
        // return null;a
        // }

        File arquivo = new File(path);

        if (!arquivo.exists()) {
            try {
                this.gravarObj(obj, path);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return obj;
        } else {
            try {
                FileInputStream fileInput = new FileInputStream(arquivo);
                ObjectInputStream objInput = new ObjectInputStream(fileInput);

                Object retorno = objInput.readObject();

                objInput.close();
                fileInput.close();

                return retorno;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public boolean atualizarObj(Object obj, String path) {
        File arquivo = new File(path);

        try {

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean apagarObj(Object obj, String path, int id) {
        File arquivo = new File(path);
        Vector clientes = new Vector();
        try {
            FileInputStream fileIn = new FileInputStream(arquivo);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            FileOutputStream fileOut = new FileOutputStream(arquivo);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

            clientes = (Vector) objIn.readObject();
            Object clientePorApagar = null;
            for (Object cliente : clientes) {
                if (((Cliente) cliente).getId() == id) {
                    clientePorApagar = cliente;
                    break;
                }
                if (clientePorApagar != null) {
                    clientes.remove(clientePorApagar);
                    System.out.println("Cliente apagado!");
                } else {
                    System.out.println("Cliente nao encontrado!");
                }
            }

            objOut.writeObject(clientes);
            objOut.flush();
            fileOut.flush();

            objOut.close();
            fileOut.close();

            objIn.close();
            fileIn.close();

            return true;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }

    }
}
