import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void statistic00(List<Node> list, String name) {
        List<String> aux;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now);
        fileName = fileName + ".txt";
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(fileName);
            for (Node el : list) {
                aux = el.getPreconditions();
                if (aux.size() == 0) {
                    fw.write("Node " + el.getName() + " has no precondition\n");
                    //System.out.println("Node " + el.getName() + " has no precondition");
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void statistic01(List<Node> list, String name) {
        List<String> aux;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now);
        fileName = fileName + ".txt";
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(fileName);
            for (Node el : list) {
                aux = el.getTriggers();
                if (aux.size() == 0) {
                    fw.write("Node " + el.getName() + " has no triggers\n");
                    //System.out.println("Node " + el.getName() + " has no triggers");
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
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

            List<Node> nodes = new ArrayList<>();

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();

                if (line.contains("</node>")) {

                    node = new Node(name, link, Prec, Postc, Trig, Desc, Ref);
                    nodes.add(node);

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
            statistic00(nodes, "default");

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
