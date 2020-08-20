package dao;

import java.util.ArrayList;

import vo.CoVehicleVo;
import vo.CompanyVo;
import database.Database;

public class CompanyDao {
	

   Database database = Database.getInstance();

   public void insertCompany(CompanyVo cvo){
	   database.companyList.add(cvo);
   }
    public ArrayList<CompanyVo> getCompanyList(){
       return database.companyList;
   }
    
   
	
}
