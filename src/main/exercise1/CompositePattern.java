import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {
    void showDetails();
}

class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("File: " + name);
    }
}

class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components;

    public Directory(String name) {
        this.name = name;
        components = new ArrayList<>();
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    public void showDetails() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
            component.showDetails();
        }
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        Directory rootDirectory = new Directory("root");

        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        Directory subDirectory = new Directory("subdir");

        rootDirectory.addComponent(file1);
        rootDirectory.addComponent(file2);
        rootDirectory.addComponent(subDirectory);

        subDirectory.addComponent(new File("file3.txt"));

        rootDirectory.showDetails();
    }
}