package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Calendar; //30일 지난 마일리지를 삭제하는 기능을 구현할떄 필요한 improt
//import java.util.Date; //30일 지난 마일리지를 삭제하는 기능을 구현할떄 필요한 improt

import vo.MileageVo;
import dao.MileageDao;
import data.Session;



public class Mileage {
	public static void printMileageInfo(){
		MileageDao mileagedao = MileageDao.getInstance();
		
		
		ArrayList<MileageVo> mileageList = mileagedao.searchUserMileage(Session.loginUser.getId());
		
		for(int i = 0 ; i < mileageList.size()-1;i++){
			for(int j = i ; j < mileageList.size();j++){
				if(mileageList.get(i).getDate().compareTo(mileageList.get(j).getDate())==1){
					MileageVo temp = mileageList.get(i);
					mileageList.set(i, mileageList.get(j));
					mileageList.set(j, temp);
				}
			}
		}
		
		
		
		int sum = 0;
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
		
		
		System.out.println("---------------------------------------------------");
		System.out.println("날짜\t\t\t내용\t\t획득마일리지");
		for(int i = 0; i < mileageList.size();i++){
				String time = format.format(mileageList.get(i).getDate());
				System.out.print(time+"\t");
				if(mileageList.get(i).getContents().length()>6){
					System.out.print(mileageList.get(i).getContents()+"\t");
				}else{
					System.out.print(mileageList.get(i).getContents()+"\t\t");
				}
				System.out.println(mileageList.get(i).getMiliage());
				sum+=mileageList.get(i).getMiliage();
		}
		
		System.out.println("보유 마일리지 : "+sum);
		System.out.println("---------------------------------------------------");
		
		
	}

}
