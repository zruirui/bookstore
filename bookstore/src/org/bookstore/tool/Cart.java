package org.bookstore.tool;

import java.util.HashMap;
import java.util.Map;

import javassist.bytecode.Descriptor.Iterator;

import org.bookstore.model.Orderitem;

public class Cart {

	protected Map<Integer,Orderitem> items; 

	public Map<Integer, Orderitem> getItems() {
		return items;
	}

	public void setItems(Map<Integer, Orderitem> items) {
		this.items = items;
	}

	public Cart() {
		if(items==null){
			items=new HashMap<Integer,Orderitem>();
		}
	}
	
	//���ͼ�鵽���ﳵ
	public void addBook(Integer bookid,Orderitem orderitem){
		//�Ƿ���ڣ�������ڣ�������������������ڣ���ӽ�����
		if(items.containsKey(bookid)){
			Orderitem _orderitem=items.get(bookid);
			orderitem.setQuantity(_orderitem.getQuantity()+orderitem.getQuantity());
			items.put(bookid,orderitem);
		}else{
			items.put(bookid,orderitem);
		}
	}
	
	//���¹���ͼ�������
	public void updateCart(Integer bookid, int quantity) {
		Orderitem orderitem1=items.get(bookid);
		orderitem1.setQuantity(quantity);
		items.put(bookid, orderitem1);
	}
	
	//��ȡ�����ܽ��
	public int getTotalPrice() {
		int totalPrice=0;
		for(java.util.Iterator<Orderitem> it=items.values().iterator();it.hasNext();){
			Orderitem orderitem=(Orderitem)it.next();
			totalPrice+=orderitem.getBook().getPrice()*orderitem.getQuantity();
		}
		return totalPrice;
	}
}
