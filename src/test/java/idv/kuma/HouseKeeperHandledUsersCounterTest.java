package idv.kuma;

import org.junit.Test;

public class HouseKeeperHandledUsersCounterTest {

    @Test
    public void When_Folder_Is_Not_A_Folder_Then_Throw_Exception() throws Exception {


        try {
            HouseKeeperHandledUsersCounter finder = new HouseKeeperHandledUsersCounter("fake/path");
        } catch (HouseKeeperHandledUsersCounter.FolderPatternFinderException e) {

        }


    }
}