package org.psics.be;

import java.util.ArrayList;
import java.util.HashMap;


public class KeyedMultiList<V> {

  ArrayList<V> items;
  HashMap<String, ArrayList<V>> listHM;

  Class<V> itemClass;

public KeyedMultiList() {
     items = new ArrayList<V>();
     listHM = new HashMap<String, ArrayList<V>>();
  }

  public KeyedMultiList(Class<V> c) {
     this();
     itemClass = c;
  }


  @SuppressWarnings("unchecked")
public KeyedMultiList(String s) {
     this();
     try {
       itemClass = (Class<V>)Class.forName(s);
     } catch (Exception ex) {
        E.error("cant find class " + s + " " + ex);
     }
  }





  public ArrayList<V> getItems() {
     return items;
  }

  public boolean hasItems(String s) {
     return listHM.containsKey(s);
  }

  public ArrayList<V> getItems(String s) {
     ArrayList<V> ret = null;
     if (listHM.containsKey(s)) {
        ret = listHM.get(s);
     }
     return ret;
  }




  public void add(V obj) {
     items.add(obj);
     String sid = "";
     if (obj instanceof IDd) {
        sid = ((IDd)obj).getID();
     } else {
        sid = obj.toString();
     }
     add(sid, obj);
  }



  public void add(String sid, V obj) {

     if (listHM.containsKey(sid)) {
        (listHM.get(sid)).add(obj);
     } else {
        ArrayList<V> alv = new ArrayList<V>();
        alv.add(obj);
        listHM.put(sid, alv);
     }
  }


}
