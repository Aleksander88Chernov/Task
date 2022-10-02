import java.util.*;
import java.util.stream.IntStream;

public class ExcelUtils {
    public ExcelUtils(Integer alphabet, Integer charShift) {
        this.alphabet = alphabet;
        this.charShift = charShift;
    }
    private Map<Integer,Character> mapAlphabet = new HashMap<>();
    private Map<Integer, String> mapResult = new HashMap<>();
    private Integer charShift;
    private Integer alphabet;


    public void addAlphabet(){
        IntStream.rangeClosed(1, alphabet).forEach(i -> mapAlphabet.put(i, (char) (i + charShift)));
    }
    private ArrayList<Integer> listPosition(Integer num){
        ArrayList<Integer> list = new ArrayList<>();
        Integer position = num ;
        Integer position1 = num % alphabet;
        while (position > alphabet){
            list.add(position1);
            position = position / alphabet;
            position1 = position % alphabet;
        }
        list.add(position);
        return list;
    }

    public void convert(ArrayList<Integer> list){
        list.trimToSize();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++){
            ArrayList<Integer> positionList = listPosition(list.get(i));
            positionList.trimToSize();
            for (int j = positionList.size()-1; j >= 0; j--){
                if(positionList.contains(0)) {
                    if (positionList.get(j) == 0)
                        builder.append(mapAlphabet.get(alphabet));
                    else
                        builder.append(mapAlphabet.get(positionList.get(j)-1));
                }else{
                    builder.append(mapAlphabet.get(positionList.get(j)));
                }
            }
            mapResult.put(list.get(i), builder.toString());
            builder.setLength(0);
        }
    }
    public void printMapResult(){
        for (Map.Entry<Integer, String> entry : mapResult.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}
