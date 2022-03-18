import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
/**
 * @author Carlos Sebastián Reyes Villatoro 21139
 * @author Carlos Estrada 20853
 */
public class MapFactory {
    /**
     * @param option devuelve un int
     * @return si el usuario escoge 1, sera el HashMpa,  
     * Si escoge 2 será TreeMap, Si escoge 3 será  LinkedHashMap y si no esocge nada será nada null.
     */
    public static Map ChooseMap(int option){
        //HashMap
        if (option == 1){
            return new HashMap();
        //TreeMap
        }else if (option == 2){
            return new TreeMap();
        //LinkedHashMap
        }else if (option == 3){
            return new LinkedHashMap();
        }
        return null;
    }
    
}
