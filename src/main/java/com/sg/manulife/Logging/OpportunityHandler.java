package com.sg.manulife.Logging;

public class OpportunityHandler {
  public void createOpportunities(List<String> oppNames, String accountId) {
    List<Opportunity> oppList = new List<Opportunity>();
    for (String oppName : oppNames) {
      Opportunity opp = new Opportunity(Name = oppName, AccountId = accountId, CloseDate = Date.today().addDays(30), StageName = 'Prospecting');
      oppList.add(opp);
    }
    try {
      insert oppList;
    } catch (DmlException e) {
      System.debug('Error inserting Opportunities: ' + e.getMessage());
    }
  }

  public void updateOpportunitiesStage(String accountId, String newStage) {
    List<Opportunity> oppList = [SELECT Id, StageName FROM Opportunity WHERE AccountId = :accountId];
    for (Opportunity opp : oppList) {
      opp.StageName = newStage;
      try {
        update opp;
      } catch (DmlException e) {
        System.debug('Error updating Opportunity: ' + e.getMessage());
      }
    }
  }

  public void deleteOpportunities(String accountId) {
    List<Opportunity> oppList = [SELECT Id FROM Opportunity WHERE AccountId = :accountId];
    for (Opportunity opp : oppList) {
      try {
        delete opp;
      } catch (DmlException e) {
        System.debug('Error deleting Opportunity: ' + e.getMessage());
      }
    }
  }
}