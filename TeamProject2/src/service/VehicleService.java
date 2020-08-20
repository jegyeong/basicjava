package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import vo.VehicleNameVo;
import vo.VehicleSeriesVo;
import dao.VehicleDao;

public class VehicleService {
	VehicleDao vdao = new VehicleDao(); //database 객체에 싱글톤 패턴을 적용
	public HashMap<String,String> searchVehicles() {
		VehicleSeriesVo vo = gettingSeries();
		VehicleNameVo no = gettingVName(vo.getIndex());
		String vSeries = vo.getvSeries();
		String vName = no.getvName();
		HashMap<String,String> map = new HashMap<>();
		map.put("series",vSeries);
		map.put("name",vName);
		return map;
	}
	public VehicleSeriesVo gettingSeries(){
		boolean isCorrect = false;
		VehicleSeriesVo  vSeries = new VehicleSeriesVo();
		ArrayList<VehicleSeriesVo> vs = vdao.showVSeriesList();
		int select;
		do{
		System.out.println("차량 검색을 선택 하셨습니다.");
		System.out.println("원하시는 차량 유형을 선택해 주세요.");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓\n");
		for(int i = 0; i< vs.size(); i++){
			System.out.println(i+1 +" : "+ vs.get(i).getvSeries());
		}
		
		System.out.println("\n〓〓〓〓〓〓〓〓〓〓〓〓");
		Scanner scan = new Scanner(System.in);
		select = Integer.parseInt(scan.nextLine());
		if(select>=1&&select<=5){
			System.out.println(select +" 번을 선택하셨습니다.");
			vSeries.setIndex(vs.get(select-1).getIndex());
			vSeries.setvSeries(vs.get(select-1).getvSeries());
			isCorrect = true;
		}else{
			System.out.println("번호가 잘못되었습니다. 다시 선택하여 주십시요.");
		}
		
		}while(isCorrect == false);
		return vSeries;
	}
	public VehicleNameVo gettingVName(int select){
		boolean isCorrect = false;
		VehicleNameVo vName = new VehicleNameVo();
		ArrayList<VehicleNameVo> vNameList = vdao.showVNameList(select-1);
		Scanner scan = new Scanner(System.in);
		int selectName;
		do{
		System.out.println("원하시는 차종을 선택해 주세요.");
		
		for(int i = 0; i<vNameList.size();i++){
			System.out.println(vNameList.get(i).getIndex() + " : " + vNameList.get(i).getvName());
		}
		selectName = Integer.parseInt(scan.nextLine());
		if(selectName >=1 && selectName <= vNameList.size()){
		vName.setIndex(vNameList.get(selectName-1).getIndex());
		vName.setvName(vNameList.get(selectName-1).getvName());
		isCorrect = true;
		}else{
			System.out.println("번호가 잘못되었습니다. 다시 선택하여 주십시요.");
		}
		}while(!isCorrect);
		return vName;
	}
	


}
