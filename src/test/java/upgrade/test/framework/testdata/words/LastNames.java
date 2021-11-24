package upgrade.test.framework.testdata.words;

import upgrade.test.framework.testdata.RandomItemsArray;

public class LastNames implements RandomItemsArray {

    public static final String[] items = {
            "Marshall",
            "Forshay",
            "Mcleod",
            "Browning",
            "Bradley",
            "McWilliam",
            "Mann",
            "Edinger",
            "Musk",
            "Gates"
    };

    @Override
    public String[] getItems() {
        return items;
    }
}
