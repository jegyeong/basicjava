package dao;


import java.util.ArrayList;

import vo.CarOptionVo;
import vo.CoVehicleVo;
import Session.UserSession;
import database.Database;

public class CoVehicleDao {
	Database db = Database.getInstance();
	UserSession session = new UserSession();
	public ArrayList<String> rentableCompany(String series, String name){
		ArrayList<String> temp = new ArrayList<>();
		UserDao udao = new UserDao();
		for(int i = 0 ; i< db.coVehicleList.size(); i++){
			if(series.equals(db.coVehicleList.get(i).getvSeries())&& name.equals(db.coVehicleList.get(i).getvName())){
				boolean isNotPossible = true;
				for(int j = 0; j < udao.allRentedList().size(); j++) {
					if(db.coVehicleList.get(i).getCoVNumber().equals(udao.allRentedList().get(j).getRentVNum())
							&&udao.allRentedList().get(j).getActualReturnDate()=="") {
						isNotPossible = false;
					}
				}
				if(!temp.contains(db.coVehicleList.get(i).getCoSerialNum())&& isNotPossible ==true){
		            temp.add(db.coVehicleList.get(i).getCoSerialNum());
		        }
			}
		}
		return temp;
	}
	public CarOptionVo getRentCarOptions(String rentVNum){
		CarOptionVo cvo = null;
		for(int i = 0; i< db.carOptionList.size(); i++){
			if(db.carOptionList.get(i).getRentVNUm().equals(rentVNum)) {
				cvo = new CarOptionVo();
				cvo.setRentVNUm(rentVNum);
				cvo.setDriveAirBag(db.carOptionList.get(i).getDriveAirBag());
				cvo.setAssistantAirBag(db.carOptionList.get(i).getAssistantAirBag());
				cvo.setRearCamera(db.carOptionList.get(i).getRearCamera());
				cvo.setBlackBox(db.carOptionList.get(i).getBlackBox());
				cvo.setRearSensor(db.carOptionList.get(i).getRearSensor());
				cvo.setFourWD(db.carOptionList.get(i).getFourWD());
				cvo.setNavigation(db.carOptionList.get(i).getNavigation());
				cvo.setRemoteKey(db.carOptionList.get(i).getRemoteKey());
				cvo.setSmartKey(db.carOptionList.get(i).getSmartKey());
				cvo.setHeatingSeat(db.carOptionList.get(i).getHeatingSeat());
				cvo.setCoolingSeat(db.carOptionList.get(i).getCoolingSeat());
				cvo.setSunRoof(db.carOptionList.get(i).getSunRoof());
				cvo.setBluetooth(db.carOptionList.get(i).getBluetooth());
				
				return cvo;
				
			}
		}
		
		return cvo;
	}
	
	public void getCarOptionList(String vNum){
		for(int i = 0; i< db.carOptionList.size(); i++){
			if(db.carOptionList.get(i).getRentVNUm().equals(vNum)) {
			System.out.println(" 옵션\n" + 
								" 운저석 에어백 : " + db.carOptionList.get(i).getDriveAirBag() + "\n"+
								" 조수석 에어백 : " + db.carOptionList.get(i).getAssistantAirBag() + "\n"+
								" 후방카메라     : " + db.carOptionList.get(i).getRearCamera() + "\n"+
								" 후방센서        : " + db.carOptionList.get(i).getRearSensor() + "\n"+
								" 블랙박스        : " + db.carOptionList.get(i).getBlackBox() +"\n"+
								" 후륜구동        : " + db.carOptionList.get(i).getFourWD() +"\n"+
								" 네비게이션     : " + db.carOptionList.get(i).getNavigation() +"\n"+
								" 리모트키        : " + db.carOptionList.get(i).getRemoteKey() +"\n"+
								" 스마트키        : " + db.carOptionList.get(i).getSmartKey() +"\n"+
								" 열선시트        : " + db.carOptionList.get(i).getHeatingSeat() +"\n"+
								" 통풍시트        : " + db.carOptionList.get(i).getCoolingSeat() +"\n"+
								" 선루프           : " + db.carOptionList.get(i).getSunRoof() +"\n"+
								" 블루투스        : " + db.carOptionList.get(i).getBluetooth());
								break;
			}
		}
		
	}
	public ArrayList<CarOptionVo> settingCarOptionList() {
		return db.carOptionList;
	}
	public String getCoSerialNum(String loginId){
		CompanyDao cdao = new CompanyDao();
		String coSerialNum = null;
		for(int i = 0; i < cdao.getCompanyList().size(); i++){
			if(loginId.equals(cdao.getCompanyList().get(i).getUserId())){
				coSerialNum = cdao.getCompanyList().get(i).getCoSerialNum();
				return coSerialNum;
			}
		}
		return coSerialNum;
	}
	public ArrayList<CoVehicleVo> getCoVehicleList(String coSerialNum){
		CoVehicleVo cvvo;
		ArrayList<CoVehicleVo> tempList = new ArrayList<>();
		
		for(int i = 0; i < db.coVehicleList.size(); i++){
			
			if(coSerialNum.equals(db.coVehicleList.get(i).getCoSerialNum())){
				cvvo = new CoVehicleVo();
				cvvo.setCoSerialNum(coSerialNum);
				cvvo.setCoVNumber(db.coVehicleList.get(i).getCoVNumber());
				cvvo.setvSeries(db.coVehicleList.get(i).getvSeries());
				cvvo.setvName(db.coVehicleList.get(i).getvName());
				cvvo.setRentPrice(db.coVehicleList.get(i).getRentPrice());
				
				tempList.add(cvvo);
				
			}
		}
		return tempList;
	}
	public ArrayList<CoVehicleVo> getCoVehicleList(){
		return db.coVehicleList;
	}
	public void deleteCoVehicle(int number){
		db.coVehicleList.remove(number);
	}
	public void updateCoVehileNumber(int select, String string){
		db.coVehicleList.get(select).setCoVNumber(string);
	}
	public void updateCoVehile(int select, String string, String str){
		db.coVehicleList.get(select).setvSeries(string);
		db.coVehicleList.get(select).setvName(str);
	}
	public void updateCoVehilePrice(int select, int update){
		db.coVehicleList.get(select).setRentPrice(update);
	}
	
	public String getUserType(String loginId){
		UserDao udo = new UserDao();
		String userId = null;
		for(int i = 0; i < udo.checkUserList().size(); i++){
			if(loginId.equals(udo.checkUserList().get(i).getUserId())){
				userId = udo.checkUserList().get(i).getUserId();
				return userId;
			}
		}
		return userId;
	}

}
