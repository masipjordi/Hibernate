package test;

import dao.ServiceManager;
import metier.Service;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SessionFactory ;
		//ServiceManager man = null;
		Service serv = new Service(2,"caca","pipi");
		ServiceManager.save(serv);
		serv= ServiceManager.get(4);		
		System.out.println(serv.getInterlocuteur());
		

	}

}
