package com.sg.manulife.Logging;

public class AccountHandler {
  public void createSingleAccount(String accountName, String accountPhone) {
    if (String.isBlank(accountName)) {
      throw new IllegalArgumentException('Account name cannot be blank');
    }

    Account acc = new Account(Name = accountName, Phone = accountPhone);
    try {
      insert acc;
    } catch (DmlException e) {
      System.debug('Error inserting Account: ' + e.getMessage());
    }
  }

  public void updateAccountPhone(String accountId, String newPhone) {
    Account acc = [SELECT Id, Phone FROM Account WHERE Id = :accountId LIMIT 1];
    acc.Phone = newPhone;
    try {
      update acc;
    } catch (DmlException e) {
      System.debug('Error updating Account: ' + e.getMessage());
    }
  }

  public void deleteAccount(String accountId) {
    Account acc = [SELECT Id FROM Account WHERE Id = :accountId LIMIT 1];
    try {
      delete acc;
    } catch (DmlException e) {
      System.debug('Error deleting Account: ' + e.getMessage());
    }
  }
}