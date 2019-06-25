package by.babanin.example2;

import java.util.Map;
import java.util.Set;

public interface IFileManager {
    Set<String> getExtensionList(String folder);

    Map<String, Integer> getExtensionCount(String folder);
}
