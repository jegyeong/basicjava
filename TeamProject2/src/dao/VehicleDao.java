package dao;

import java.util.ArrayList;

import vo.VehicleNameVo;
import vo.VehicleSeriesVo;
import database.Database;

public class VehicleDao {

	Database db = Database.getInstance();
	
	public ArrayList<VehicleSeriesVo> showVSeriesList() {
		return db.vSeriesList;	//시리즈 리스트
	}
	
	public ArrayList<VehicleNameVo> showVNameList(int index) {		//시리즈 리스트를 선택한다음에 차종 리스트
		ArrayList<ArrayList<VehicleNameVo>> vnvArray = db.vNameList;
		ArrayList<VehicleNameVo> returnArray = new ArrayList<>();
		for(int j = 0; j<vnvArray.get(index).size();j++){
			VehicleNameVo vvo = new VehicleNameVo();
			vvo.setIndex(vnvArray.get(index).get(j).getIndex());
			vvo.setvName(vnvArray.get(index).get(j).getvName());
			returnArray.add(vvo);
		}
		return returnArray;
	}
	
	
	
	
}
