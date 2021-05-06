import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static Map<String, Node> nodes = new HashMap<>();
    public static List<String> stat10;
    public static int maxim = 0;

    public static void statistic00(Map<String, Node> list, String name) {
        List<String> aux;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now);
        fileName = fileName + ".txt";
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(fileName);
            for (Map.Entry<String, Node> el : list.entrySet()) {
                aux = el.getValue().getPreconditions();
                if (aux.size() == 0) {
                    fw.write("Node " + el.getValue().getName() + " has no precondition\n");
                    //System.out.println("Node " + el.getName() + " has no precondition");
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void statistic01(Map<String, Node> list, String name) {
        List<String> aux;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now);
        fileName = fileName + ".txt";
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(fileName);
            for (Map.Entry<String, Node> el : list.entrySet()) {
                aux = el.getValue().getTriggers();
                if (aux.size() == 0) {
                    fw.write("Node " + el.getValue().getName() + " has no triggers\n");
                    //System.out.println("Node " + el.getName() + " has no triggers");
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void statistic02(Map <String, Node> list, String name) {
        List<String> aux;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now);
        fileName = fileName + ".txt";
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(fileName);
            for (Map.Entry<String, Node> el : list.entrySet()) {
                aux = el.getValue().getDescriptions();
                if (aux.size() == 0) {
                    fw.write("Node " + el.getValue().getName() + " has no description\n");
                    //System.out.println("Node " + el.getName() + " has no description");
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void statistic03(Map<String, Node> list, String name) {
        List<String> aux;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now);
        fileName = fileName + ".txt";
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(fileName);
            for (Map.Entry<String, Node> el : list.entrySet()) {
                aux = el.getValue().getPostconditions();
                if (aux.size() == 0) {
                    fw.write("Node " + el.getValue().getName() + " has no postconditions\n");
                    //System.out.println("Node " + el.getName() + " has no postconditions");
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void statistic04(Map<String, Node> list, String name) {
        List<String> aux;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now);
        fileName = fileName + ".txt";
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(fileName);
            for (Map.Entry<String, Node> el : list.entrySet()) {
                aux = el.getValue().getReferences();
                if (aux.size() == 0) {
                    fw.write("Node " + el.getValue().getName() + " has no references\n");
                    //System.out.println("Node " + el.getName() + " has no references");
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void statistic10(Map<String, Node> list, String name) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now);
        fileName = fileName + ".txt";
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(fileName);
            for (Map.Entry<String, Node> el : list.entrySet()) {
                List<String> aux = new ArrayList<>();
                iter(aux, el.getKey());
            }
            fw.write("Longest path:\n");
            for (String i : stat10) {
                fw.write(i + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void iter (List<String> list, String nodeName) {
        Node aux = nodes.get(nodeName);
        list.add(nodeName);
        for (String el : aux.getDescriptions()) {
            if(!list.contains(el)) {
                iter(list, el);
                if (list.size() + 1 > maxim) {
                    maxim = list.size() + 1;
                    if(!list.contains(el))
                        list.add(el);
                    stat10 = list;
                }
            }
        }
        for (String el : aux.getPostconditions()) {
            if(!list.contains(el)) {
                iter(list, el);
                if (list.size() + 1 > maxim) {
                    maxim = list.size() + 1;
                    if(!list.contains(el))
                        list.add(el);
                    stat10 = list;
                }
            }
        }
    }

    public static void main (String [] args) {
        try {
            File file = new File("D:\\Scoala\\Y2S2\\TP\\nokiaTP\\huge-test.xml");
            Scanner myReader = new Scanner(file);
            Node node;
            String name = null, link = null;
            List<String> Prec, Postc, Trig, Ref, Desc;
            String [] aux;
            String [] aux2;

            Prec = new ArrayList<>();
            Postc = new ArrayList<>();
            Trig = new ArrayList<>();
            Ref = new ArrayList<>();
            Desc = new ArrayList<>();

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();

                if (line.contains("</node>")) {

                    node = new Node(name, link, Prec, Postc, Trig, Desc, Ref);
                    nodes.put(name, node);

                    Prec = new ArrayList<>();
                    Postc = new ArrayList<>();
                    Trig = new ArrayList<>();
                    Ref = new ArrayList<>();
                    Desc = new ArrayList<>();
                    name = null;
                    link = null;
                }

                if (line.contains("<name>")) {
                    aux = line.split(">");
                    aux2 = aux[1].split("<");
                    name = aux2[0];
                }

                if (line.contains("<link>")) {
                    aux = line.split(">");
                    aux2 = aux[1].split("<");
                    link = aux2[0];
                }

                if (line.contains("<nodeListPrecondition>")) {
                    line = myReader.nextLine();
                    if (!line.contains("<namePrecondition>")) {
                        //Prec.add(preaux);
                    } else {
                        while (!line.contains("</nodeListPrecondition>")) {
                            aux = line.split(">");
                            aux2 = aux[1].split("<");
                            Prec.add(aux2[0]);
                            line = myReader.nextLine();
                        }
                    }
                }

                if (line.contains("<nodeListPostCondition>")) {
                    line = myReader.nextLine();
                    if (!line.contains("<namePostCondition>")) {
                        //Postc.add(postaux);
                    } else {
                        while (!line.contains("</nodeListPostCondition>")) {
                            aux = line.split(">");
                            aux2 = aux[1].split("<");
                            Postc.add(aux2[0]);
                            line = myReader.nextLine();
                        }
                    }
                }

                if (line.contains("<nodeListTrigger>")) {
                    line = myReader.nextLine();
                    if (!line.contains("<nameTrigger>")) {
                        //Trig.add(trigaux);
                    } else {
                        while (!line.contains("</nodeListTrigger>")) {
                            aux = line.split(">");
                            aux2 = aux[1].split("<");
                            Trig.add(aux2[0]);
                            line = myReader.nextLine();
                        }
                    }
                }

                if (line.contains("<nodeListDescription>")) {
                    line = myReader.nextLine();
                    if (!line.contains("<nameDescription>")) {
                        //Desc.add(descaux);
                    } else {
                        while (!line.contains("</nodeListDescription>")) {
                            aux = line.split(">");
                            aux2 = aux[1].split("<");
                            Desc.add(aux2[0]);
                            line = myReader.nextLine();
                        }
                    }
                }

                if (line.contains("<nodeListReferences>")) {
                    line = myReader.nextLine();
                    if (!line.contains("<nameReferences>")) {
                        //Ref.add(refaux);
                    } else {
                        while (!line.contains("</nodeListReferences>")) {
                            aux = line.split(">");
                            aux2 = aux[1].split("<");
                            Ref.add(aux2[0]);
                            line = myReader.nextLine();
                        }
                    }
                }
            }
            myReader.close();

            /*for (Node el : nodes) {
                System.out.println(el);
            }*/
            statistic10(nodes, "default");

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
