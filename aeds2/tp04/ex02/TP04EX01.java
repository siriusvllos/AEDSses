
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Pokemon {

    private int id;
    private int generation;
    private String name;
    private String description;
    private ArrayList<String> types;
    private ArrayList<String> abilities;
    private double weight;
    private double height;
    private int captureRate;
    private boolean isLegendary;
    private LocalDate captureDate;

    public Pokemon() {
    }

    public Pokemon(int id, int generation, String name,
            String description, ArrayList<String> types, ArrayList<String> abilities, double weight,
            double height, int captureRate, boolean isLegendary, LocalDate captureDate) {
        setId(id);
        setGeneration(generation);
        setName(name);
        setDescription(description);
        setTypes(types);
        setAbilities(abilities);
        setWeight(weight);
        setHeight(height);
        setCaptureRate(captureRate);
        setIsLegendary(isLegendary);
        setCaptureDate(captureDate);
    }

    public Pokemon(String csvLine) {
        String[] values = csvLine.split(",");

        setId(Integer.parseInt(values[0]));
        setGeneration(Integer.parseInt(values[1]));
        setName(values[2]);
        setDescription(values[3]);
        ArrayList<String> types = new ArrayList<String>(Arrays.asList(values[4].split(",")));
        setTypes(types);
        ArrayList<String> abilities = new ArrayList<String>(Arrays.asList(values[5].split(",")));
        setAbilities(abilities);
        setWeight(Double.parseDouble(values[6]));
        setHeight(Double.parseDouble(values[7]));
        setCaptureRate(Integer.parseInt(values[8]));
        setIsLegendary(Boolean.parseBoolean(values[9]));
        setCaptureDate(LocalDate.parse(values[10]));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public ArrayList<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<String> abilities) {
        this.abilities = abilities;
    }

    public void setAbilities(String abilities) {

        abilities = abilities.replaceAll("[\\[\\]\"']", "").trim();
        this.abilities = new ArrayList<>(Arrays.asList(abilities.split(",\\s*")));
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getCaptureRate() {
        return captureRate;
    }

    public void setCaptureRate(int captureRate) {
        this.captureRate = captureRate;
    }

    public boolean getIsLegendary() {
        return isLegendary;
    }

    public void setIsLegendary(boolean isLegendary) {
        this.isLegendary = isLegendary;
    }

    public LocalDate getCaptureDate() {
        return captureDate;
    }

    public void setCaptureDate(LocalDate captureDate) {
        this.captureDate = captureDate;
    }

    void ler(String csvLine) {
        String[] data = csvLine.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");

        setId(Integer.parseInt(data[0]));
        setGeneration(Integer.parseInt(data[1]));
        setName(data[2]);
        setDescription(data[3]);

        ArrayList<String> typesList = new ArrayList<>();
        typesList.add(data[4]);
        if (!data[5].isEmpty()) {
            typesList.add(data[5]);
        }
        setTypes(typesList);

        String abilitiesStr = data[6].replace("[", "").replace("]", "").replace("'", "").trim();
        setAbilities(abilitiesStr);

        if (!data[7].isEmpty()) {
            setWeight(Double.parseDouble(data[7]));
        } else {
            setWeight(0);
        }

        if (!data[8].isEmpty()) {
            setHeight(Double.parseDouble(data[8]));
        } else {
            setHeight(0);
        }

        if (!data[9].isEmpty()) {
            setCaptureRate(Integer.parseInt(data[9]));
        } else {
            setCaptureRate(0);
        }

        setIsLegendary(data[10].equals("1") || data[10].equalsIgnoreCase("true"));

        LocalDate date = parseDate(data[11]);
        setCaptureDate(date);

    }

    private LocalDate parseDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateStr, formatter);
    }

    String imprimir() {
        StringBuilder sb = new StringBuilder();
        sb.append("[#");
        sb.append(getId()).append(" -> ");
        sb.append(getName()).append(": ");
        sb.append(getDescription()).append(" - ['");

        if (getTypes().size() > 0) {
            sb.append(getTypes().get(0));
        }
        sb.append("'");
        if (getTypes().size() > 1) {
            sb.append(", '");
            sb.append(getTypes().get(1)).append("'");
        }
        sb.append("] - ");

        sb.append("[");
        for (int i = 0; i < getAbilities().size(); i++) {
            sb.append("'");
            sb.append(getAbilities().get(i));
            sb.append("'");
            if (i < getAbilities().size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] - ");

        sb.append(getWeight()).append("kg - ");
        sb.append(getHeight()).append("m - ");
        sb.append(getCaptureRate()).append("% - ");
        sb.append(getIsLegendary() ? "true" : "false").append(" - ");
        sb.append(getGeneration()).append(" gen] - ");
        sb.append(getCaptureDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        return sb.toString();
    }

    public int compareTo(Pokemon p) {
        return this.getName().compareTo(p.getName());
    }
}
// NO / ARVORE NOME

class NodeNome {

    Pokemon pokemon;
    NodeNome esq;
    NodeNome dir;

    public NodeNome() {
        this.pokemon = null;
        this.esq = this.dir = null;
    }

    public NodeNome(Pokemon p) {
        this.pokemon = p;
        this.esq = this.dir = null;
    }
}

class ArvoreBinariaNome {

    NodeNome root;

    public ArvoreBinariaNome() {
        this.root = null;
    }

    public void inserir(Pokemon p) {
        root = inserir(p, root);
    }

    private NodeNome inserir(Pokemon p, NodeNome node) {
        if (node == null) {
            node = new NodeNome(p);
        } else if (p.compareTo(node.pokemon) < 0) {
            node.esq = inserir(p, node.esq);
        } else if (p.compareTo(node.pokemon) > 0) {
            node.dir = inserir(p, node.dir);
        }

        return node;
    }

    public boolean pesquisar(String name) {
        return pesquisar(name, root);
    }

    private boolean pesquisar(String name, NodeNome node) {
        boolean resp = false;

        if (node == null) {
            resp = false;
        } else if (name.compareTo(node.pokemon.getName()) < 0) {
            System.out.print(" esq");
            resp = pesquisar(name, node.esq);
        } else if (name.compareTo(node.pokemon.getName()) > 0) {
            System.out.print(" dir");
            resp = pesquisar(name, node.dir);
        } else {
            resp = true;
        }

        return resp;
    }
}

// NO / ARVORE "NORMAL"
class Node {

    int captureRate;
    ArvoreBinariaNome root;
    Node esq;
    Node dir;

    public Node() {
        this.root = new ArvoreBinariaNome();
        this.esq = this.dir = null;
    }

    public Node(int captureRate) {
        this.captureRate = captureRate;
        this.root = new ArvoreBinariaNome();
        this.esq = this.dir = null;
    }
}

class ArvoreBinaria {

    Node root;

    public ArvoreBinaria() {
        inserir(7);
        inserir(3);
        inserir(11);
        inserir(1);
        inserir(5);
        inserir(9);
        inserir(13);
        inserir(0);
        inserir(2);
        inserir(4);
        inserir(6);
        inserir(8);
        inserir(10);
        inserir(12);
        inserir(14);
    }

    public void inserir(int modCR) {
        root = inserir(modCR, root);
    }

    private Node inserir(int modCR, Node node) {
        if (node == null) {
            node = new Node(modCR);
        } else if (modCR < node.captureRate) {
            node.esq = inserir(modCR, node.esq);
        } else if (modCR > node.captureRate) {
            node.dir = inserir(modCR, node.dir);
        }
        return node;
    }

    public void inserir(Pokemon p) {
        this.root = inserir(p, this.root);
    }

    private Node inserir(Pokemon p, Node node) {
        int value = p.getCaptureRate() % 15;

        if (value < node.captureRate) {
            node.esq = inserir(p, node.esq);
        } else if (value > node.captureRate) {
            node.dir = inserir(p, node.dir);
        } else {
            node.root.inserir(p);
        }

        return node;
    }

    public boolean pesquisar(String name) {
        System.out.print("raiz");
        return pesquisar(name, root);
    }

    private boolean pesquisar(String name, Node node) {
        boolean resp = false;
        // pesquisa no node
        if (node != null) {
            resp = node.root.pesquisar(name);

            // chamada recursiva node a esquerda
            if (!resp) {
                System.out.print(" ESQ");
                resp = pesquisar(name, node.esq);
            }

            // chamada recursiva node a direita
            if (!resp) {
                System.out.print(" DIR");
                resp = pesquisar(name, node.dir);
            }
        }
        return resp;
    }

}

public class TP04EX01 {

    private static List<Pokemon> pokemons = new ArrayList<Pokemon>();

    // public static void readFile(String path) {
    //     try {
    //         Scanner sc = new Scanner(new File(path));
    //         sc.nextLine(); // pular rooter
    //         String cod = sc.nextLine();
    //         while (!cod.equals("FIM")) {
    //             pokemons.add(new Pokemon(sc.nextLine()));
    //             cod = sc.nextLine();
    //         }
    //         sc.close();
    //     } catch (Exception e) {
    //     }
    // }
    // eu suponho q alguma coisa esteja errada entre esses dois aqui
    public static Pokemon findPokemon(String id) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getId() == Integer.parseInt(id)) {
                return pokemon;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = "/tmp/pokemon.csv";

        ArrayList<Pokemon> pokedex = new ArrayList<Pokemon>();
        ArvoreBinaria pokemons = new ArvoreBinaria();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine();

            while (br.ready()) {
                String linha = br.readLine();
                Pokemon p = new Pokemon();
                p.ler(linha);
                pokedex.add(p);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Erro: Arquivo não encontrado em " + path);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String idStr = sc.nextLine();

        while (!idStr.equals("FIM")) {
            int id = Integer.parseInt(idStr);
            Pokemon p = pokedex.get(id - 1);
            if (p != null) {
                pokemons.inserir(p);
            }
            idStr = sc.nextLine();
        }

        String name = sc.nextLine();

        while (!name.equals("FIM")) {
            System.out.println("=> " + name);
            if (pokemons.pesquisar(name)) {
                System.out.println(" SIM");
            } else {
                System.out.println(" NAO");
            }
            name = sc.nextLine();
        }
        sc.close();
    }
}
