import java.util.ArrayList;
import java.util.List;

// Represents a file or directory in the system
class File {
    String name;          // Name of the file/directory
    int size;             // Size of the file (in bytes)
    String type;          // File extension (e.g., "txt", "xml", "json")
    boolean isDirectory;  // True if it’s a directory
    File[] children;      // Children if it's a directory

    // Constructor
    public File(String name, int size, String type, boolean isDirectory, File[] children) {
        this.name = name;
        this.size = size;
        this.type = type;
        this.isDirectory = isDirectory;
        this.children = children;
    }
}

// Abstract class for applying filters
abstract class Filter {
    abstract boolean apply(File file);
}

// Filter for minimum file size
class MinSizeFilter extends Filter {
    int minSize;

    public MinSizeFilter(int minSize) {
        this.minSize = minSize;
    }

    @Override
    boolean apply(File file) {
        return file.size > minSize;
    }
}

// Filter for file extension
class TypeFilter extends Filter {
    String type;

    public TypeFilter(String type) {
        this.type = type;
    }

    @Override
    boolean apply(File file) {
        return file.type != null && file.type.equals(type);
    }
}

// Filter for file name
class NameFilter extends Filter {
    String name;

    public NameFilter(String name) {
        this.name = name;
    }

    @Override
    boolean apply(File file) {
        return file.name.equals(name);
    }
}

// FindCommand searches files using multiple filters
public class FindCommand {

    // Main search method that applies all filters
    public List<File> findWithFilters(File directory, List<Filter> filters) {
        // Check if the provided file is a valid directory
        if (!directory.isDirectory) {
            throw new IllegalArgumentException("Provided file is not a directory.");
        }

        List<File> output = new ArrayList<>();
        findWithFilters(directory, filters, output);
        return output;
    }

    // Helper method to recursively search for matching files
    private void findWithFilters(File directory, List<Filter> filters, List<File> output) {
        // Base case: If directory is empty or has no children
        if (directory.children == null) {
            return;
        }

        // Iterate through all files and directories in the directory
        for (File file : directory.children) {
            if (file.isDirectory) {
                // Recursively search subdirectories
                findWithFilters(file, filters, output);
            } else {
                // Apply all filters
                boolean selectFile = true;
                for (Filter filter : filters) {
                    if (!filter.apply(file)) {
                        selectFile = false;
                        break; // Skip the file if any filter does not pass
                    }
                }
                // If file passes all filters, add to output
                if (selectFile) {
                    output.add(file);
                }
            }
        }
    }
}
