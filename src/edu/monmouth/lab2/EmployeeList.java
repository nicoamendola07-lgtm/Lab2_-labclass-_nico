package edu.monmouth.lab2;

import edu.monmouth.employee.*;

public class EmployeeList {
	private EmployeeNode head;

	public EmployeeList() {
		head = null;
	}

	public void add(MuEmployee element) {
		//CREATE THE NEW NODE, SET prev as null--(inserting at beginning)
		EmployeeNode newNode = new EmployeeNode(element);
		newNode.setPrevious(null);
		
		//CHECK IF LIST IS CURRENTLY EMPTY
		if (isEmpty()) {
			head = newNode;
			return;
		}//if -- (empty list)
		
		//CONNECT NODES
		newNode.setNext(head);
		head.setPrevious(newNode);
		
		//CHANGE HEAD
		head = newNode;
	}
	
	public boolean find(MuEmployee employee) {
		if (isEmpty()) return false;
	    for (EmployeeNode curr=head; curr!=null; curr=curr.getNext()) {
	    	if (curr.getInfo().equals(employee)) return true;
	    }//for -- (node in link)
	   	return false;
	}
	
	public String printReverse() {
		//CHECK IF LIST IS EMPTY, IF NOT, GET TAIL
		if (isEmpty()) return "List is empty!";
		EmployeeNode tail = getTail();
		
		//ADD EVERY ELEMENT TO STRINGBUILDER (reverse)
		StringBuilder sb = new StringBuilder();
		for (EmployeeNode curr=tail; curr!=null; curr=curr.getPrevious()) {
			sb.append(curr.getInfo().toString()+' ');
		}//for -- (node in link)
		
		return sb.toString();
	}
	
	public EmployeeNode getTail() {
		if (head==null) return null;
		EmployeeNode tail = null;
		for (EmployeeNode curr=head; curr!=null; curr=curr.getNext()) {
			if (curr.getNext()==null) tail = curr;
		}//for -- (node in link)
		return tail;
	}
	
	@Override
	public String toString() {
		if (isEmpty()) return "List is empty!";
		StringBuilder sb = new StringBuilder();
		for (EmployeeNode curr=head; curr!=null; curr=curr.getNext()) {
			sb.append(curr.getInfo().toString()+' ');
		}//for -- (node in link)
		return sb.toString();
	}
	
	public boolean isEmpty() {
		if (head==null) return true;
		else return false;
	}
}