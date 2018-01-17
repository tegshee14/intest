package mesh.common.common;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
 
public class CommandMap {
    Map<String,Object> map = new HashMap<String,Object>();
    List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
    
    public List<Map<String,Object>> getList() {
        return list;
    }
    
    public Object get(String key){
        return map.get(key);
    }
    public void setList(List<Map<String,Object>> list) {
        this.list = list;
    }
    public void put(String key, Object value){
        map.put(key, value);
    }
    
    public void Listput(List<Map<String,Object>> valList){
        list = valList;
    }
     
    public Object remove(String key){
        return map.remove(key);
    }
     
    public boolean containsKey(String key){
        return map.containsKey(key);
    }
     
    public boolean containsValue(Object value){
        return map.containsValue(value);
    }
     
    public void clear(){
        map.clear();
    }
     
    public Set<Entry<String, Object>> entrySet(){
        return map.entrySet();
    }
     
    public Set<String> keySet(){
        return map.keySet();
    }
     
    public boolean isEmpty(){
        return map.isEmpty();
    }
     
    public void putAll(Map<? extends String, ?extends Object> m){
        map.putAll(m);
    }
     
    public Map<String,Object> getMap(){
        return map;
    }
    public void setMap(Map<String,Object> map) {
        this.map = map;
    }
}