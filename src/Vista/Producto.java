
package Vista;
public class Producto {  
private String id;
private String name;
public  Producto(String id, String name){
this.id=id;
this.name=name;
}

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
