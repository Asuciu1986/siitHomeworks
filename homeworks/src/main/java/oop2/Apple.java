package oop2;

import java.util.*;

public abstract class Apple implements Phone{
    private Color color;
    private Material material;

    //todo add call and Message classes and refactor the collections
    Set<Contact> contacts = new LinkedHashSet<>();
    Map<String, List<String>> texts = new HashMap<>();
    List<String> calls = new ArrayList<>();


    Apple(Color color, Material material) {
        this.color = color;
        this.material = material;
    }

    public void addContact(Integer index, String phoneNumber, String firstName, String lastName){
        Contact contact = new Contact(index,phoneNumber,firstName,lastName);
        contacts.add(contact);
    }

    public void listContacts(){
        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }

    public void listMessages(String phoneNumber){
        if(texts.containsKey(phoneNumber)){
            for (String text:texts.get(phoneNumber)) {
                System.out.println(text);
            }
        }

        else{
            System.out.println("No messages sent to this contact");
        }
    };

    public List<String> listCalls(){
        return calls;
    };

    @Override
    public String toString() {
        return "Apple{" +
                "color=" + color +
                ", material=" + material +
                ", contacts=" + contacts +
                ", texts=" + texts +
                ", calls=" + calls +
                '}';
    }
}
