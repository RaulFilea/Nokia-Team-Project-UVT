import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaTry {
    public static void main (String [] args) {
        try {
            File file = new File("D:\\Scoala\\Y2S2\\TP\\ProjectJava\\test1.xml");
            Scanner myReader = new Scanner(file);
            Node node;
            String name = null, link = null, prec, posc, trig, ref, desc;
            List<String> Prec, Postc, Trig, Ref, Desc;

            Prec = new ArrayList<>();
            Postc = new ArrayList<>();
            Trig = new ArrayList<>();
            Ref = new ArrayList<>();
            Desc = new ArrayList<>();

            String preaux = "This node contains no <namePrecondition>s";
            String postaux = "This node contains no <namePostCondition>s";
            String trigaux = "This node contains no <nameTrigger>s";
            String descaux = "This node contains no <nameTrigger>s";
            String refaux = "This node contains no <nameReferences>s";

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
                    prec = null;
                    posc = null;
                    trig = null;
                    ref = null;
                    desc = null;
                }

                if (line.contains("<name>")) {
                    name = line.replace("        <name>", "");
                    name = name.replace("</name>", "");
                }

                if (line.contains("<link>")) {
                    link = line.replace("        <link>", "");
                    link = link.replace("</link>", "");
                }

                if (line.contains("<nodeListPrecondition>")) {
                    line = myReader.nextLine();
                    if (!line.contains("<namePrecondition>")) {
                        Prec.add(preaux);
                    } else {
                        while (!line.contains("</nodeListPrecondition>")) {
                            prec = line.replace("            <namePrecondition>", "");
                            prec = prec.replace("</namePrecondition>", "");
                            Prec.add(prec);
                            line = myReader.nextLine();
                        }
                    }
                }

                if (line.contains("<nodeListPostCondition>")) {
                    line = myReader.nextLine();
                    if (!line.contains("<namePostCondition>")) {
                        Postc.add(postaux);
                    } else {
                        while (!line.contains("</nodeListPostCondition>")) {
                            posc = line.replace("            <namePostCondition>", "");
                            posc = posc.replace("</namePostCondition>", "");
                            Postc.add(posc);
                            line = myReader.nextLine();
                        }
                    }
                }

                if (line.contains("<nodeListTrigger>")) {
                    line = myReader.nextLine();
                    if (!line.contains("<nameTrigger>")) {
                        Trig.add(trigaux);
                    } else {
                        while (!line.contains("</nodeListTrigger>")) {
                            trig = line.replace("            <nameTrigger>", "");
                            trig = trig.replace("</nameTrigger>", "");
                            Trig.add(trig);
                            line = myReader.nextLine();
                        }
                    }
                }

                if (line.contains("<nodeListDescription>")) {
                    line = myReader.nextLine();
                    if (!line.contains("<nameDescription>")) {
                        Desc.add(descaux);
                    } else {
                        while (!line.contains("</nodeListDescription>")) {
                            desc = line.replace("            <nameDescription>", "");
                            desc = desc.replace("</nameDescription>", "");
                            Desc.add(desc);
                            line = myReader.nextLine();
                        }
                    }
                }

                if (line.contains("<nodeListReferences>")) {
                    line = myReader.nextLine();
                    if (!line.contains("<nameReferences>")) {
                        Ref.add(refaux);
                    } else {
                        while (!line.contains("</nodeListReferences>")) {
                            ref = line.replace("            <nameReferences>", "");
                            ref = ref.replace("</nameReferences>", "");
                            Ref.add(ref);
                            line = myReader.nextLine();
                        }
                    }
                }
            }
            myReader.close();

            for (Node el : nodes) {
                System.out.println(el);
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
