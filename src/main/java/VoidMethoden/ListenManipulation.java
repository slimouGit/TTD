package VoidMethoden;

import java.util.List;

public class ListenManipulation {


    public void removeFirstItemFromList(List<String> liste){
        liste.remove(0);
    }

    public void removeObjectFromList(List<String> list, Object obj){
        if(list.contains(obj)){
            list.remove(obj);
        }else{
            System.out.println(obj + " was not found in list");
        }
    }
}
