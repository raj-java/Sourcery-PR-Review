package com.sg.manulife.Logging;

public class ContactHandler {
  public void createContact(String firstName, String lastName, String email, String accountId) {
    Contact con = new Contact(FirstName = firstName, LastName = lastName, Email = email, AccountId = accountId);
    try {
      insert con;
    } catch (DmlException e) {
      System.debug('Error inserting Contact: ' + e.getMessage());
    }
  }

  public List<Contact> getContactsByAccount(String accountId) {
    List<Contact> contactList = [SELECT Id, FirstName, LastName, Email FROM Contact WHERE AccountId = :accountId];
    return contactList;
  }

  public void updateContactEmail(String contactId, String newEmail) {
    Contact con = [SELECT Id, Email FROM Contact WHERE Id = :contactId LIMIT 1];
    con.Email = newEmail;
    try {
      update con;
    } catch (DmlException e) {
      System.debug('Error updating Contact: ' + e.getMessage());
    }
  }

  public void deleteContactsByAccount(String accountId) {
    List<Contact> contactList = [SELECT Id FROM Contact WHERE AccountId = :accountId];
    for (Contact con : contactList) {
      try {
        delete con;
      } catch (DmlException e) {
        System.debug('Error deleting Contact: ' + e.getMessage());
      }
    }
  }
}