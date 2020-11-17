package ru.geekbrains.lessons.lesson_a;



import java.util.ArrayList;

public class Box<T> {

    private T object;
    private ArrayList<T> arrayList = new ArrayList<>();


    public Object getObject(){
        return object;
    }


    public void addObject(T object){
        arrayList.add(object);
    }

    public float getWeight() {
        float weight = 0;
        if(object instanceof Fruit) { //наверно плохо ставить такую зависимость, но по другому не придумал
            weight = ((Fruit) object).weight * arrayList.size();
        }
       return weight;
    }

    public boolean compare(Box<?> box){
        return getWeight() < box.getWeight();
    }

    public void copyBox(Box<T> box){
        for (int i = 0; i < arrayList.size(); i++) {
            box.addObject(object);
        }
        arrayList.clear();
    }

    public void displayBox(){
        System.out.printf("Количество %s в коробке: %s\n", object.getClass().getSimpleName(), arrayList.size());
    }

    public Box(T object){
        this.object = object;
    }
}
