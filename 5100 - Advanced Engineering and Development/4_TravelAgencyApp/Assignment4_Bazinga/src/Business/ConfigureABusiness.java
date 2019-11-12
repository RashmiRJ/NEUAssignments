/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import Business.Employee.Employee;
import Business.Organization.AdminOrganization;
import Business.Organization.TravelAgencyOrganization;
import Business.UserAccount.UserAccount;

/**
 *
 * @author rashmirj
 */
public class ConfigureABusiness {
       public static Business configure(){       
        
        Business business = Business.getInstance();     
        
        //ADMIN
        AdminOrganization adminOrganization  = new AdminOrganization();
        business.getOrganizationDirectory().getOrganizationList().add(adminOrganization);        
        Employee emp = new Employee();
        emp.setName("John");        
        UserAccount account = new UserAccount();
        account.setUsername("admin");
        account.setPassword("admin");
        account.setRole("Admin");
        account.setEmployee(emp);
        adminOrganization.getEmployeeDirectory().getEmployeeList().add(emp);
        adminOrganization.getUserAccountDirectory().getUserAccountList().add(account);
        
        //DOCTOR        
        TravelAgencyOrganization taOrg = new TravelAgencyOrganization();
        business.getOrganizationDirectory().getOrganizationList().add(taOrg);
        Employee emp2 = new Employee();
        emp2.setName("Jacob");        
        UserAccount account2 = new UserAccount();
        account2.setUsername("agent");
        account2.setPassword("agent");
        account2.setRole("TravelAgency");
        account2.setEmployee(emp2);
        taOrg.getEmployeeDirectory().getEmployeeList().add(emp2);
        taOrg.getUserAccountDirectory().getUserAccountList().add(account2);
        
        return business;
    }
    
}
