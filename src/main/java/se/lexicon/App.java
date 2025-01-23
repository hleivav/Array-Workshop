package se.lexicon;


public class App {
    public static void main(String[] args) {

        int size = NameRepository.getSize();
        System.out.println(size);
        NameRepository.setNames(new String[]{"Josef Stalin", "Franklin Stalin", "Franklin Roosevelt", "Benito Mussolini", "Adolf Hitler", "Winston Churchill", "Benito Manggioni"});
        System.out.println(NameRepository.getSize());
        System.out.println(NameRepository.find("Adolf Hitler"));
        System.out.println(NameRepository.add("Charles de Gaulle"));
        NameRepository.getElement();
        for ( String element : NameRepository.findByFirstName("Benito")){
            System.out.println(element);
        }
       for ( String element : NameRepository.findByLastName("Stalin")){
            System.out.println(element);
        }

        System.out.println(NameRepository.update("Benito Mangionni", "Mano Zedong"));
        NameRepository.getElement();
        System.out.println(NameRepository.update("Benito Manggioni", "Mano Zedong"));
        // call more methods as needed
        NameRepository.remove("Franklin Roosevelt");
        NameRepository.getElement();
    }
}
