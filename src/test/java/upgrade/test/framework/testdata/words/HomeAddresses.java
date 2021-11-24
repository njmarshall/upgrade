package upgrade.test.framework.testdata.words;

import upgrade.test.framework.testdata.RandomItemsArray;

public class HomeAddresses implements RandomItemsArray {

    public static final String[] items = {
        "101 Fremont Avenue, Los Altos, CA, 94022, USA",
        "101 Fremont Hub Courtyard, Fremont, CA, 94538, USA",
        "101 Alma Street, Palo Alto, CA, 94306, USA",
        "2631 Tamalpais Terrace, Fremont, CA, 94538, USA",
        "2631 Elmdale Place, Palo Alto, CA, 94303, USA",
        "7521 Brighton Drive, Dublin, CA, 94568, USA",
        "7521 Birkdale Drive, Newark, CA, 94560, USA"
    };

    @Override
    public String[] getItems() {
        return items;
    }
}
