package com.Arrays;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
	
	public static void main(String[] args) {
		
		
		//Array List Syntax
		//List<datatype>arraylistName = new ArrayList<datatype>();
		
		List<Object>arrayList1 = new ArrayList<Object>();
		
		arrayList1.add(10);
		arrayList1.add("Rajitha");
		/*
		System.out.println(arrayList1.get(0));
		System.out.println(arrayList1.get(1));
		*/
		
		for(Object index : arrayList1)
			
		{
		
		System.out.println(index);
	    }
	
		System.out.println("=================");
		
		
		for(int index=0;index<arrayList1.size();index++)
		{
			System.out.println(arrayList1.get(index));
		}

}
}
