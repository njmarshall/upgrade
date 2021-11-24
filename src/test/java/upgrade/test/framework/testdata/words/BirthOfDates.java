package upgrade.test.framework.testdata.words;

import upgrade.test.framework.testdata.RandomItemsArray;

public class BirthOfDates implements RandomItemsArray {

    public static final String[] items = {
            "12051982",
            "06051988",
            "01012001",
            "05131999",
            "06131973",
            "02142002"
    };

    @Override
    public String[] getItems() {
        return items;
    }

}
