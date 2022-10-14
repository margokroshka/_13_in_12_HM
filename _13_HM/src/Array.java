import java.lang.reflect.GenericArrayType;
import java.util.Scanner;

public class Array <O>{
//    Object[] obj=new Object[10];
//
//    public void add(O o){
//        obj[0]=o;
//    }
//
//    public void test(){
//
//        for (Object t:obj
//        ) {
//            System.out.println(t);
//        }
//    }




    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;

    /*
    Добавляет новый элемент в список. При достижении размера внутреннего
    массива происходит его увеличение в два раза.
    */
    public void add(Object item) {
        if(pointer == array.length-1)
            resize(array.length*2); // увеличу в 2 раза, если достигли границ
        array[pointer++] = item;
    }

    /*
    Возвращает элемент списка по индексу.
    */
    public O get(int index) {
        return (O) array[index];
    }

    /*
   Удаляет элемент списка по индексу. Все элементы справа от удаляемого
   перемещаются на шаг налево. Если после удаления элемента количество
   элементов стало в CUT_RATE раз меньше чем размер внутреннего массива,
   то внутренний массив уменьшается в два раза, для экономии занимаемого
   места.
   */
    public void remove(int index) {
        for (int i = index; i<pointer; i++)
            array[i] = array[i+1];
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length/2); // если элементов в CUT_RATE раз меньше чем
        // длина массива, то уменьшу в два раза
    }

    public void delete() {
        for (int i =0; i<pointer; i++)
        array[pointer] = null;
        pointer--;
    }


    public void check() {
        Scanner sc=new Scanner(System.in);
        System.out.println("введите число которое хотите проверить:");
        Object a= sc.nextInt();
        for (int i =0; i<pointer; i++)
            if(a==array[i]) {
                System.out.println("число которое вы ввели находится под ндексом=" + i);
            }else{
                System.out.println("такого числа нет");
            }
    }

    /*Вспомогательный метод для масштабирования.*/
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
}
