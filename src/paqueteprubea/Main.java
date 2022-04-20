package paqueteprubea;

import java.awt.Point;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {

		HashMap<Point, Integer> map = new HashMap<Point, Integer>();

		map.put(new Point(1, 1), 3);

		System.out.println(map.containsKey(new Point(1, 1)));

//		HashSet<Point> hola= new HashSet();
//		
//		hola.add(new Point(1,1));
//		hola.add(new Point(1,2));
//		
//		System.out.println(hola.size());
//		

//		EstadoPlanta e1= new EstadoPlanta();
//		EstadoPlanta e2= new EstadoPlanta();
//		
//		
//		Zombie z1= new Zombie(1,2,1);
//		Zombie z2= new Zombie(2,2,1);
//		Zombie z3= new Zombie(3,2,1);
//		Zombie z4= new Zombie(4,2,1);
//		Zombie z5= new Zombie(4,2,1);
//		Zombie z7= new Zombie(3,2,1);
//		Zombie z8= new Zombie(2,2,1);
//
//		Point p1= new Point(1,1);
//		Point p2= new Point(2,1);
//		Point p3= new Point(4,1);
//		Point p4= new Point(5,1);
//		Point p5= new Point(1,1);
//		Point p6= new Point(3,1);
//		Point p7= new Point(1,6);
//		Point p8= new Point(4,4);
//		Point p9= new Point(4,4);
//		
//		HashMap<Point,Zombie> map1= new HashMap();
//		HashMap<Point,Zombie> map2= new HashMap();
//		HashMap<Point,Integer> g1= new HashMap();
//		HashMap<Point,Integer> g2= new HashMap();
//		g1.put(p9, 5);
//		g2.put(p8, 5);
//		
//		map1.put(p1, z1);
//		map1.put(p2, z2);
//		map1.put(p3, z3);
//		map1.put(p4, z4);
//
//		map2.put(p2,z8);
//		map2.put(p3,z7);
//		map2.put(p4,z5);
//	
//		e1.setZombies(map1);
//		e1.setCantidadZombies(10);
//		e1.setEnergia(10);
//		e1.setPosicion(p5);
//		e1.setGirasoles(g1);
//		e2.setZombies(map1);
//		e2.setCantidadZombies(10);
//		e2.setEnergia(10);
//		e2.setPosicion(p5);
//		e2.setGirasoles(g1);
//		
//		EstadoPlanta e3=(EstadoPlanta) e1.clone();
//		
//		System.out.println(e3.equals(e1));
//		System.out.println(e2.equals(e3));

	}

}
