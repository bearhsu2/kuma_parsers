package idv.kuma;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HouseKeeperHandledUsersCounter {

    private static final String KEY_WORD = "[RuntimeMachine HouseKeeper][Success] - ";

    File folder;
    private Map<String, Integer> fileNameToCount = new HashMap<>();


    public HouseKeeperHandledUsersCounter(String folderPath) throws FolderPatternFinderException {

        this.folder = new File(folderPath);

        if (!folder.isDirectory()) throw new FolderPatternFinderException("not a folder");


    }

    public void count() {
        System.out.println("count start");

        File[] files = folder.listFiles();

        Arrays.stream(files).filter(file -> file.getName().startsWith("GameMonitorLogger-")).forEach(file -> this.countForFile(file));

        showCount();

        System.out.println("count done");


    }

    private void countForFile(File file) {


        String fileName = file.getName();

        System.out.println("process " + fileName + "...");

        int counter = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {

                processLine(fileName, line);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("process " + fileName + " done.");
    }

    private void processLine(String fileName, String line) {

        if (!line.contains(KEY_WORD)) return;

        int index = line.indexOf(KEY_WORD);
        String substring = line.substring(index + KEY_WORD.length());

        int count = 1 + StringUtils.countMatches(substring, ",");

        Integer currentCount = fileNameToCount.getOrDefault(fileName, 0);

        fileNameToCount.put(fileName, currentCount + count);

    }

    private void showCount() {

        fileNameToCount.forEach((key, value) -> {
            String fileName = key;
            int count = value;
            System.out.println(key + ", " + count);

        });

    }


    public class FolderPatternFinderException extends Exception {
        public FolderPatternFinderException(String message) {
            super(message);
        }
    }
}
