public class Main {

    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker(originator);
        originator.setName("Mahfooz");
        originator.setValue(123);

        caretaker.createMomento();

        originator.setValue(1234);
        originator.setName("Zainab");

        caretaker.createMomento();

        originator.setValue(200);
        originator.setName("Hilo there");

        System.out.println("originator value is " + originator.getValue());
        System.out.println("originator name is " + originator.getName());
        caretaker.undoLast();
        System.out.println("Restoring to last saved point!!");
        System.out.println("originator value is " + originator.getValue());
        System.out.println("originator name is " + originator.getName());

        caretaker.undoLast();
        System.out.println("Restoring to last saved point!!");
        System.out.println("originator value is " + originator.getValue());
        System.out.println("originator name is " + originator.getName());
    }
}
