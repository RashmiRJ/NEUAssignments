/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author rashmirj
 */
public class TravelAgencyOrganization  extends Organization {
    public TravelAgencyOrganization(){
        super(Type.TravelAgency.getValue());      
    }
    
    @Override
    public ArrayList<String> getSupportedRole() {
        ArrayList<String> roles = new ArrayList<>();
        roles.add("TravelAgency");
        return roles;
    }
}
