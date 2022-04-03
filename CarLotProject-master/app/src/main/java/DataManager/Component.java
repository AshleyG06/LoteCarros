package DataManager;
import java.util.ArrayList;

public class Component{
    private ArrayList<Component> children = new ArrayList<Component>();
    private Component parent = null;
    

    public void setParent(Component newParent){
        parent = newParent;
    }

    public Component getParent(){
        return parent;
    }

    public void addChild(Component child){
        if(child.parent != this){
            child.setParent(this);
            children.add(child);
        }
    }
    
    public void removeChild(Component child){
        children.remove(child);
    }

    public void removeFromParent(){
        if(parent != null){
            parent.removeChild(this);
            parent = null;
        }
    }

    public void removeAllChildren(){
        children.clear();
    }

    public void removeAllChildrenRecursively(){
        for(int i= children.size(); i > 0; i-- ){
            Component targetChild = children.get(0);
            targetChild.removeAllChildrenRecursively();
            targetChild.removeFromParent();
        }
    }

    public Component getChildAt(int index){
        return children.get(index);
    }

    
    public int countChildren(){
        return children.size();
    }
    
    public int countChildrenRecurively(){
        int totalChildren = children.size();
        for(Component child : children){
            totalChildren += child.countChildrenRecurively();
        }
        return totalChildren;
    }

}
