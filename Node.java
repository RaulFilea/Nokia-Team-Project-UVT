import java.util.List;

public class Node {
    private String name;
    private String link;
    private List<String> preconditions;
    private List<String> postconditions;
    private List<String> triggers;
    private List<String> descriptions;
    private List<String> references;

    public Node(String name, String link, List<String> preconditions, List<String> postconditions, List<String> triggers, List<String> descriptions, List<String> references) {
        this.name = name;
        this.link = link;
        this.preconditions = preconditions;
        this.postconditions = postconditions;
        this.triggers = triggers;
        this.descriptions = descriptions;
        this.references = references;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<String> getPreconditions() {
        return preconditions;
    }

    public void setPreconditions(List<String> preconditions) {
        this.preconditions = preconditions;
    }

    public List<String> getPostconditions() {
        return postconditions;
    }

    public void setPostconditions(List<String> postconditions) {
        this.postconditions = postconditions;
    }

    public List<String> getTriggers() {
        return triggers;
    }

    public void setTriggers(List<String> triggers) {
        this.triggers = triggers;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }

    public List<String> getReferences() {
        return references;
    }

    public void setReferences(List<String> references) {
        this.references = references;
    }

    @Override
    public String toString() {
        return "\nNew node\n" +
                "Node name: " + name + '\n' +
                "Node link: " + link + '\n' +
                "Node preconditions: " + preconditions + '\n' +
                "Node postconditions: " + postconditions + '\n' +
                "Node triggers: " + triggers + '\n' +
                "Node descriptions: " + descriptions + '\n' +
                "Node references: " + references;
    }
}
