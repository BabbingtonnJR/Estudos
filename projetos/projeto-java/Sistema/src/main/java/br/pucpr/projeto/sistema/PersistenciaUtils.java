package br.pucpr.projeto.sistema;

import java.io.*;
import java.util.ArrayList;

public class PersistenciaUtils {

    //clientes
    public static void salvarClientesDat() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
            out.writeObject(RepositorioUsuarios.clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void carregarClientesDat() {
        File arquivo = new File("clientes.dat");
        if (arquivo.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
                RepositorioUsuarios.clientes = (ArrayList<Cliente>) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    //lojas
    public static void salvarLojasDat() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("lojas.dat"))) {
            out.writeObject(RepositorioUsuarios.lojas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void carregarLojasDat() {
        File arquivo = new File("lojas.dat");
        if (arquivo.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
                RepositorioUsuarios.lojas = (ArrayList<Loja>) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void salvarPromocoesDat() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("promocoes.dat"))) {
            out.writeObject(RepositorioUsuarios.promocoes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void carregarPromocoesDat() {
        File arquivo = new File("promocoes.dat");
        if (arquivo.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
                RepositorioUsuarios.promocoes = (ArrayList<Promocao>) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    // denuncias
    public static void salvarDenunciasDat() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("denuncias.dat"))) {
            out.writeObject(RepositorioUsuarios.denuncias);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void carregarDenunciasDat() {
        File arquivo = new File("denuncias.dat");
        if (arquivo.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
                RepositorioUsuarios.denuncias = (ArrayList<Denuncia>) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
