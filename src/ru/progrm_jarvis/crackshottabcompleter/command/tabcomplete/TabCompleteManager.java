package ru.progrm_jarvis.crackshottabcompleter.command.tabcomplete;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PROgrm_JARvis on 26.05.2017.
 */
class TabCompleteManager {
    static List<String> adopt(String last, List<String> variants) {
        List<String> variantsList = new ArrayList<>(variants);
        for (String variant : variantsList) if (!variant.startsWith(last)) variants.remove(variant);
        return variants;
    }
}
