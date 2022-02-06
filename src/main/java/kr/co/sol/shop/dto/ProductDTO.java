package kr.co.sol.shop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
    private int rr;
	private int no;
    private String stock;
    private String price;
    private String name;
    private String detail;
    private String pr_date;
    private String image="";
    private String path;

}
