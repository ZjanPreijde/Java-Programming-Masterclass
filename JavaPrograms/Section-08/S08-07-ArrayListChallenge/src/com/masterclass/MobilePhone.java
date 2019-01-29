package com.masterclass;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> contactList;

    public MobilePhone() {
        this.contactList = new ArrayList<Contact>();
    }

    public Result getStringContactList() {
        String list = "----------"
                + "\n\tList of " + contactList.size() + " contacts";
        for (int i = 0; i < contactList.size(); i++) {
            list += "\n\t" + (i + 1) + ". "
                + contactList.get(i).name + " : "
                + contactList.get(i).number ;
        }
        list += "\n----------";
        return new Result(true, list);
    }
    public Result addContact(Contact newContact) {
        if (newContact.name.equals("")) {
            return new Result(false
                    , "Name empty, contact not added");
        } else {
            contactList.add(newContact);
            return new Result(true
                    , newContact.name + " added");
        }
    }
    public Result modifyContact(Contact currentContact, Contact newContact) {
        int position = findContact(currentContact);
        if (position < 0) {
            return new Result(false
                    , currentContact.name + " not found");
        } else {
            contactList.set(position, newContact);
            return new Result(true
                    , newContact.name + " stored, replaced " + currentContact.name);
        }
    }
    public Result removeContact(Contact contact) {
        int position = findContact(contact);
        if (position < 0) {
            return new Result(false
                    , contact.name + " not found");
        } else {
            contactList.remove(position);
            return new Result(true
                    , contact.name + " removed");
        }
    }
    public Contact findContact(String findName) {
        Contact foundContact = new Contact();
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).name.equals(findName)) {
                foundContact = contactList.get(i);
                break;
            }
        }
        System.out.println(foundContact.name);
        return foundContact;
    }
    private int findContact(Contact contact) {
        return contactList.indexOf(contact);
    }
}
