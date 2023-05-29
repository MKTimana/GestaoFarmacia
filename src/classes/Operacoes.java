package classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
        System.out.println("Cliente adicionado1");
    }

    public void atualizarCliente(Vector v, int nuit) {
        int op, idade;
        String nome, celular;
        char sexo;

        for (int i = 0; i < v.size(); i++) {
            if (((Cliente) v.get(i)).getNuit() == nuit) {
                System.out.println("O que deseja atualizar neste cliente?");
                System.out.println("1 - Nome\n2 - Idade\n3 - Celular\n4 - Sexo");
                op = input.nextInt();

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
                System.out.println("Desculpe, mas nao existe um cliente com o NUIT: "+nuit);
            }
        }
    }

    public void listarCliente(Vector v) {
        for (int i = 0; i < v.size(); i++) {
            System.out.println(i + " - " + (Cliente) v.get(i));
        }
    }

    public void apagarCliente(Vector v, int id) {
        for (int i = 0; i < v.size(); i++) {
            if (((Cliente) v.get(i)).getId() == id) {
                v.removeElementAt(i);
                System.out.println("Cliente removido!");
            }
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
                System.out.println("Desculpe, mas nao existe um produto com o ID: "+p);
            }
        }
    }

    public void listarProduto(Vector v) {
        for(int i = 0; i<v.size(); i++){
            System.out.println(i+" - "+(Produto)v.get(i));
        }
    }

    public void apagarProduto(Vector v, int id) {
        for(int i = 0; i<v.size();i++){
            if(((Produto)v.get(i)).getId() == id){
                v.removeElementAt(i);
                System.out.println("Produto removido!");
            }
        }
    }

    public void novaVenda(Vector v, Cliente c, Produto p) {
        // metodo aqui!
    }

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
    public Object recuperarObj(String path) {
        File arquivo = new File(path);
        try {
            FileInputStream fileIn = new FileInputStream(arquivo);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);

            Object retorno = objIn.readObject();

            objIn.close();
            fileIn.close();

            return retorno;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
