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
    public static List<String> stat10 = new ArrayList<>();
    public static List<String> stat11 = new ArrayList<>();
    public static List<List> stat12 = new ArrayList<>();
    public static List<String> passed = new ArrayList<>();
    public static List<List> stat13 = new ArrayList<>();
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
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void statistic05(Map<String, Node> list, String name) {
        List<String> aux, aux2 = new ArrayList<>();
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
                        boolean sw = aux2.contains(el.getKey());
                        if (sw == false) {
                            fw.write("Node " + el.getKey() + " doesn't appear in the post-conditions of node " + i + "\n");
                            //aux2.add(el.getKey());
                        }
                    }
                    //nodes.get(i).setPostconditions(aux2);
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void statistic06(Map<String, Node> list, String name) {
        List<String> aux, aux2 = new ArrayList<>();
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
                        boolean sw = aux2.contains(el.getKey());
                        if (sw == false) {
                            fw.write("Node " + el.getKey() + " doesn't appear in the description of node " + i + "\n");
                            //aux2.add(el.getKey());
                        }
                    }
                    //nodes.get(i).setDescriptions(aux2);
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void statistic07(Map<String, Node> list, String name) {
        List<String> aux, aux2 = new ArrayList<>();
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
                        boolean sw = aux2.contains(el.getKey());
                        if (sw == false) {
                            fw.write("Node " + el.getValue().getName() + " doesn't appear in the triggers of node " + i + "\n");
                            //aux2.add(el.getKey());
                        }
                    }
                    //nodes.get(i).setTriggers(aux2);
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void statistic08(Map<String, Node> list, String name) {
        List<String> aux, aux2 = new ArrayList<>();
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
                        boolean sw = aux2.contains(el.getKey());
                        if (sw == false) {
                            fw.write("Node " + el.getValue().getName() + " doesn't appear in the pre-conditions of node " + i + "\n");
                            //aux2.add(el.getKey());
                        }
                    }
                    //nodes.get(i).setPreconditions(aux2);
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void statistic09(Map<String, Node> list, String name) {
        List<String> aux, aux2,aux3, aux4, aux5, aux6, aux7, aux8, aux9 = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now);
        fileName = "statistic09_" + fileName + ".txt";
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(fileName);
            for (Map.Entry<String, Node> el : list.entrySet()) { //el = S1
                aux = el.getValue().getReferences();
                aux2 = el.getValue().getPreconditions();
                aux3 = el.getValue().getTriggers();
                aux4 = el.getValue().getDescriptions();
                aux5 = el.getValue().getPostconditions();
                for (String i : aux) //S1 reference
                    if(nodes.containsKey(i)) {
                        boolean sw1 = aux2.contains(i); //S1
                        boolean sw2 = aux3.contains(i); //S1
                        boolean sw3 = aux4.contains(i); //S1
                        boolean sw4 = aux5.contains(i); //S1
                        if (sw1 == false && sw2 == false && sw3 == false && sw4 == false) {
                            fw.write("Node " + i + " appears in the references of " + el.getKey() + " but doesn't appear in the pre-conditions/triggers/descriptions/post-conditions" + "\n");
                        }
                    }
                for (String i : aux) { //aux from S1, i -> S2
                    if(nodes.containsKey(i)) {
                        Node temp = nodes.get(i); //temp = S2
                        aux6 = temp.getPreconditions(); //S2
                        aux7 = temp.getTriggers(); //S2
                        aux8 = temp.getDescriptions(); //S2
                        aux9 = temp.getPostconditions(); //S2
                        boolean sw5 = aux6.contains(el.getKey());
                        boolean sw6 = aux7.contains(el.getKey());
                        boolean sw7 = aux8.contains(el.getKey());
                        boolean sw8 = aux9.contains(el.getKey());
                        if (sw5 == false && sw6 == false && sw7 == false && sw8 == false) {
                            fw.write("Node " + i + " appears in the references of node " + el.getKey() +" but " + el.getKey() +" doesn't appear in the pre-conditions/triggers/descriptions/post-conditions of node " + i + "\n");
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
                iter10(aux, el.getKey());
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

    public static void statistic11(Map<String, Node> list, String name) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now);
        fileName = "statistic11_" + fileName + ".txt";
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(fileName);
            List<String> aux = new ArrayList<>();
            iter10(aux, name);
            maxim = 0; aux = new ArrayList<>();
            iter11(aux, name);
            fw.write("Longest path containing " + name + ":\n");
            for (String i : stat11) {
                fw.write(i + "\n");
            }
            for (String i : stat10) {
                fw.write(i + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void iter10 (List<String> list, String nodeName) {
        Node aux = nodes.get(nodeName);
        if (aux == null) {
            System.out.println("Node " + nodeName + " does not exist in file.");
            return;
        }
        list.add(nodeName);
        for (String el : aux.getDescriptions()) {
            if(!list.contains(el)) {
                iter10(list, el);
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
                iter10(list, el);
                if (list.size() + 1 > maxim) {
                    maxim = list.size() + 1;
                    if(!list.contains(el))
                        list.add(el);
                    stat10 = list;
                }
            }
        }
    }

    public static void iter11 (List<String> list, String nodeName) {
        Node aux = nodes.get(nodeName);
        if (aux == null) {
            System.out.println("Node " + nodeName + " does not exist in file.");
            return;
        }
        list.add(nodeName);
        for (String el : aux.getTriggers()) {
            if(!list.contains(el) && !stat10.contains(el)) {
                iter10(list, el);
                if (list.size() + 1 > maxim) {
                    maxim = list.size() + 1;
                    if(!list.contains(el))
                        list.add(0, el);
                    stat11 = list;
                }
            }
        }
        for (String el : aux.getPreconditions()) {
            if(!list.contains(el) && !stat10.contains(el)) {
                iter10(list, el);
                if (list.size() + 1 > maxim) {
                    maxim = list.size() + 1;
                    if(!list.contains(el))
                        list.add(0, el);
                    stat11 = list;
                }
            }
        }
    }
    
    public static void statistic12(Map<String, Node> list, String name) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now);
        fileName = "statistic12_" + fileName + ".txt";
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(fileName);
            for (Map.Entry<String, Node> el : list.entrySet()) {
                List<String> aux = new ArrayList<>();
                iter12(aux, el.getKey(), el.getKey());
                passed.add(el.getKey());
            }//this for goes through all the nodes, finds all the cycles that start from the current node and memorizes
            //the current node in the list called passed so it can be ignored when finding the cycles for the nodes that follow it
            for (List l : stat12) {
                fw.write(String.valueOf(l));
                fw.write("\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void iter12 (List<String> list, String nodeName, String node) {
        Node aux = nodes.get(nodeName);
        if (aux == null) {
            System.out.println("Node " + nodeName + " does not exist in file.");
            return;
        }
        list.add(nodeName);
        for (String el : aux.getDescriptions()) {
            if(!passed.contains(el)) //passed is the list that contains the nodes we've passed in the for in the statistic 12 function
                if(!list.contains(el)) {
                    iter12(list, el, node);
                } else if (el.equals(node)) {
                    list.add(node);
                    stat12.add(list);
                    break;
                }
        }
        for (String el : aux.getPostconditions()) {
            if(!passed.contains(el))
                if(!list.contains(el)) {
                    iter12(list, el, node);
                } else if (el.equals(node)) {
                    list.add(node);
                    stat12.add(list);
                    break;
                }
        }
    }

    public static void statistic13(Map<String, Node> list, String name) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now);
        fileName = "statistic13_" + fileName + ".txt";
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(fileName);
            List<String> aux = new ArrayList<>();
            iter13(aux, name, name);
            fw.write("Cycles containing " + name + ":\n");
            for (List l : stat13) {
                for (Object i : l) {
                    fw.write(i + "->");
                }
                fw.write(name + '\n');
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void iter13 (List<String> list, String nodeName, String node) {
        Node aux = nodes.get(nodeName);
        if (aux == null) {
            System.out.println("Node " + nodeName + " does not exist in file.");
            return;
        }
        list.add(nodeName);
        for (String el : aux.getDescriptions()) {
            if(!list.contains(el)) {
                iter13(list, el, node);
            } else if (el.equals(node)) {
                stat13.add(list);
            }
        }
        for (String el : aux.getPostconditions()) {
            if(!list.contains(el)) {
                iter13(list, el, node);
            } else if (el.equals(node)) {
                stat13.add(list);
            }
        }
    }

    public static void heal (Map<String, Node> list) {
        List<String> aux = new ArrayList<>(), aux2 = new ArrayList<>(), aux3 = new ArrayList<>(), aux4 = new ArrayList<>(), aux5 = new ArrayList<>();
        Set<String> s = new HashSet<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now);
        fileName = "heal_" + fileName + ".txt";
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(fileName);
            for (Map.Entry<String, Node> el : list.entrySet()) {
                aux = el.getValue().getPreconditions();
                for (String i : aux) {
                    if(nodes.containsKey(i)) {
                        Node temp = nodes.get(i);
                        aux2 = temp.getPostconditions();
                        boolean sw = aux2.contains(el.getKey());
                        if (sw == false) {
                            //fw.write("Node " + el.getKey() + " doesn't appear in the post-conditions of node " + i + "\n");
                            aux2.add(el.getKey());
                        }
                    }
                    nodes.get(i).setPostconditions(aux2);
                }
                aux = el.getValue().getTriggers();
                for (String i : aux) {
                    if(nodes.containsKey(i)) {
                        Node temp = nodes.get(i);
                        aux2 = temp.getDescriptions();
                        boolean sw = aux2.contains(el.getKey());
                        if (sw == false) {
                            //fw.write("Node " + el.getKey() + " doesn't appear in the description of node " + i + "\n");
                            aux2.add(el.getKey());
                        }
                    }
                    nodes.get(i).setDescriptions(aux2);
                }
                aux = el.getValue().getDescriptions();
                for (String i : aux) {
                    if(nodes.containsKey(i)) {
                        Node temp = nodes.get(i);
                        aux2 = temp.getTriggers();
                        boolean sw = aux2.contains(el.getKey());
                        if (sw == false) {
                            //fw.write("Node " + el.getValue().getName() + " doesn't appear in the triggers of node " + i + "\n");
                            aux2.add(el.getKey());
                        }
                    }
                    nodes.get(i).setTriggers(aux2);
                }
                aux = el.getValue().getPostconditions();
                for (String i : aux) {
                    if(nodes.containsKey(i)) {
                        Node temp = nodes.get(i);
                        aux2 = temp.getPreconditions();
                        boolean sw = aux2.contains(el.getKey());
                        if (sw == false) {
                            //fw.write("Node " + el.getValue().getName() + " doesn't appear in the pre-conditions of node " + i + "\n");
                            aux2.add(el.getKey());
                        }
                    }
                    nodes.get(i).setPreconditions(aux2);
                }
            }
            for (Map.Entry<String, Node> el : list.entrySet()) {
                aux = el.getValue().getPreconditions();
                aux2 = el.getValue().getPostconditions();
                aux3 = el.getValue().getDescriptions();
                aux4 = el.getValue().getTriggers();
                aux5 = el.getValue().getReferences();

                s = new HashSet<>(Stream.of(aux, aux2, aux3, aux4, aux5).flatMap(Collection::stream).collect(Collectors.toList()));
                fw.write(String.valueOf(s));
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main (String [] args) {
        try {
            File file = null;
            Scanner in = new Scanner(System.in);
            Node node;
            String name = null, link = null, specialNode = "default", id = "default";
            List<String> Prec, Postc, Trig, Ref, Desc;
            String [] aux;
            String [] aux2;
            String [] tokensCline;
            int i = 0;

            Prec = new ArrayList<>();
            Postc = new ArrayList<>();
            Trig = new ArrayList<>();
            Ref = new ArrayList<>();
            Desc = new ArrayList<>();

            String cline = in.nextLine();
            tokensCline = cline.split(" ");

            // Interpreting of the command in command line
            /** scriptName --runOnScenario <SCENARIO_NAME> | ALL=DEFAULT --checkStatistic <ID> | ALL=DEFAULT --fileName <FILE_NAME> **/
            while (i < tokensCline.length - 1) {
                if (tokensCline[i].equals("--runOnScenario")) {
                    i++;
                    specialNode = tokensCline[i];
                }

                if (tokensCline[i].equals("--checkStatistic")) {
                    i++;
                    id = tokensCline[i];
                }

                if (tokensCline[i].equals("--fileName")) {
                    i++;
                    file = new File(tokensCline[i]);
                }

                i++;
            }

            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();

                if (line.contains("</node>") && name != null) {

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
                    if (!line.contains("<nameReference>")) {
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

            switch (id) {
                case "00":
                    statistic00(nodes, "");
                    break;
                case "01":
                    statistic01(nodes, "");
                    break;
                case "02":
                    statistic02(nodes, "");
                    break;
                case "03":
                    statistic03(nodes, "");
                    break;
                case "04":
                    statistic04(nodes, "");
                    break;
                case "05":
                    statistic05(nodes, "");
                    break;
                case "06":
                    statistic06(nodes, "");
                    break;
                case "07":
                    statistic07(nodes, "");
                    break;
                case "08":
                    statistic08(nodes, "");
                    break;
                case "09":
                    statistic09(nodes, "");
                    break;
                case "10":
                    statistic10(nodes, "");
                    break;
                case "11":
                    if (specialNode.equals("default")) {
                        System.out.println("--runOnScenario requires scenario");
                        break;
                    }
                    statistic11(nodes, specialNode);
                    break;
                case "12":
                    statistic12(nodes, "");
                    break;
                case "13":
                    if (specialNode.equals("default")) {
                        System.out.println("--runOnScenario requires scenario");
                        break;
                    }
                    statistic13(nodes, specialNode);
                    break;
                case "heal":
                    heal(nodes);
                    break;
                case "default":
                    statistic00(nodes, "");
                    statistic01(nodes, "");
                    statistic02(nodes, "");
                    statistic03(nodes, "");
                    statistic04(nodes, "");
                    statistic05(nodes, "");
                    statistic06(nodes, "");
                    statistic07(nodes, "");
                    statistic08(nodes, "");
                    statistic09(nodes, "");
                    statistic10(nodes, "");
                    statistic11(nodes, specialNode);
                    statistic12(nodes, "");
                    statistic13(nodes, specialNode);
            }
            /*for (Node el : nodes) {
                System.out.println(el);
            }*/
            System.out.println(" _");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

/** scriptName --runOnScenario <SCENARIO_NAME> | ALL=DEFAULT --checkStatistic <ID> | ALL=DEFAULT --fileName <FILE_NAME> **/
