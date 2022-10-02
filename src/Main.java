import java.util.ArrayList;
import java.util.Arrays;

import static java.util.List.of;

public class Main {
   public static final Integer ALPHABET = 26;
   public static final Integer CHAR_SHIFT = 64;
   public static final ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,3,4,5,27,26,27,28,52,53,78,703,800,3000));

    public static void main(String[] args) {

        ExcelUtils excelUtils = new ExcelUtils(ALPHABET, CHAR_SHIFT);
        excelUtils.addAlphabet();
        excelUtils.convert(list);
        excelUtils.printMapResult();
    }
}