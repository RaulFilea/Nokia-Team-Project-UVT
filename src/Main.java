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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now);
        fileName = "statistic00_" + fileName + ".txt";
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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now);
        fileName = "statistic01_" + fileName + ".txt";
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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now);
        fileName = "statistic02_" + fileName + ".txt";
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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now);
        fileName = "statistic03_" + fileName + ".txt";
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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now);
        fileName = "statistic04_" + fileName + ".txt";
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
    
    public static void statistic05(Map<String, Node> list, String name) {
        List<String> aux, aux2;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now);
        fileName = "statistic05_" + fileName + ".txt";
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(fileName);
            for (Map.Entry<String, Node> el : list.entrySet()) {
                aux = el.getValue().getPreconditions();
                for (String i : aux) {
                    if(nodes.containsKey(i)) {
                        Node temp = nodes.get(i);
                        aux2 = temp.getPostconditions();
                        boolean sw = false;
                        for (String j : aux2) {
                            if (j.equals(el.getValue().getName())) {
                                sw = true;
                                break;
                            }
                        }
                        if (sw == false) {
                            fw.write("Node " + el.getValue().getName() + " doesn't appear in the post-conditions of node " + i + "\n");
                            ///System.out.println("Node " + el.getValue().getName() + " doesn't appear in the postconditions of node " + i);
                        }
                    }
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void statistic06(Map<String, Node> list, String name) {
        List<String> aux, aux2;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now);
        fileName = "statistic06_" + fileName + ".txt";
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(fileName);
            for (Map.Entry<String, Node> el : list.entrySet()) {
                aux = el.getValue().getTriggers();
                for (String i : aux) {
                    if(nodes.containsKey(i)) {
                        Node temp = nodes.get(i);
                        aux2 = temp.getDescriptions();
                        boolean sw = false;
                        for (String j : aux2) {
                            if (j.equals(el.getValue().getName())) {
                                sw = true;
                                break;
                            }
                        }
                        if (sw == false) {
                            fw.write("Node " + el.getValue().getName() + " doesn't appear in the description of node " + i + "\n");
                        }
                    }
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void statistic07(Map<String, Node> list, String name) {
        List<String> aux, aux2;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now);
        fileName = "statistic07_" + fileName + ".txt";
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(fileName);
            for (Map.Entry<String, Node> el : list.entrySet()) {
                aux = el.getValue().getDescriptions();
                for (String i : aux) {
                    if(nodes.containsKey(i)) {
                        Node temp = nodes.get(i);
                        aux2 = temp.getTriggers();
                        boolean sw = false;
                        for (String j : aux2) {
                            if (j.equals(el.getValue().getName())) {
                                sw = true;
                                break;
                            }
                        }
                        if (sw == false) {
                            fw.write("Node " + el.getValue().getName() + " doesn't appear in the triggers of node " + i + "\n");
                        }
                    }
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void statistic08(Map<String, Node> list, String name) {
        List<String> aux, aux2;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now);
        fileName = "statistic08_" + fileName + ".txt";
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(fileName);
            for (Map.Entry<String, Node> el : list.entrySet()) {
                aux = el.getValue().getPostconditions();
                for (String i : aux) {
                    if(nodes.containsKey(i)) {
                        Node temp = nodes.get(i);
                        aux2 = temp.getPreconditions();
                        boolean sw = false;
                        for (String j : aux2) {
                            if (j.equals(el.getValue().getName())) {
                                sw = true;
                                break;
                            }
                        }
                        if (sw == false) {
                            fw.write("Node " + el.getValue().getName() + " doesn't appear in the pre-conditions of node " + i + "\n");
                        }
                    }
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void statistic10(Map<String, Node> list, String name) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now);
        fileName = "statistic10_" + fileName + ".txt";
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
            File file = new File("huge-test.xml");
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

                if (line.contains("<nodeListPreCondition>")) {
                    line = myReader.nextLine();
                    if (!line.contains("<namePreCondition>")) {
                        //Prec.add(preaux);
                    } else {
                        while (!line.contains("</nodeListPreCondition>")) {
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
            statistic00(nodes, "default");

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
