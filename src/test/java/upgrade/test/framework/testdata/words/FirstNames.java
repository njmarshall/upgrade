package upgrade.test.framework.testdata.words;

import upgrade.test.framework.testdata.RandomItemsArray;

public class FirstNames implements RandomItemsArray {

    public static final String[] items = {
            "Neil",
            "David",
            "Eileen",
            "Lance",
            "Peter",
            "Katie",
            "Christine",
            "Meg",
            "Moira",
            "George",
            "Addie",
            "John",
            "Todd",
            "Anthony"
    };

    @Override
    public String[] getItems() {
        return items;
    }
}
