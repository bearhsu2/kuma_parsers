package idv.kuma;

public class HouseKeeperHandledUsersCounterMain {

    private static String DEFAULT_FOLDER_PATH = "./src/main/resources";

    public static void main(String[] args) throws HouseKeeperHandledUsersCounter.FolderPatternFinderException {


        HouseKeeperHandledUsersCounter counter = new HouseKeeperHandledUsersCounter(DEFAULT_FOLDER_PATH);

        counter.count();


    }
}
