public import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create files
        File file1 = new File("file1.txt", 500, "txt", false, null);
        File file2 = new File("data.xml", 1500, "xml", false, null);
        File file3 = new File("report.json", 1000, "json", false, null);

        // Create subdirectory
        File subDirectory = new File("subdir", 0, null, true, new File[]{file1, file2});

        // Create root directory
        File rootDirectory = new File("root", 0, null, true, new File[]{subDirectory, file3});

        // Create filters
        MinSizeFilter minSizeFilter = new MinSizeFilter(1000);  // Min size > 1000 bytes
        TypeFilter typeFilter = new TypeFilter("xml");          // Type is "xml"
        NameFilter nameFilter = new NameFilter("data.xml");     // Name is "data.xml"

        // Add filters to the list
        List<Filter> filters = new ArrayList<>();
        filters.add(minSizeFilter);
        filters.add(typeFilter);
        filters.add(nameFilter);

        // Execute find command
        FindCommand findCommand = new FindCommand();
        List<File> result = findCommand.findWithFilters(rootDirectory, filters);

        // Print matching files
        for (File file : result) {
            System.out.println("Found file: " + file.name);
        }
    }
}
 {
    
}
