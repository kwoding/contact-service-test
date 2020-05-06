package it.ding.contact.model;

import java.util.List;

public class ContactListGetResponseBody {

    private List<Contact> content;

    public List<Contact> getContent() {
        return content;
    }

    public void setContent(List<Contact> content) {
        this.content = content;
    }
}
