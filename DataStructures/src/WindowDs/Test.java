package WindowDs;

public class Test {


    public static void main(String[] args){
        Window<Integer,String> window = new TreeMapWindow<>(3);

        window.addItem(9,"akef");
        window.addItem(8,"saif");
        window.addItem(10,"darakh");
        window.addItem(11,"mas");

        window.printWindow();

        for(Object val : window.getTopK(4)){
            System.out.println((Integer) val);
        }
    }
}
