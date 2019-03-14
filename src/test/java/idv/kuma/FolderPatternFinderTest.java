package idv.kuma;

import org.junit.Test;

public class FolderPatternFinderTest {

    @Test
    public void When_Folder_Is_Not_A_Folder_Then_Throw_Exception() throws Exception {


        try {
            FolderPatternFinder finder = new FolderPatternFinder("fake/path");
        } catch (FolderPatternFinder.FolderPatternFinderException e) {

        }


    }
}