package idv.kuma;

import java.io.File;

public class FolderPatternFinder {

    File folder;

    public FolderPatternFinder(String folderPath) throws FolderPatternFinderException {

        checkFolderPath();

        this.folder = new File(folderPath);

        setFolderAndCheck();


    }

    private void setFolderAndCheck() throws FolderPatternFinderException {
    }

    private void checkFolderPath() throws FolderPatternFinderException {
    }



    public class FolderPatternFinderException extends Exception {
    }
}
