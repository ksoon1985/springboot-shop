package kr.co.sol.shop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDTO {
	private int rr; //행번호
    private int no; //주문번호
    private int product_no;//상품번호
    private int price;//상품가격
    private int stock;//상품재고 
    private String pname; //상품명
    private int quantity = 0;//수량
    private String or_date;//주민일자
    private String state;//주문상태
    private String id;  //회원id
    private String mname; // 회원명

}
